package com.smartbus.heze.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.DJDepartment;
import com.smartbus.heze.exam.module.DJDepartmentContract;
import com.smartbus.heze.exam.presenter.DJDepartmentPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DJDepartmentActivity extends BaseActivity implements DJDepartmentContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter baseRecyclerAdapter;
    DJDepartmentPresenter djDepartmentPresenter;
    List<DJDepartment.DataBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        djDepartmentPresenter = new DJDepartmentPresenter(this,this);
        djDepartmentPresenter.getDJDepartment("1","1");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_departmentdj;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setDJDepartment(DJDepartment s) {
        if (s.isSuccess()){
            for (int i = 0;i<s.getData().size();i++){
                beanList.add(s.getData().get(i));
            }
            baseRecyclerAdapter = new BaseRecyclerAdapter<DJDepartment.DataBean>(this, R.layout.adapter_easy_item, beanList) {
                @Override
                public void convert(BaseViewHolder holder, final DJDepartment.DataBean resultBean) {
                    holder.setText(R.id.textView, resultBean.getOrgName());
                    holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent();
                            intent.putExtra("orgName", resultBean.getOrgName());
                            intent.putExtra("orgId", resultBean.getOrgId());
                            setResult(Constant.TAG_TWO, intent);
                            finish(); //结束当前的activity的生命周期
                        }
                    });
                }
            };
            recyclerView.setAdapter(baseRecyclerAdapter);
            baseRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setDJDepartmentMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
