package com.smartbus.heze.main.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.welcome.activity.LoginActivity;

import org.litepal.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 * 个人中心
 */

public class Fragment04 extends Fragment {
    View view;
    @BindView(R.id.tvmyName)
    TextView tvmyName;
    @BindView(R.id.myinform)
    LinearLayout myinform;
    @BindView(R.id.tvMyStatus)
    TextView tvMyStatus;
    @BindView(R.id.studyArchives)
    LinearLayout studyArchives;
    @BindView(R.id.tvVersion)
    TextView tvVersion;
    @BindView(R.id.btnQuit)
    Button btnQuit;
    Unbinder unbinder;
    SharedPreferencesHelper sharedPreferencesHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment04, container, false);
        unbinder = ButterKnife.bind(this, view);
        sharedPreferencesHelper = new SharedPreferencesHelper(getActivity(),"login");
        String myNamemyName = sharedPreferencesHelper.getData(getActivity(), "userName1","");
        tvmyName.setText(myNamemyName);
        String versionName = getLocalVersionName(getActivity());
        tvVersion.setText(versionName);
        return view;
    }

    /**
     * 获取本地软件版本号名称
     */
    public static String getLocalVersionName(Context ctx) {
        String localVersion = "";
        try {
            PackageInfo packageInfo = ctx.getApplicationContext().getPackageManager().getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionName;
            LogUtil.d("TAG", "本软件的版本号。。" + localVersion);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnQuit)
    public void onViewClicked() {
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }
}
