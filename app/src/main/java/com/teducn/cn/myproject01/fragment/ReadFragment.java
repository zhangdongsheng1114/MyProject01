package com.teducn.cn.myproject01.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.ui.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadFragment extends Fragment {

    @BindView(R.id.imageView_Add)
    ImageButton ib_add;
    @BindView(R.id.imageView_Search)
    ImageButton ib_search;

    Integer[] images = {R.drawable.timg, R.drawable.timg01, R.drawable.timg02,
            R.drawable.timg03, R.drawable.timg04, R.drawable.timg05, R.drawable.timg06, R.drawable.timg07};

    @BindView(R.id.menu_layout)
    View menuLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read_layout, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridView_books);
        ImageAdapter imageAdapter = new ImageAdapter();
        gridView.setAdapter(imageAdapter);
        ButterKnife.bind(getActivity());
        ib_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });
        ib_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuLayout.setVisibility(View.VISIBLE);
            }
        });
        return view;
    }

    class ImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(16, 16, 16, 16);
            int imgResId = images[position];
            imageView.setImageResource(imgResId);
            return imageView;
        }
    }

}



