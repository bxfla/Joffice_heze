package com.smartbus.heze.other.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.checkup.activitydata.LineCodeActivity;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.fileapprove.activity.WorkOnePersonActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.other.bean.CarType;
import com.smartbus.heze.other.bean.IcAboutLine;
import com.smartbus.heze.other.module.CarTypeContract;
import com.smartbus.heze.other.module.IcAboutLineContract;
import com.smartbus.heze.other.module.UpICMSContract;
import com.smartbus.heze.other.presenter.CarTypePresenter;
import com.smartbus.heze.other.presenter.IcAboutLinePresenter;
import com.smartbus.heze.other.presenter.UpICMSPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

public class ICMSActivity extends BaseActivity implements IcAboutLineContract.View
        ,CarTypeContract.View,UpICMSContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.tvLine)
    TextView tvLine;
    @BindView(R.id.tvDate)
    TextView tvDate;
    @BindView(R.id.spinnerTag)
    Spinner spinnerTag;
    @BindView(R.id.etIcNo)
    EditText etIcNo;
    @BindView(R.id.spinnerType)
    Spinner spinnerType;
    @BindView(R.id.spinnerMoney)
    Spinner spinnerMoney;
    @BindView(R.id.spinnerReason)
    Spinner spinnerReason;
    @BindView(R.id.btnUp)
    Button btnUp;

    Intent intent;
    String eCard = "";
    List<String> listType = new ArrayList<String>();
    List<CarType.DataBean> beanList = new ArrayList<>();
    List<String> listMoney = new ArrayList<String>();
    List<String> listReason = new ArrayList<String>();
    List<String> listTag = new ArrayList<String>();
    CarTypePresenter carTypePresenter;
    UpICMSPresenter upICMSPresenter;
    IcAboutLinePresenter icAboutLinePresenter;
    private CustomDatePickerDay customDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        listMoney.add("10");
        listMoney.add("30");
        ArrayAdapter moneyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMoney);
        moneyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMoney.setAdapter(moneyAdapter);

        listReason.add("无照片");
        listReason.add("冒用");
        ArrayAdapter reasonAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listReason);
        reasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerReason.setAdapter(reasonAdapter);

        listTag.add("有卡");
        listTag.add("无卡");
        ArrayAdapter tagAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTag);
        tagAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTag.setAdapter(tagAdapter);
        initDatePicker();
        carTypePresenter = new CarTypePresenter(this,this);
        carTypePresenter.getCarType();
        upICMSPresenter = new UpICMSPresenter(this,this);
        icAboutLinePresenter = new IcAboutLinePresenter(this,this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_icms;
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvDate.setText(now.split(" ")[0]);
        customDatePicker = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvDate.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker.setIsLoop(false);
    }

    @OnClick({R.id.tvDriver, R.id.tvLine, R.id.tvDate, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDriver:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvLine:
                intent = new Intent(this, LineCodeActivity.class);
                startActivityForResult(intent, TAG_TWO);
                break;
            case R.id.tvDate:
                customDatePicker.show(tvDate.getText().toString());
                break;
            case R.id.btnUp:
                if (tvDriver.getText().toString().equals("")||tvLine.getText().toString().equals("")){
                    Toast.makeText(this, "请填写驾驶员和线路", Toast.LENGTH_SHORT).show();
                }else {
                    String userName = new SharedPreferencesHelper(this,"login").getData(this,"userName","");
                    upICMSPresenter.getUpICMS(userName,tvDriver.getText().toString(),eCard
                            ,tvLine.getText().toString(),etIcNo.getText().toString()
                            ,spinnerType.getSelectedItem().toString(),spinnerMoney.getSelectedItem().toString()
                            ,spinnerReason.getSelectedItem().toString(),tvDate.getText().toString()
                            ,spinnerTag.getSelectedItem().toString());
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvDriver.setText(data.getStringArrayListExtra("beanId").get(0));
                        eCard = data.getStringExtra("ecard");
                        icAboutLinePresenter.getIcAboutLine(eCard);
                    }
                }
                break;
            case TAG_TWO:
                if (resultCode == Constant.TAG_ONE) {
                    LineCodeData lineCodeData = (LineCodeData) data.getSerializableExtra("lineCode");
                    tvLine.setText(lineCodeData.getLineCode());
                }
                break;
        }
    }

    @Override
    public void setIcAboutLine(IcAboutLine icAboutLine) {
        if (icAboutLine.isSuccess()){
            tvLine.setText(icAboutLine.getData().getLineCode());
        }
    }

    @Override
    public void setIcAboutLineMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCarType(CarType carType) {
        if (carType.isSuccess()){
            for (int i = 0;i<carType.getData().size();i++){
                beanList.add(carType.getData().get(i));
                listType.add(carType.getData().get(i).getItemValue());
            }
            ArrayAdapter typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
            typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerType.setAdapter(typeAdapter);
        }
    }

    @Override
    public void setCarTypeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUpICMS(UpData upData) {
        if (upData.isSuccess()){
            Toast.makeText(this, "提交数据成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setUpICMSMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
