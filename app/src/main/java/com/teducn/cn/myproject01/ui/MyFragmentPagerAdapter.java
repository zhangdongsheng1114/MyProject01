package com.teducn.cn.myproject01.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarena on 2017/5/26.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // 封装一个集合，用来保存要适配的fragment
    private List<Fragment> fragments = new ArrayList<Fragment>();

    // 获得一个fragment添加到集合中
    public void addFragment(Fragment fragment) {
        if (fragment != null) {
            fragments.add(fragment);
            notifyDataSetChanged();
        }
    }

    // 从集合中获得一个适配项
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    // 计算适配的元素的个数
    @Override
    public int getCount() {
        return fragments.size();
    }
}
