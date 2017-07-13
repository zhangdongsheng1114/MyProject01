package com.teducn.cn.myproject01.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.adapter.MyAdapter;
import com.teducn.cn.myproject01.entity.My;
import com.teducn.cn.myproject01.ui.LoginActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private List<My> myList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_layout, container, false);
        // 初始化my的数据
        initMys();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        Button button = (Button) view.findViewById(R.id.button_logon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter(myList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    private void initMys() {
        My message = new My("消息", R.mipmap.message, R.mipmap.ic_arrow_right);
        myList.add(message);
        My account = new My("我的账户", R.mipmap.account, R.mipmap.ic_arrow_right);
        myList.add(account);
        My vip = new My("我的VIP", R.mipmap.vip, R.mipmap.ic_arrow_right);
        myList.add(vip);
        My gift = new My("我的礼品", R.mipmap.gift, R.mipmap.ic_arrow_right);
        myList.add(gift);
        My books = new My("我的书籍", R.mipmap.books, R.mipmap.ic_arrow_right);
        myList.add(books);
        My set = new My("设置", R.mipmap.set, R.mipmap.ic_arrow_right);
        myList.add(set);
        My preference = new My("我的阅读偏好", R.mipmap.preference, R.mipmap.ic_arrow_right);
        myList.add(preference);
        My night = new My("夜间模式", R.mipmap.night, R.mipmap.ic_arrow_right);
        myList.add(night);
        My help = new My("帮助与反馈", R.mipmap.help, R.mipmap.ic_arrow_right);
        myList.add(help);

    }

}
