package com.smartbus.heze.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.exam.bean.OnLineList;
import com.smartbus.heze.exam.module.OnLineListContract;
import com.smartbus.heze.exam.presenter.OnLineListPresenter;
import com.smartbus.heze.http.base.AlertDialogUtil;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnLineActivity extends BaseActivity implements OnLineListContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter baseRecyclerAdapter;
    OnLineListPresenter onLineListPresenter;
    List<OnLineList .ResultBean>beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        onLineListPresenter = new OnLineListPresenter(this,this);
        String userName = new SharedPreferencesHelper(this,"login").getData(this,"userName","");
        onLineListPresenter.getOnLineList("0","0",userName);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_on_line;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setOnLineList(OnLineList s) {
        if (s.isSuccess()){
            for (int i = 0;i<s.getResult().size();i++){
                beanList.add(s.getResult().get(i));
            }
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<OnLineList.ResultBean>(this,R.layout.adapter_online_item,beanList) {
            @Override
            public void convert(BaseViewHolder holder, final OnLineList.ResultBean o) {
                holder.setText(R.id.tvName,o.getExaminationName());
                holder.setText(R.id.tvStartTime,o.getBeginDate());
                holder.setText(R.id.tvEndTime,o.getEndDate());
                holder.setOnClickListener(R.id.ll, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //获取当前时间
                        Date date = new Date(System.currentTimeMillis());
                        String currentTime = simpleDateFormat.format(date);
                        int timeType = compare_date(currentTime,o.getBeginDate());
                        if (timeType==-1){
                            new AlertDialogUtil(OnLineActivity.this).showSmallDialog("未到考试时间");
                        }
                        if (timeType==1){
                            new AlertDialogUtil(OnLineActivity.this).showSmallDialog("考试时间已结束");
                        }
                    }
                });
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setOnLineListMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public static int compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                System.out.println("dt1 在dt2前");
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                System.out.println("dt1在dt2后");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
