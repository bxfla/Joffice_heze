package com.smartbus.heze.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.exam.bean.Score;
import com.smartbus.heze.exam.module.ScoreContract;
import com.smartbus.heze.exam.presenter.ScorePresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoundActivity extends BaseActivity implements ScoreContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    ScorePresenter scorePresenter;

    BaseRecyclerAdapter baseRecyclerAdapter;
    List<Score.ResultBean>beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        scorePresenter = new ScorePresenter(this,this);
        String userName = new SharedPreferencesHelper(this,"login").getData(this,"userName","");
        scorePresenter.getScore(userName);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_found;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setScore(Score s) {
        if (s.isSuccess()){
            for (int i = 0;i<s.getResult().size();i++){
                beanList.add(s.getResult().get(i));
            }
            baseRecyclerAdapter = new BaseRecyclerAdapter<Score.ResultBean>(this,R.layout.adapter_score_item,beanList) {
                @Override
                public void convert(BaseViewHolder holder, Score.ResultBean s) {
                    holder.setText(R.id.tvScore,s.getScore());
                    holder.setText(R.id.tvDate,s.getKsdate());
                    holder.setText(R.id.tvName,s.getExaminationName());
                }
            };
            recyclerView.setAdapter(baseRecyclerAdapter);
            baseRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setScoreMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
