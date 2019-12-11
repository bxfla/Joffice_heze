package com.smartbus.heze.fileapprove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.activitydata.CarCodeActivity;
import com.smartbus.heze.checkup.activitydata.LineCodeActivity;
import com.smartbus.heze.checkup.bean.CarCodeData;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.fileapprove.bean.BorrowAccidentLRData;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.BorrowAccidentCheckTypeContract;
import com.smartbus.heze.fileapprove.module.BorrowAccidentLRContract;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.fileapprove.presenter.BorrowAccidentCheckTypePresenter;
import com.smartbus.heze.fileapprove.presenter.BorrowAccidentLRPresenter;
import com.smartbus.heze.fileapprove.presenter.OnePresenter;
import com.smartbus.heze.fileapprove.presenter.TwoPresenter;
import com.smartbus.heze.fileapprove.presenter.UPYSDPresenter;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;
import com.smartbus.heze.oaflow.bean.CheckType;

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

import static com.smartbus.heze.http.base.Constant.TAG_FOUR;
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 事故科的事故借款单
 */
public class BorrowAccidentActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View, BorrowAccidentLRContract.View, BorrowAccidentCheckTypeContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvTime1)
    TextView tvTime1;
    @BindView(R.id.etAddress)
    EditText etAddress;
    @BindView(R.id.tvLuBie)
    TextView tvLuBie;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.etBlame)
    EditText etBlame;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.etSmallMoney)
    EditText etSmallMoney;
    @BindView(R.id.tvName)
    TextView tvName;
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
    @BindView(R.id.btnLR)
    Button btnLR;

    String uId = "";
    Intent intent;
    String busCode = "";
    String vocationId = "";
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    String driverId = "";
    String selectTag = "1";
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter onePersenter;
    TwoPresenter twoPersenter;
    UPYSDPresenter upYsdPersenter;
    BorrowAccidentLRPresenter borrowAccidentLRPresenter;
    BorrowAccidentCheckTypePresenter borrowAccidentCheckTypePresenter;
    Map<String, String> map = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    Map<String, String> firstmap = new HashMap<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        btnLR.setVisibility(View.VISIBLE);
        borrowAccidentLRPresenter = new BorrowAccidentLRPresenter(this, this);
        borrowAccidentCheckTypePresenter = new BorrowAccidentCheckTypePresenter(this,this);
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
        map.put("defId", Constant.BORROWACCIDENT_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.BORROWACCIDENT_FORMDEFIS);
        map.put("depNameDid", depId);
        map.put("depName", depName);
        map.put("jiekuanDate", tvTime.getText().toString());
        map.put("atDate", tvTime1.getText().toString());
        map.put("atPlace", etAddress.getText().toString());
        map.put("lineCode", tvLuBie.getText().toString());
        map.put("carNo", tvCarNo.getText().toString());
        map.put("driverName", tvDriver.getText().toString());
        map.put("acDuty", etBlame.getText().toString());
        map.put("atAfter", etReason.getText().toString());
        map.put("atje", etSmallMoney.getText().toString());
        map.put("acNumber", etNum.getText().toString());
        map.put("jiekuanren", tvName.getText().toString());
        map.put("kezhang", "");
        map.put("fenguanjingli", "");
        map.put("caiwujingli", "");
        map.put("pishi", "");
        map.put("dataUrl_save", "/joffice/hrm/updateVersatileLoan.do?accidentLoanId=" + vocationId);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (requestCode == TAG_ONE) {
                    if (data != null) {
                        DepartmentDataBean departmentDataBean = (DepartmentDataBean) data.getSerializableExtra("department");
                        depId = departmentDataBean.getDepId();
                        depName = departmentDataBean.getDepName();
                        tvDepartment.setText(depName);
                    }
                }
                break;
            case TAG_TWO:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvName.setText(data.getStringArrayListExtra("beanId").get(0));
                        driverId = data.getStringArrayListExtra("bean").get(0);
                    }
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode == Constant.TAG_ONE) {
                    LineCodeData lineCodeData = (LineCodeData) data.getSerializableExtra("lineCode");
                    tvLuBie.setText(lineCodeData.getLineCode());
                }
                break;
            case TAG_FOUR:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvDriver.setText(data.getStringArrayListExtra("beanId").get(0));
                    }
                }
                break;
            case Constant.TAG_FIVE:
                if (resultCode == Constant.TAG_TWO) {
                    CarCodeData carCodeData = (CarCodeData) data.getSerializableExtra("carCode");
                    tvCarNo.setText(carCodeData.getCarNo());
                    busCode = carCodeData.getBusCode();
                }
                break;
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
                userDepart = namelist.get(0);
                twoPersenter.getTwoPerson(Constant.BORROWACCIDENT_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.BORROWACCIDENT_DEFID, data);
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
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setUPYSD(BackData s) {
        if (s.isSuccess()) {
            String s1 = String.valueOf(s.getRunId());
            borrowAccidentCheckTypePresenter.getBorrowAccidentCheckType(String.valueOf(s.getRunId()), vocationId);
//            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
//            finish();
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, "提交数据失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tvTime, R.id.tvTime1, R.id.tvDepartment, R.id.btnUp, R.id.tvName
            , R.id.tvLuBie, R.id.tvDriver, R.id.tvCarNo, R.id.btnLR})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.tvTime1:
                customDatePicker2.show(tvTime.getText().toString());
                break;
            case R.id.tvDepartment:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvName:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.tvLuBie:
                intent = new Intent(this, LineCodeActivity.class);
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.tvDriver:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.tvCarNo:
                intent = new Intent(this, CarCodeActivity.class);
                intent.putExtra("tag", "carNo");
                startActivityForResult(intent, Constant.TAG_FIVE);
                break;
            case R.id.btnLR:
                if (tvDepartment.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择部门", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etAddress.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写地点", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvLuBie.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写路别", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvCarNo.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写车牌号", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvDriver.getText().toString().equals("")) {
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
                if (tvName.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写借款人", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etNum.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写同一事故借款次数", Toast.LENGTH_SHORT).show();
                    break;
                }
                setDataFirst();
                borrowAccidentLRPresenter.getBorrowAccidentLR(firstmap);
                break;
            case R.id.btnUp:
                if (selectTag.equals("2")) {
                    namelist.clear();
                    codeList.clear();
                    nameList.clear();
                    selectList.clear();
                    namelist1.clear();
                    dataList.clear();
                    if (tvDepartment.getText().toString().equals("")) {
                        Toast.makeText(this, "请选择部门", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (etAddress.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写地点", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (tvLuBie.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写路别", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (tvCarNo.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写车牌号", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (tvDriver.getText().toString().equals("")) {
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
                    if (tvName.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写借款人", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (etNum.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写同一事故借款次数", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    onePersenter = new OnePresenter(this, this);
                    onePersenter.getOnePerson(Constant.BORROWACCIDENT_DEFID);
                    twoPersenter = new TwoPresenter(this, this);
                    upYsdPersenter = new UPYSDPresenter(this, this);
                } else {
                    Toast.makeText(this, "请先录入", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void setDataFirst() {
        firstmap.put("acDuty", etBlame.getText().toString());
        firstmap.put("carNo", tvCarNo.getText().toString());
        firstmap.put("busCode", busCode);
        firstmap.put("acNumber", etNum.getText().toString());
        firstmap.put("atje", etSmallMoney.getText().toString());
        firstmap.put("atAfter", etReason.getText().toString());
        firstmap.put("driverName", tvDriver.getText().toString());
        firstmap.put("driverId", etAddress.getText().toString());
        firstmap.put("atPlace", etAddress.getText().toString());
        firstmap.put("atDate", tvTime1.getText().toString());
        firstmap.put("depName", depName);
        firstmap.put("depId", depId);
        firstmap.put("lineCode", tvLuBie.getText().toString());
        firstmap.put("jiekuanren", tvName.getText().toString());
        firstmap.put("jiekuanDate", tvTime.getText().toString());
    }

    @Override
    public void setBorrowAccidentLR(BorrowAccidentLRData s) {
        if (s.isSuccess()) {
            vocationId = s.getAccidentLoanId();
            selectTag = "2";
            btnUp.setEnabled(true);
            btnLR.setEnabled(false);
            btnLR.setBackgroundColor(getResources().getColor(R.color.shouye));
            Toast.makeText(this, "录入成功请提交数据", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "录入失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setBorrowAccidentLRMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setBorrowAccidentCheckType(CheckType s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            btnUp.setEnabled(false);
            btnUp.setBackgroundColor(getResources().getColor(R.color.shouye));
            finish();
        }
    }

    @Override
    public void setBorrowAccidentCheckTypeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
