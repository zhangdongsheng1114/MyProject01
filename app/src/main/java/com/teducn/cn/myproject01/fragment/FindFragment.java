package com.teducn.cn.myproject01.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.adapter.ChannelsAdapter;
import com.teducn.cn.myproject01.entity.Channels;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FindFragment extends Fragment {
    private List<Channels> channels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_layout, container, false);

        // 初始化频道数据
        initChannels();
        ChannelsAdapter adapter = new ChannelsAdapter(getActivity(), R.layout.channels_item, channels);
        final ListView listView = (ListView) view.findViewById(R.id.listView_find);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 通过position参数判断用户点击的是哪一个子项
                Channels channel = channels.get(position);
                Toast.makeText(getActivity(), channel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initChannels() {
        Channels circle = new Channels("圈子", R.mipmap.circle, R.mipmap.ic_arrow_right);
        channels.add(circle);
        Channels free = new Channels("今日免费", R.mipmap.free, R.mipmap.ic_arrow_right);
        channels.add(free);
        Channels check = new Channels("签到", R.mipmap.check, R.mipmap.ic_arrow_right);
        channels.add(check);
        Channels task = new Channels("任务", R.mipmap.task, R.mipmap.ic_arrow_right);
        channels.add(task);
        Channels activity = new Channels("活动", R.mipmap.activity, R.mipmap.ic_arrow_right);
        channels.add(activity);
        Channels book = new Channels("电子书", R.mipmap.ebook, R.mipmap.ic_arrow_right);
        channels.add(book);
        Channels game = new Channels("游戏", R.mipmap.game, R.mipmap.ic_arrow_right);
        channels.add(game);
    }

}
