package com.smartbus.heze.other.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.other.module.AdverUpContract;
import com.smartbus.heze.other.presenter.AdverUpPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AdvertActivity extends BaseActivity implements AdverUpContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etComp)
    EditText etComp;
    @BindView(R.id.etPerson)
    EditText etPerson;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etBeiZhu)
    EditText etBeiZhu;
    @BindView(R.id.btnUp)
    Button btnUp;

    AdverUpPresenter adverUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        adverUpPresenter = new AdverUpPresenter(this,this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_advert;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setAdverUp(UpData upData) {
        if (upData.isSuccess()){
            Toast.makeText(this, "上传数据成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setAdverUpMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnUp)
    public void onViewClicked() {
        if (etComp.getText().toString().equals("")){
            Toast.makeText(this, "公司名称不能为空", Toast.LENGTH_SHORT).show();
        }else {
            adverUpPresenter.AdverUp(etComp.getText().toString(),etPerson.getText().toString()
                    ,etPhone.getText().toString(),etAddress.getText().toString(),etBeiZhu.getText().toString());
        }
    }
}
