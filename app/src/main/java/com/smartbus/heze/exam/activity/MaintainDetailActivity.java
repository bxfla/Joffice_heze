package com.smartbus.heze.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.Maintain;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaintainDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvCarCode)
    TextView tvCarCode;
    @BindView(R.id.tvNum)
    TextView tvNum;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvMaintainNum)
    TextView tvMaintainNum;
    @BindView(R.id.tvCarType)
    TextView tvCarType;
    @BindView(R.id.tvNengHao)
    TextView tvNengHao;
    @BindView(R.id.tvWXG)
    TextView tvWXG;
    @BindView(R.id.tvBXLX)
    TextView tvBXLX;
    @BindView(R.id.tvZT)
    TextView tvZT;
    @BindView(R.id.tvLX)
    TextView tvLX;
    @BindView(R.id.tvReason)
    TextView tvReason;
    @BindView(R.id.tvBXSJ)
    TextView tvBXSJ;
    @BindView(R.id.tvPGSJ)
    TextView tvPGSJ;
    @BindView(R.id.tvWGSJ)
    TextView tvWGSJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Maintain.ResultBean bean = (Maintain.ResultBean) intent.getSerializableExtra("bean");
        tvCarCode.setText(bean.getCarNo());
        tvNum.setText(bean.getBusCode());
        tvDepartment.setText(bean.getDepName());
        tvMaintainNum.setText(bean.getMeasureBusNo());
        tvCarType.setText(bean.getBustypeCode());
        tvNengHao.setText(bean.getMaterialType());
        if (bean.getWorkerName()!=null){
            tvBXLX.setText(bean.getRepairCategory());
        }
        tvBXLX.setText(bean.getRepairCategory());
        if (bean.getStatus().equals("0")){
            tvZT.setText("未派单");
        }else if (bean.getStatus().equals("1")){
            tvZT.setText("已派单");
        }else if (bean.getStatus().equals("2")){
            tvZT.setText("已完成");
        }else if (bean.getStatus().equals("3")){
            tvZT.setText("已废单");
        }
        if (bean.getFlag().equals("1")){
            tvLX.setText("维修");
        }else if (bean.getFlag().equals("2")){
            tvLX.setText("保养");
        }
        tvReason.setText(bean.getMemo());
        tvBXSJ.setText(bean.getEnterDate()+" "+bean.getEnterTime());
        tvPGSJ.setText(bean.getRepairDate()+" "+bean.getRepairTime());
        tvWGSJ.setText(bean.getLeaveDate()+" "+bean.getLeaveTime());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_maintain_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
