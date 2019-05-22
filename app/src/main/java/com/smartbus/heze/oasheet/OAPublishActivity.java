package com.smartbus.heze.oasheet;

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
import com.smartbus.heze.fileapprove.activity.DepartmentActivity;
import com.smartbus.heze.fileapprove.activity.DepartmentMoreActivity;
import com.smartbus.heze.fileapprove.activity.WorkPersonActivity;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.oasheet.bean.OANO;
import com.smartbus.heze.oasheet.module.NoContract;
import com.smartbus.heze.oasheet.presenter.NoPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

public class OAPublishActivity extends BaseActivity implements NoContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvNo)
    TextView tvNo;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvOverDepart)
    TextView tvOverDepart;
    @BindView(R.id.tvSendDepart)
    TextView tvSendDepart;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.spinnertitle)
    Spinner spinnertitle;
    @BindView(R.id.spinnertype)
    Spinner spinnertype;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader3)
    TextView tvLeader3;
    @BindView(R.id.etLeader3)
    EditText etLeader3;
    @BindView(R.id.tvLeader4)
    TextView tvLeader4;
    @BindView(R.id.etLeader4)
    EditText etLeader4;
    @BindView(R.id.btnUp)
    Button btnUp;

    Intent intent;
    NoPresenter noPresenter;
    String overDepId = "", overDepName = "";
    ArrayAdapter<String> titleAdapter;
    ArrayAdapter<String> typeAdapter;
    List<String> listTitle = new ArrayList<String>();
    List<String> listType = new ArrayList<String>();
    List<String> selectList1 = new ArrayList<>();
    List<String> selectPersonList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        listTitle.add("日常工作");
        listTitle.add("现场工作");
        listTitle.add("重点工作");
        listTitle.add("环境监察");
        listTitle.add("其他");

        listType.add("A");
        listType.add("B");
        listType.add("C");

        titleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTitle);
        titleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertitle.setAdapter(titleAdapter);

        typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnertype.setAdapter(typeAdapter);
        noPresenter = new NoPresenter(this,this);
        noPresenter.getNo("gongzuochuandidanbia");
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_oapublish;
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
        tvStartTime.setText(now);
        tvEndTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(true);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);
        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvEndTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvOverDepart, R.id.tvSendDepart, R.id.tvPerson, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvOverDepart:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvSendDepart:
                intent = new Intent(this, DepartmentMoreActivity.class);
                startActivityForResult(intent, TAG_TWO);
                break;
            case R.id.tvPerson:
                intent = new Intent(this, WorkPersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.btnUp:
                if (tvOverDepart.getText().toString().equals("")){
                    Toast.makeText(this, "解决部门不能为空", Toast.LENGTH_SHORT).show();
                }
                if (etContent.getText().toString().equals("")){
                    Toast.makeText(this, "内容不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        DepartmentDataBean departmentDataBean = (DepartmentDataBean) data.getSerializableExtra("department");
                        overDepId = departmentDataBean.getDepId();
                        overDepName = departmentDataBean.getDepName();
                        tvOverDepart.setText(overDepName);
                    }
                }
                break;
            case TAG_TWO:
                if (data != null) {
                    selectList1 = data.getStringArrayListExtra("bean");
                    tvSendDepart.setText(selectList1.toString());
                }
                break;
            case TAG_THERE:
                if (data != null) {
                    selectPersonList = data.getStringArrayListExtra("bean");
                    tvPerson.setText(selectPersonList.toString());
                }
                break;
        }
    }

    @Override
    public void setNo(OANO s) {
        if (s.isSuccess()){
            tvNo.setText(s.getNumber());
        }
    }

    @Override
    public void setNoMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
