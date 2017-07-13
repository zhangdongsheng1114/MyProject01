package com.teducn.cn.myproject01.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.teducn.cn.myproject01.R;
import com.teducn.cn.myproject01.fragment.BookStoreFragment;
import com.teducn.cn.myproject01.fragment.FindFragment;
import com.teducn.cn.myproject01.fragment.MyFragment;
import com.teducn.cn.myproject01.fragment.ReadFragment;


public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    MyFragmentPagerAdapter adapter = null;
    ReadFragment read_fragment;
    BookStoreFragment bookStore_fragment;
    FindFragment find_fragment;
    RadioGroup radioGroup;
    Fragment my_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initiaFragments();
        setListener();

    }


    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        // 第一个页面被选中，把第一个单选按钮的选中状态设置真
                        radioGroup.check(R.id.radioButton_read);
                        break;
                    case 1:
                        radioGroup.check(R.id.radioButton_bookstore);
                        break;
                    case 2:
                        radioGroup.check(R.id.radioButton_find);
                        break;
                    case 3:
                        radioGroup.check(R.id.radioButton_my);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        // 为radioGroup添加监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton_read:
                        viewPager.setCurrentItem(0, true);
                        break;
                    case R.id.radioButton_bookstore:
                        viewPager.setCurrentItem(1, false);
                        break;
                    case R.id.radioButton_find:
                        viewPager.setCurrentItem(2, false);
                        break;
                    case R.id.radioButton_my:
                        viewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
    }

    private void initiaFragments() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_Bottom);
        viewPager = (ViewPager) findViewById(R.id.veiwPager_Main);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        read_fragment = new ReadFragment();
        bookStore_fragment = new BookStoreFragment();
        find_fragment = new FindFragment();
        my_fragment = new MyFragment();

        //将创建好fragment添加到适配器集合中

        viewPager.setAdapter(adapter);

        adapter.addFragment(read_fragment);
        adapter.addFragment(bookStore_fragment);
        adapter.addFragment(find_fragment);
        adapter.addFragment(my_fragment);
        //设置viewpager当前选中项
        viewPager.setCurrentItem(0, true);
    }
}
