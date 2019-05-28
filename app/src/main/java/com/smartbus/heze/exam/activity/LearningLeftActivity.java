package com.smartbus.heze.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.exam.module.LearnLeftContract;
import com.smartbus.heze.exam.presenter.LearnLeftPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LearningLeftActivity extends BaseActivity implements LearnLeftContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    LearnLeftPresenter learnLeftPresenter;
    BaseRecyclerAdapter baseRecyclerAdapter;
    List<LearnLeft.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        learnLeftPresenter = new LearnLeftPresenter(this, this);
        learnLeftPresenter.getLearnLeft();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_learning;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setLearnLeft(LearnLeft s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<LearnLeft.ResultBean>(this, R.layout.adapter_easy_item, beanList) {
            @Override
            public void convert(final BaseViewHolder holder, final LearnLeft.ResultBean o) {
                holder.setText(R.id.textView, o.getTypeName());
                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(LearningLeftActivity.this, LearningRightActivity.class);
                        intent.putExtra("bean", o);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLearnLeftMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
