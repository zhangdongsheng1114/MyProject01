package com.teducn.cn.myproject01.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.ui.SearchActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReadFragment extends Fragment {

    @BindView(R.id.menu_layout)
    View menuLayout;

    @OnClick(R.id.imageView_Search)
    public void search(View view) {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.imageView_Add)
    public void addBooks(View view) {
        if (menuLayout.getVisibility() == View.VISIBLE) {
            menuLayout.setVisibility(View.INVISIBLE);
        } else {
            menuLayout.setVisibility(View.VISIBLE);
        }
    }

    private Integer[] images = {R.drawable.timg, R.drawable.timg01, R.drawable.timg02,
            R.drawable.timg03, R.drawable.timg04};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_read_layout, container, false);
        ButterKnife.bind(getActivity());
        return view;
    }
}



