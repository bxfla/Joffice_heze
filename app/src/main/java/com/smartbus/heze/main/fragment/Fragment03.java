package com.smartbus.heze.main.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartbus.heze.R;

/**
 * Created by Administrator on 2019/4/12.
 * 站点查询
 */

public class Fragment03 extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment03, container, false);
        return view;
    }
}
