package com.smartbus.heze.exam.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.exam.adapter.OnLineAdapter;
import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.exam.bean.OnLineUp;
import com.smartbus.heze.exam.module.ExamationDataContract;
import com.smartbus.heze.exam.module.OnLineUpContract;
import com.smartbus.heze.exam.presenter.ExamationDataPresenter;
import com.smartbus.heze.exam.presenter.OnLineUpPresenter;
import com.smartbus.heze.http.base.AlertDialogCallBack;
import com.smartbus.heze.http.base.AlertDialogUtil;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.VoteSubmitViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OnLineActivity extends BaseActivity implements OnLineAdapter.GetItemPosition
        ,ExamationDataContract.View,OnLineUpContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.right)
    TextView right;
    @BindView(R.id.vote_submit_viewpager)
    VoteSubmitViewPager voteSubmitViewpager;
    @BindView(R.id.vote_submit_linear_dot)
    LinearLayout voteSubmitLinearDot;
    @BindView(R.id.vote_submit_relative)
    RelativeLayout voteSubmitRelative;
    @BindView(R.id.left)
    TextView left;

    Timer timer;
    TimerTask timerTask;
    int minute = 5;
    int second = 0;
    boolean isPause = false;
    int isFirst;
    List<ExaminationData.DataBean> answerList = new ArrayList<>();
    String examinationId, examinationTime, examinationName;
    OnLineAdapter onLineAdapter;
    OnLineUpPresenter onLineUpPresenter;
    ExamationDataPresenter examationDataPresenter;
    List<View> viewItems = new ArrayList<View>();
    List<ExaminationData.DataBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        examinationId = intent.getStringExtra("id");
        examinationTime = intent.getStringExtra("time");
        examinationName = intent.getStringExtra("title");
        title.setText(examinationName);
        minute = Integer.valueOf(examinationTime);
        right.setText(String.valueOf(minute));
        String userName = new SharedPreferencesHelper(this, "login").getData(this, "userName", "");
        onLineUpPresenter = new OnLineUpPresenter(this,this);
        examationDataPresenter = new ExamationDataPresenter(this, this);
        examationDataPresenter.getExamationData(examinationId, "0", userName);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_on_line;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.left)
    public void onViewClicked() {
        new AlertDialogUtil(this).showDialog("确定交卷吗", new AlertDialogCallBack() {
            @Override
            public int getData(int s) {
                return 0;
            }

            @Override
            public void confirm() {
                onLineAdapter.upData();
                String userName = new SharedPreferencesHelper(OnLineActivity.this,"login").getData(OnLineActivity.this,"userName","");
                Gson gson = new Gson();
                String json = gson.toJson(answerList);
                onLineUpPresenter.getOnLineUp(userName,"0",json);
            }

            @Override
            public void cancel() {

            }
        });
    }

    /**
     * adapter数据回调
     * @param upList
     */
    @Override
    public void getPosition(List<ExaminationData.DataBean> upList) {
        this.answerList = upList;
        new AlertDialogUtil(this).showDialog("确定交卷吗", new AlertDialogCallBack() {
            @Override
            public int getData(int s) {
                return 0;
            }

            @Override
            public void confirm() {
                onLineAdapter.upData();
                String userName = new SharedPreferencesHelper(OnLineActivity.this,"login").getData(OnLineActivity.this,"userName","");
                Gson gson = new Gson();
                String json = gson.toJson(answerList);
                onLineUpPresenter.getOnLineUp(userName,"0",json);
            }

            @Override
            public void cancel() {

            }
        });
    }

    /**
     * 交卷
     * @param s
     */
    @Override
    public void setOnLineUp(OnLineUp s) {
        if (s.isSuccess()){
            Toast.makeText(this, "数据上传成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

   @Override
    public void setOnLineUpMessage(String s) {
       Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setExamationData(ExaminationData s) {
        if (s.isSuccess()) {
            for (int i = 0; i < s.getData().size(); i++) {
                beanList.add(s.getData().get(i));
            }
        }
        for (int i = 0; i < beanList.size(); i++) {
            viewItems.add(getLayoutInflater().inflate(
                    R.layout.online_item, null));
        }
        onLineAdapter = new OnLineAdapter(this, viewItems, beanList);
        voteSubmitViewpager.setAdapter(onLineAdapter);
        voteSubmitViewpager.getParent()
                .requestDisallowInterceptTouchEvent(false);
        onLineAdapter.setOnInnerItemOnClickListener(this);
    }

    /**
     * @param index 根据索引值切换页面
     */
    public void setCurrentView(int index) {
        voteSubmitViewpager.setCurrentItem(index);
    }

    @Override
    public void setExamationDataMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    // 弹出对话框通知用户答题时间到
    protected void showTimeOutDialog(final boolean flag, final String backtype) {
        final Dialog builder = new Dialog(this, R.style.dialog);
        builder.setContentView(R.layout.my_dialog);
        TextView title = (TextView) builder.findViewById(R.id.dialog_title);
        TextView content = (TextView) builder.findViewById(R.id.dialog_content);
        if (backtype.equals("0")) {
            content.setText("您的答题时间结束,是否提交试卷?");
        } else if (backtype.equals("1")) {
            content.setText("您要结束本次模拟答题吗？");
        } else {
            //content.setText(errorMsg+"");
        }
        final Button confirm_btn = (Button) builder
                .findViewById(R.id.dialog_sure);
        Button cancel_btn = (Button) builder.findViewById(R.id.dialog_cancle);
        if (backtype.equals("0")) {
            confirm_btn.setText("提交");
            cancel_btn.setText("退出");
        } else if (backtype.equals("1")) {
            confirm_btn.setText("退出");
            cancel_btn.setText("继续答题");
        } else {
            confirm_btn.setText("确定");
            cancel_btn.setVisibility(View.GONE);
        }
        confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")) {
                    builder.dismiss();
                    //uploadExamination(pagerAdapter.errorTopicNum());
                    onLineAdapter.upData();
                } else {
                    builder.dismiss();
                    onLineAdapter.upData();
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")) {
                    finish();
                    builder.dismiss();
                } else {
                    isPause = false;
                    builder.dismiss();
                    Message msg = new Message();
                    msg.what = 1;
                    handlerStopTime.sendMessage(msg);
                }
            }
        });
        builder.setCanceledOnTouchOutside(false);// 设置点击Dialog外部任意区域关闭Dialog
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {

                return flag;
            }
        });
        builder.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            isPause = true;
            showTimeOutDialog(true, "1");
            Message msg = new Message();
            msg.what = 0;
            handlerStopTime.sendMessage(msg);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
        super.onPause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 1;
        handlerStopTime.sendMessage(msg);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        stopTime();
        minute = -1;
        second = -1;
        super.onDestroy();
    }

    private void startTime() {
        if (timer == null) {
            timer = new Timer();
        }
        if (timerTask == null) {
            timerTask = new TimerTask() {

                @Override
                public void run() {
                    Message msg = new Message();
                    msg.what = 0;
                    handlerTime.sendMessage(msg);
                }
            };
        }
        if (timer != null && timerTask != null) {
            timer.schedule(timerTask, 0, 1000);
        }
    }

    private void stopTime() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
    }

    //停止计时
    private Handler handlerStopTime = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    stopTime();
                    break;
                case 1:
                    startTime();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    Handler handlerTime = new Handler() {
        public void handleMessage(Message msg) {
            // 判断时间快到前2分钟字体颜色改变
            if (minute < 2) {
                right.setTextColor(Color.RED);
            } else {
                right.setTextColor(Color.WHITE);
            }
            if (minute == 0) {
                if (second == 0) {
                    isFirst += 1;
                    // 时间到
                    if (isFirst == 1) {
                        showTimeOutDialog(true, "0");
                    }
                    right.setText("00:00");
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask = null;
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        right.setText("0" + minute + ":" + second);
                    } else {
                        right.setText("0" + minute + ":0" + second);
                    }
                }
            } else {
                if (second == 0) {
                    second = 59;
                    minute--;
                    if (minute >= 10) {
                        right.setText(minute + ":" + second);
                    } else {
                        right.setText("0" + minute + ":" + second);
                    }
                } else {
                    second--;
                    if (second >= 10) {
                        if (minute >= 10) {
                            right.setText(minute + ":" + second);
                        } else {
                            right.setText("0" + minute + ":" + second);
                        }
                    } else {
                        if (minute >= 10) {
                            right.setText(minute + ":0" + second);
                        } else {
                            right.setText("0" + minute + ":0" + second);
                        }
                    }
                }
            }
        }
    };

}
