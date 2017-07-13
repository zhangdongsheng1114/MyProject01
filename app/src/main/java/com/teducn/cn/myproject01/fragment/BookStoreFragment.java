package com.teducn.cn.myproject01.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.bookstorefragment.CityFragment;
import com.teducn.cn.myproject01.bookstorefragment.ComicsFragment;
import com.teducn.cn.myproject01.bookstorefragment.FantasyFragment;
import com.teducn.cn.myproject01.bookstorefragment.FeaturedFragment;
import com.teducn.cn.myproject01.bookstorefragment.FreeFragment;
import com.teducn.cn.myproject01.bookstorefragment.ListenerFragment;
import com.teducn.cn.myproject01.bookstorefragment.MagazineFragment;
import com.teducn.cn.myproject01.bookstorefragment.PublishFragment;
import com.teducn.cn.myproject01.bookstorefragment.RomanceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookStoreFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyAdapter myAdapter;

    public BookStoreFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookstore_layout, null);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayoutId);
        viewPager = (ViewPager) view.findViewById(R.id.viewPagerId);
        myAdapter = new MyAdapter(getFragmentManager());
        viewPager.setAdapter(myAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }


    class MyAdapter extends FragmentPagerAdapter {
        String[] titles = {"精选", "出版", "漫画", "免费", "都市",
                "玄幻", "言情", "听书", "杂志"};

        List<Fragment> fragmentList = new ArrayList<>();

        public MyAdapter(FragmentManager fm) {
            super(fm);
            fragmentList.add(new FeaturedFragment());
            fragmentList.add(new PublishFragment());
            fragmentList.add(new ComicsFragment());
            fragmentList.add(new FreeFragment());
            fragmentList.add(new CityFragment());
            fragmentList.add(new FantasyFragment());
            fragmentList.add(new RomanceFragment());
            fragmentList.add(new ListenerFragment());
            fragmentList.add(new MagazineFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
