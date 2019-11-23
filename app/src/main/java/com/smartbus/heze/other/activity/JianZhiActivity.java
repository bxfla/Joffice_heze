package com.smartbus.heze.other.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.activity.WorkOnePersonActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.oaflow.bean.JianZhi;
import com.smartbus.heze.oaflow.module.JianZhiContract;
import com.smartbus.heze.oaflow.presenter.JianZhiPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;

public class JianZhiActivity extends BaseActivity implements JianZhiContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.etAdress)
    EditText etAdress;
    @BindView(R.id.etPhone)
    EditText etPhone;
    @BindView(R.id.etComp)
    EditText etComp;
    @BindView(R.id.etLine)
    EditText etLine;
    @BindView(R.id.etBeiZhu)
    EditText etBeiZhu;
    @BindView(R.id.btn)
    Button btn;
    String peopleId = "", depId = "";
    JianZhiPresenter jianZhiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        jianZhiPresenter = new JianZhiPresenter(this, this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_jian_zhi;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
    }

    @Override
    public void setJianZhi(JianZhi s) {
        if (s.getSuccess().equals("true")) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setJianZhiMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_THERE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvName.setText(data.getStringArrayListExtra("beanId").get(0));
                        peopleId = data.getStringArrayListExtra("bean").get(0);
                        String depName = data.getStringExtra("department");
                        depId = data.getStringExtra("departmentId");
                        if (depName != null) {
                            etComp.setText(depName);
                        }
                    }
                }
                break;
        }
    }

    @OnClick({R.id.tvName, R.id.btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvName:
                Intent intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.btn:
                String name = tvName.getText().toString().trim();
                String adress = etAdress.getText().toString().trim();
                String phone = etPhone.getText().toString().trim();
                String comp = etComp.getText().toString().trim();
                String line = etLine.getText().toString().trim();
                String beizhi = etBeiZhu.getText().toString().trim();
                if (name.equals("")) {
                    Toast.makeText(this, "员工姓名不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (adress.equals("")) {
                    Toast.makeText(this, "家庭住址不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (phone.equals("")) {
                    Toast.makeText(this, "联系电话不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (comp.equals("")) {
                    Toast.makeText(this, "分公司不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (line.equals("")) {
                    Toast.makeText(this, "所在线路不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                jianZhiPresenter.getJianZhi(name, peopleId, adress, phone, comp, depId, line, beizhi);
                break;
        }
    }
}
