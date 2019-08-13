package com.smartbus.heze.exam.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimulateResultActivity extends BaseActivity {

    String num, name;
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvPass)
    TextView tvPass;
    @BindView(R.id.tvScore)
    TextView tvScore;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter baseRecyclerAdapter;
    List<ExaminationData.DataBean> upList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        num = intent.getStringExtra("num");
        name = intent.getStringExtra("name");
        upList = (List<ExaminationData.DataBean>) intent.getSerializableExtra("list");
        tvPass.setText(name);
        tvScore.setText(num);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_simulate_result;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
//        Intent intent = new Intent(this, SimulateResultActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("list", (Serializable) upList);
//        intent.putExtras(bundle);
//        startActivity(intent);
//        finish();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        baseRecyclerAdapter = new BaseRecyclerAdapter<ExaminationData.DataBean>(this, R.layout.adapter_result_item, upList) {
            @Override
            public void convert(BaseViewHolder holder, ExaminationData.DataBean resultBean) {
//                holder.setText(R.id.tvType, resultBean.getTypeName());
                holder.setText(R.id.tvContent,"("+resultBean.getTypeName()+")" +resultBean.getTitle());
                holder.setText(R.id.tvTrueAnswer, resultBean.getAnswer());
                holder.setText(R.id.tvSelectAnswer, resultBean.getData());
                String a = resultBean.getContent0();
                String b = resultBean.getContent1();
                String c = resultBean.getContent2();
                String d = resultBean.getContent3();
                String e = resultBean.getContent4();
                String f = resultBean.getContent5();
                String trueData = resultBean.getAnswer();
                if (trueData.equals(splitData(a))){
                    holder.setText(R.id.tvAnswer, a);
                }
                if (trueData.equals(splitData(b))){
                    holder.setText(R.id.tvAnswer, b);
                }
                if (trueData.equals(splitData(c))){
                    holder.setText(R.id.tvAnswer, c);
                }
                if (trueData.equals(splitData(d))){
                    holder.setText(R.id.tvAnswer, d);
                }
                if (trueData.equals(splitData(e))){
                    holder.setText(R.id.tvAnswer, e);
                }
                if (trueData.equals(splitData(f))){
                    holder.setText(R.id.tvAnswer, f);
                }
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
        ll.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }
    public String splitData(String s){
        if(s!=null){
            String[] sd = s.split(":");
            return sd[0];
        }
        return "";
    }
}
