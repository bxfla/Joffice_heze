package com.smartbus.heze.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.smartbus.heze.R;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.oaflow.activity.WillDoListActivity;
import com.smartbus.heze.oaflow.activity.WillDoListActivity2;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 * 待办列表
 */

public class Fragment02 extends Fragment {
    View view;
    Unbinder unbinder;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
//        beanList.clear();
//        willDoListPresenter.getWillDoList();
    }

    @OnClick({R.id.ll1, R.id.ll2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                intent = new Intent(getActivity(), WillDoListActivity.class);
                startActivity(intent);
                break;
            case R.id.ll2:
                intent = new Intent(getActivity(), WillDoListActivity2.class);
                startActivity(intent);
                break;
        }
    }
}
