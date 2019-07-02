package com.smartbus.heze.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.StartDriver;
import com.smartbus.heze.exam.module.StartDriverContract;
import com.smartbus.heze.exam.presenter.StartDriverPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerMonth;
import com.smartbus.heze.http.views.Header;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 星级驾驶员
 */
public class StartDriverActivity extends BaseActivity implements StartDriverContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.ll)
    LinearLayout ll;

    BaseRecyclerAdapter baseRecyclerAdapter;
    StartDriverPresenter startDriverPresenter;
    List<StartDriver.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerMonth customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        ll.setVisibility(View.GONE);
        line1.setVisibility(View.GONE);
        header.setTvTitle(getResources().getString(R.string.start_driver));
        initDatePicker();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        startDriverPresenter = new StartDriverPresenter(this, this);
        startDriverPresenter.getStartDriver(tvStartTime.getText().toString()
        );
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_in_come_rank;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList.clear();
        startDriverPresenter.getStartDriver(tvStartTime.getText().toString());
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -30);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);

        customDatePicker1 = new CustomDatePickerMonth(this, new CustomDatePickerMonth.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                String s = time.split(" ")[0];
                String s1 = s.split("-")[0]+"-"+s.split("-")[1];
                tvStartTime.setText(s1);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.showSpecificDay(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
    }

    private void sendHttpContent() {
        Date startTime = null, endTime = null;
        if (tvStartTime.getText().toString().isEmpty() || tvStartTime.getText().toString().isEmpty()) {
            Toast.makeText(this, "起止时间不能为空", Toast.LENGTH_SHORT).show();
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                startTime = sdf1.parse(tvStartTime.getText().toString());
                endTime = sdf1.parse(tvEndTime.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (startTime.getTime() > endTime.getTime()) {
            Toast.makeText(this, "请选择正确时间", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
        }
    }

    @Override
    public void setStartDriver(StartDriver s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        if (beanList.size() == 0) {
            llNoContent.setVisibility(View.VISIBLE);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<StartDriver.ResultBean>(this, R.layout.adapter_startdriver_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final StartDriver.ResultBean resultBean) {
                if (resultBean.getStarCode()==0){
                    holder.setText(R.id.tvStart, "无星级");
                }else if (resultBean.getStarCode()==1){
                    holder.setText(R.id.tvStart, "一星级");
                }else if (resultBean.getStarCode()==2){
                    holder.setText(R.id.tvStart, "二星级");
                }else if (resultBean.getStarCode()==3){
                    holder.setText(R.id.tvStart, "三星级");
                }else if (resultBean.getStarCode()==4){
                    holder.setText(R.id.tvStart, "四星级");
                }else if (resultBean.getStarCode()==5){
                    holder.setText(R.id.tvStart, "五星级");
                }
                holder.setText(R.id.tvMonth, resultBean.getDriverMonth());
                holder.setText(R.id.tvGH, resultBean.getDriverCode());
                holder.setText(R.id.tvPK, resultBean.getTicketJc() + "");
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setStartDriverMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
