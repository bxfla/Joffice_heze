package com.smartbus.heze.checkup.activity_history;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.HealthHistory;
import com.smartbus.heze.checkup.bean.HealthHistoryItem;
import com.smartbus.heze.checkup.module.HealthHistoryItemContract;
import com.smartbus.heze.checkup.presenter.HealthHistoryItemPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HealthHistoryDetActivity extends BaseActivity implements HealthHistoryItemContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvCarCode)
    TextView tvCarCode;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvPersonCode)
    TextView tvPersonCode;
    @BindView(R.id.tvPersonName)
    TextView tvPersonName;
    @BindView(R.id.tvRummager)
    TextView tvRummager;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String workId = "";
    HealthHistory.ResultBean bean;
    BaseRecyclerAdapter baseRecyclerAdapter;
    List<HealthHistoryItem.ResultBean> beanList = new ArrayList<>();
    HealthHistoryItemPresenter healthHistoryItemPresenter;
    @BindView(R.id.tvRemarks)
    TextView tvRemarks;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll4)
    LinearLayout ll4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        bean = (HealthHistory.ResultBean) getIntent().getSerializableExtra("bean");
        workId = String.valueOf(bean.getId());
        tvLine.setText(bean.getLineCode());
        tvCarNo.setText(bean.getCarNo());
        tvCarCode.setText(bean.getBusCode());
        tvPersonCode.setText(bean.getDriverId());
        tvPersonName.setText(bean.getDriverName());
        tvRummager.setText(bean.getExaminer());
        tvRemarks.setText(bean.getNote());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        healthHistoryItemPresenter = new HealthHistoryItemPresenter(this, this);
        healthHistoryItemPresenter.getHealthHistoryItem(workId);
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.activity_rcjchistory;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    @Override
    public void setHealthHistoryItem(HealthHistoryItem s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<HealthHistoryItem.ResultBean>(this, R.layout.adapter_chlid_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, HealthHistoryItem.ResultBean resultBean) {
                holder.setText(R.id.textView, resultBean.getProjectName());
                holder.setText(R.id.editText, resultBean.getScoreNums());
                String statue = String.valueOf(resultBean.getState());
                if (statue.equals("1")) {
                    holder.setCheck(R.id.rb1);
                }
                if (statue.equals("0")) {
                    holder.setCheck(R.id.rb2);
                }
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setHealthHistoryItemMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
