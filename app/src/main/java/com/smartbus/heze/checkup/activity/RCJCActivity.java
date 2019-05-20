package com.smartbus.heze.checkup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.activitydata.CarCodeActivity;
import com.smartbus.heze.checkup.activitydata.CheckPersonActivity;
import com.smartbus.heze.checkup.activitydata.LineCodeActivity;
import com.smartbus.heze.checkup.activitydata.UserCodeActivity;
import com.smartbus.heze.checkup.bean.CarCodeData;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.checkup.bean.UserCodeData;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RCJCActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etLine)
    EditText etLine;
    @BindView(R.id.imLine)
    ImageView imLine;
    @BindView(R.id.etCarCode)
    EditText etCarCode;
    @BindView(R.id.imCarCode)
    ImageView imCarCode;
    @BindView(R.id.etCarNo)
    EditText etCarNo;
    @BindView(R.id.imCarNo)
    ImageView imCarNo;
    @BindView(R.id.etPersonCode)
    EditText etPersonCode;
    @BindView(R.id.imPersonCode)
    ImageView imPersonCode;
    @BindView(R.id.etPersonName)
    EditText etPersonName;
    @BindView(R.id.imPersonName)
    ImageView imPersonName;
    @BindView(R.id.etRummager)
    EditText etRummager;
    @BindView(R.id.imRummager)
    ImageView imRummager;
    @BindView(R.id.etCarType)
    EditText etCarType;
    @BindView(R.id.tvClassTime)
    TextView tvClassTime;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etRemarks)
    EditText etRemarks;
    @BindView(R.id.btnUp)
    Button btnUp;
    Intent intent;
    private CustomDatePickerDay customDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        customDatePicker = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker.setIsLoop(false);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_rcjc;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.imLine, R.id.imCarCode, R.id.imCarNo, R.id.imPersonCode, R.id.imPersonName, R.id.imRummager, R.id.tvClassTime, R.id.tvTime, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imLine:
                intent = new Intent(this, LineCodeActivity.class);
                startActivityForResult(intent, Constant.TAG_ONE);
                break;
            case R.id.imCarCode:
                intent = new Intent(this, CarCodeActivity.class);
                intent.putExtra("tag","carCode");
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imCarNo:
                intent = new Intent(this, CarCodeActivity.class);
                intent.putExtra("tag","carNo");
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imPersonCode:
                intent = new Intent(this, UserCodeActivity.class);
                intent.putExtra("tag","userCode");
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imPersonName:
                intent = new Intent(this, UserCodeActivity.class);
                intent.putExtra("tag","userName");
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imRummager:
                intent = new Intent(this, CheckPersonActivity.class);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.tvClassTime:
                break;
            case R.id.tvTime:
                break;
            case R.id.btnUp:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Constant.TAG_ONE:
                if (resultCode==Constant.TAG_ONE){
                    LineCodeData lineCodeData = (LineCodeData) data.getSerializableExtra("lineCode");
                    etLine.setText(lineCodeData.getLineCode());
                }
                break;
            case Constant.TAG_TWO:
                if (resultCode==Constant.TAG_TWO){
                    CarCodeData carCodeData = (CarCodeData) data.getSerializableExtra("carCode");
                    etCarCode.setText(carCodeData.getBusCode());
                    etCarNo.setText(carCodeData.getCarNo());
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode==Constant.TAG_THERE){
                    UserCodeData userCodeData = (UserCodeData) data.getSerializableExtra("userCode");
                    etPersonCode.setText(userCodeData.getUserCode());
                    etPersonName.setText(userCodeData.getFullname());
                }
            case Constant.TAG_FOUR:
                if (resultCode==Constant.TAG_FOUR){
                    String selectName = data.getStringExtra("name");
                    etRummager.setText(selectName);
                }
                break;
        }
    }
}
