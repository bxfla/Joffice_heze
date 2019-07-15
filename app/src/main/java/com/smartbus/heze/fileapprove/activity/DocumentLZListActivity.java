package com.smartbus.heze.fileapprove.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.DocumentLZList;
import com.smartbus.heze.fileapprove.module.DocumentLRListContract;
import com.smartbus.heze.fileapprove.presenter.DocumentLRListPresenter;
import com.smartbus.heze.http.base.AlertDialogCallBack;
import com.smartbus.heze.http.base.AlertDialogUtil;
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

public class DocumentLZListActivity extends BaseActivity implements DocumentLRListContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.line1)
    View line1;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter baseRecyclerAdapter;
    List<DocumentLZList.ResultBean>beanList = new ArrayList<>();
    DocumentLRListPresenter documentLRListPresenter;
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        documentLRListPresenter = new DocumentLRListPresenter(this,this);
        documentLRListPresenter.getDocumentLRList(tvStartTime.getText().toString(),tvEndTime.getText().toString());
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_document_lzlist;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
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
    public void setDocumentLRList(DocumentLZList s) {
        for (int i = 0;i<s.getResult().size();i++){
            beanList.add(s.getResult().get(i));
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<DocumentLZList.ResultBean>(this, R.layout.adapter_check_document, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final DocumentLZList.ResultBean resultBean) {
                holder.setText(R.id.tvDate, resultBean.getLvDate());
                holder.setText(R.id.tvFWDP, resultBean.getLvDepName());
                holder.setText(R.id.tvCBDP, resultBean.getLvUndertake());
                holder.setText(R.id.tvTitle, resultBean.getLvTitle());
                holder.setText(R.id.tvResult, resultBean.getLvMemo());
                final AlertDialogUtil alertDialogUtil = new AlertDialogUtil(DocumentLZListActivity.this);
                holder.setOnClickListener(R.id.tvResult, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialogUtil.showDialog(resultBean.getLvMemo(), new AlertDialogCallBack() {
                            @Override
                            public int getData(int s) {
                                return 0;
                            }

                            @Override
                            public void confirm() {

                            }

                            @Override
                            public void cancel() {

                            }
                        });
                    }
                });
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDocumentLRListMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
