package com.smartbus.heze.fileapprove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.HuiQianWill;
import com.smartbus.heze.fileapprove.module.HuiQianWillContract;
import com.smartbus.heze.fileapprove.presenter.HuiQianWillPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.views.Header;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 事故科的事故借款单待办
 */
public class BorrowAccidentWillActivity extends BaseActivity implements HuiQianWillContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvTime1)
    TextView tvTime1;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvLuBie)
    TextView tvLuBie;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.tvBlame)
    TextView tvBlame;
    @BindView(R.id.tvReason)
    TextView tvReason;
    @BindView(R.id.tvSmallMoney)
    TextView tvSmallMoney;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvNum)
    TextView tvNum;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.btnUp)
    Button btnUp;

    String activityName,taskId;
    HuiQianWillPresenter borrowAccidentWillPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        borrowAccidentWillPresenter = new HuiQianWillPresenter(this,this);
        borrowAccidentWillPresenter.getBorrowAccidentWill(activityName,taskId, Constant.HUIQIAN_DEFID);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_borrow_accident_will;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.btnUp)
    public void onViewClicked() {
    }

    @Override
    public void setBorrowAccidentWill(HuiQianWill s) {

    }

    @Override
    public void setBorrowAccidentWillMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
