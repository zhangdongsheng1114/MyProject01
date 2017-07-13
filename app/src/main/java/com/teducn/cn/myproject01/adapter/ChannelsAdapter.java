package com.teducn.cn.myproject01.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.entity.Channels;

import java.util.List;


/**
 * Created by tarena on 2017/5/28.
 */

public class ChannelsAdapter extends ArrayAdapter<Channels> {
    private int resourceId;

    // 重写构造方法，用于将上下文，ListView子项布局的id和数据传过来
    public ChannelsAdapter(Context context, int textViewResourceId, List<Channels> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    // 重写getView方法，这个方法在每个子项被滚动到屏幕内的时候会被调用
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获得当前项Channels实例
        Channels channels = getItem(position);
        Channels right = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            // 如果convertView为空，则使用LayoutInflater加载布局，创建一个viewHolder对象
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.channelsImage = (ImageView) view.findViewById(R.id.image_channels);
            viewHolder.channelsName = (TextView) view.findViewById(R.id.text_channels);
            viewHolder.rightImage = (ImageView) view.findViewById(R.id.image_Right);
            // 将viewHolder存储在view中
            view.setTag(viewHolder);
        } else {
            // 否则直接对convertView进行重用
            view = convertView;
            // 重新获取ViewHolder
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.channelsImage.setImageResource(channels.getImageId());
        viewHolder.channelsName.setText(channels.getName());
        viewHolder.rightImage.setImageResource(right.getImageId());

        return view;
    }

    // 增加内部类，用于对控件的实例进行缓存
    class ViewHolder{
        ImageView channelsImage;
        TextView channelsName;
        ImageView rightImage;
    }
}
