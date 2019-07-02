package com.smartbus.heze.exam.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.SendNum;
import com.smartbus.heze.exam.module.SendNumContract;
import com.smartbus.heze.exam.presenter.SendNumPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 班次里程
 */
public class SendNumActivity extends BaseActivity implements SendNumContract.View {

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

    BaseRecyclerAdapter baseRecyclerAdapter;
    SendNumPresenter sendNumPresenter;
    List<SendNum.ResultBean> beanList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.send_num));
        initDatePicker();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        sendNumPresenter = new SendNumPresenter(this, this);
        sendNumPresenter.getSendNum(tvStartTime.getText().toString()
                , tvEndTime.getText().toString());
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
        sendNumPresenter.getSendNum(tvStartTime.getText().toString()
                , tvEndTime.getText().toString());
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -30);
        Date d = c.getTime();
        String day = format.format(d);
        tvStartTime.setText(day);
        System.out.println("过去七天：" + day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        String now = sdf.format(new Date());
        tvEndTime.setText(now.split(" ")[0]);
        sendHttpContent();

        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
            }
        }, "2000-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker2.showSpecificTime(false); // 显示时和分
        customDatePicker2.setIsLoop(false); // 允许循环滚动
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
    public void setSendNum(SendNum s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        if (beanList.size() == 0) {
            llNoContent.setVisibility(View.VISIBLE);
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<SendNum.ResultBean>(this, R.layout.adapter_sendnum_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final SendNum.ResultBean resultBean) {
                holder.setText(R.id.tvDate, resultBean.getCreateDate());
                holder.setText(R.id.tvLine, resultBean.getLineCode());
                holder.setText(R.id.tvPM, resultBean.getRankNum());
                holder.setText(R.id.tvNum, resultBean.getSendNum()+"");
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setSendNumMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
