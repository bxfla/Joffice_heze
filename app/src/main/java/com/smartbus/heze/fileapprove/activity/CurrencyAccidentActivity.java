package com.smartbus.heze.fileapprove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.fileapprove.presenter.OnePresenter;
import com.smartbus.heze.fileapprove.presenter.TwoPresenter;
import com.smartbus.heze.fileapprove.presenter.UPYSDPresenter;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 通用借款单
 */
public class CurrencyAccidentActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvTime1)
    TextView tvTime1;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.etLuBie)
    EditText etLuBie;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.etCarNo)
    EditText etCarNo;
    @BindView(R.id.etDriver)
    EditText etDriver;
    @BindView(R.id.etBlame)
    EditText etBlame;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.etSmallMoney)
    EditText etSmallMoney;
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etNum)
    EditText etNum;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader)
    EditText etLeader;
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
    @BindView(R.id.btnUp)
    Button btnUp;

    String uId = "";
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    String userId = "";
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter onePersenter;
    TwoPresenter twoPersenter;
    UPYSDPresenter upYsdPersenter;
    Map<String, String> map = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1,customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        userId = new SharedPreferencesHelper(this,"login").getData(this,"userId","");
        initDatePicker();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_borrow_accident;
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
        tvTime.setText(now.split(" ")[0]);
        tvTime1.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker1.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker1.setIsLoop(false);

        customDatePicker2 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime1.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }

    private void setData() {
        map.put("defId", Constant.YSD_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.YSD_FORMDEFIS);
        map.put("depNameDid", depId);
        map.put("depName", depName);
//        map.put("createDate", tvTime.getText().toString());
//        map.put("bzly", etUse.getText().toString());
//        map.put("xm1", etName1.getText().toString());
//        map.put("xm2", etName2.getText().toString());
//        map.put("xm3", etName3.getText().toString());
//        map.put("xm4", etName4.getText().toString());
//        map.put("xm5", etName5.getText().toString());
//        map.put("dw1", etDepartment1.getText().toString());
//        map.put("dw2", etDepartment2.getText().toString());
//        map.put("dw3", etDepartment3.getText().toString());
//        map.put("dw4", etDepartment4.getText().toString());
//        map.put("dw5", etDepartment5.getText().toString());
//        map.put("dj1", etMoney1.getText().toString());
//        map.put("dj2", etMoney2.getText().toString());
//        map.put("dj3", etMoney3.getText().toString());
//        map.put("dj4", etMoney4.getText().toString());
//        map.put("dj5", etMoney5.getText().toString());
//        map.put("sl1", etNum1.getText().toString());
//        map.put("sl2", etNum2.getText().toString());
//        map.put("sl3", etNum3.getText().toString());
//        map.put("sl4", etNum4.getText().toString());
//        map.put("sl5", etNum5.getText().toString());
//        map.put("je1", etAllMoney1.getText().toString());
//        map.put("je2", etAllMoney2.getText().toString());
//        map.put("je3", etAllMoney3.getText().toString());
//        map.put("je4", etAllMoney4.getText().toString());
//        map.put("je5", etAllMoney5.getText().toString());
        String zbr = new SharedPreferencesHelper(this, "login").getData(this, "userName", "");
        map.put("zhibiao", zbr);
        map.put("userId",userId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Constant.TAG_ONE && requestCode == Constant.TAG_ONE) {
            if (data != null) {
                DepartmentDataBean departmentDataBean = (DepartmentDataBean) data.getSerializableExtra("department");
                depId = departmentDataBean.getDepId();
                depName = departmentDataBean.getDepName();
                tvDepartment.setText(depName);
            }
        }
    }

    @Override
    public void setOnePerson(OnePerson s) {
        for (int i = 0; i < s.getData().size(); i++) {
            String name = s.getData().get(i).getDestination();
            namelist.add(name);
        }
        if (namelist.size() != 0) {
            if (namelist.size() == 1) {
                twoPersenter.getTwoPerson(Constant.YSD_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.YSD_DEFID, data);
                    }

                    @Override
                    public void select(List<String> list) {

                    }

                    @Override
                    public void confirm() {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        } else {
            Toast.makeText(this, "审批人为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setOnePersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setTwoPerson(TwoPerson s) {
        for (int i = 0; i < s.getData().size(); i++) {
            TwoPerson.DataBean bean = new TwoPerson.DataBean();
            bean.setUserNames(s.getData().get(i).getUserNames());
            bean.setUserCodes(s.getData().get(i).getUserCodes());
            dataList.add(bean);
        }
        if (dataList.size() == 1) {
            TwoPerson.DataBean bean1 = dataList.get(0);
            userCode = bean1.getUserCodes();
            userName = bean1.getUserNames();
            nametemp = userName.split(",");
            codetemp = userCode.split(",");
            if (codetemp != null) {
                for (String s1 : codetemp) {
                    codeList.add(s1);
                }
            }
            if (nametemp != null) {
                for (String s1 : nametemp) {
                    nameList.add(s1);
                }
            }
            if (codeList.size() == 1) {
                selectList.add(codeList.get(0));
                getListData();
                setData();
                map.put("flowAssignId", userDepart + "|" + uId);
                upYsdPersenter.getUPYSD(map);
            } else {
                MyAlertDialog.MyListAlertDialog(isShow, codeList, nameList, namelist1, this, new AlertDialogCallBackP() {

                    @Override
                    public void select(List<String> data) {
                        selectList = data;
                        getListData();
                        setData();
                        map.put("flowAssignId", userDepart + "|" + uId);
                        upYsdPersenter.getUPYSD(map);
                    }

                    @Override
                    public void oneselect(String s) {

                    }

                    @Override
                    public void confirm() {

                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        }
    }

    private String getListData() {
        if (selectList.size() == 1) {
            //uName = backlist.get(0).getActivityName();
            uId = selectList.get(0);
        }
        if (selectList.size() > 1) {
            for (int i = 1; i < selectList.size(); i++) {
                if (i < selectList.size() - 1) {
                    uId = uId + selectList.get(i) + ",";
                } else {
                    uId = uId + selectList.get(i);
                }
            }
            uId = selectList.get(0) + "," + uId;
        }
        return uId;
    }

    @Override
    public void setTwoPersonMessage(String s) {

    }

    @Override
    public void setUPYSD(BackData s) {
        Toast.makeText(this, s.getRunId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tvTime, R.id.tvTime1, R.id.tvDepartment, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.tvTime1:
                customDatePicker2.show(tvTime.getText().toString());
                break;
            case R.id.tvDepartment:
                Intent intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, Constant.TAG_ONE);
                break;
            case R.id.btnUp:
                if (tvDepartment.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择部门", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etAddress.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写地点", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etLuBie.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写路别", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etCarNo.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写车牌号", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etDriver.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写驾驶员", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etBlame.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写事故责任", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etReason.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写事故经过", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etSmallMoney.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写借款金额", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etName.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写借款人", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etNum.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写同一事故借款次数", Toast.LENGTH_SHORT).show();
                    break;
                }
                onePersenter = new OnePresenter(this, this);
                onePersenter.getOnePerson(Constant.YSD_DEFID);
                twoPersenter = new TwoPresenter(this, this);
                upYsdPersenter = new UPYSDPresenter(this, this);
                break;
        }
    }
}
