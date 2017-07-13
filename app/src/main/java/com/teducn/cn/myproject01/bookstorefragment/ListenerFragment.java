package com.teducn.cn.myproject01.bookstorefragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teducn.cn.myproject01.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListenerFragment extends Fragment {


    public ListenerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listener, container, false);
    }

}
