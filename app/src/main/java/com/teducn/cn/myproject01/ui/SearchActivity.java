package com.teducn.cn.myproject01.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import com.teducn.cn.myproject01.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String, Object>> data_list;
    private SimpleAdapter sim_adapter;

    ImageButton imageButton;
    String[] titles = new String[]{"特工皇妃", "重生之千金归来", "现代言情", "古代言情", "摄政王的小狼妃",
            "校园修真高手", "霸道总裁深深宠", "恶魔少爷别吻我", "豪门天价前妻", "闪婚总裁契约妻"};
    Integer[] images = {R.mipmap.one, R.mipmap.two, R.mipmap.three, R.mipmap.fore, R.mipmap.five,
            R.mipmap.six, R.mipmap.seven, R.mipmap.eight, R.mipmap.nine, R.mipmap.ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imageButton = (ImageButton) findViewById(R.id.imageView_back);
        gridView = (GridView) findViewById(R.id.gridViewId);
        data_list = new ArrayList<Map<String, Object>>();
        getData();
        String[] from = {"image", "text"};
        int[] to = {R.id.image, R.id.text};
        gridView.setAdapter(new ImageAdapter(this));
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    public void Back(View view) {
        finish();
    }

    public List<Map<String, Object>> getData() {
        for (int i = 0; i < images.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", images[i]);
            map.put("text", titles[i]);
            data_list.add(map);
        }
        return data_list;
    }
}

