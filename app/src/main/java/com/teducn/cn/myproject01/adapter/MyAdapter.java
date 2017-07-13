package com.teducn.cn.myproject01.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.entity.My;

import java.util.List;


/**
 * Created by tarena on 2017/5/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<My> mMyList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View myView;
        ImageView myImage;
        TextView myName;
//        ImageView myRightimage;

        public ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            myImage = (ImageView) itemView.findViewById(R.id.image_my);
            myName = (TextView) itemView.findViewById(R.id.text_my);
//            myRightimage = (ImageView) itemView.findViewById(R.id.image_Right);
        }
    }

    public MyAdapter(List<My> myList) {
        mMyList = myList;
    }

    // 用于常见ViewHolder实例
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取用户点击的position
                int position = holder.getAdapterPosition();
                // 通过position获得相应的实例
                My my = mMyList.get(position);
                Toast.makeText(v.getContext(), "you clicked view", Toast.LENGTH_SHORT).show();
            }
        });
        holder.myImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                My my = mMyList.get(position);
                Toast.makeText(v.getContext(), "you clicked image", Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    // 用于对RecyclerView子项的数据进行赋值，在每个子项被滚动到屏幕内的时候执行
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        My my = mMyList.get(position);
        holder.myImage.setImageResource(my.getMyimageId());
        holder.myName.setText(my.getMyname());
//        holder.myRightimage.setImageResource(my.getMyimageRightId());
    }

    // 返回RecyclerView的子项总个数
    @Override
    public int getItemCount() {
        return mMyList.size();
    }
}
