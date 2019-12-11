package com.smartbus.heze.fileapprove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.AccidentLRData;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.AccidentCheckTypeContract;
import com.smartbus.heze.fileapprove.module.CurrencyAccidentLRContract;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.fileapprove.presenter.AccidentCheckTypePresenter;
import com.smartbus.heze.fileapprove.presenter.CurrencyAccidentLRPresenter;
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

import static com.smartbus.heze.http.base.Constant.TAG_ONE;

/**
 * 通用借款单
 */
public class CurrencyAccidentActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View, CurrencyAccidentLRContract.View, AccidentCheckTypeContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etSmallMoney)
    EditText etSmallMoney;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.etReason)
    EditText etReason;
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
    String eCard = "";
    String vocationId = "";
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    String selectTag = "1";
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter onePersenter;
    TwoPresenter twoPersenter;
    UPYSDPresenter upYsdPersenter;
    AccidentCheckTypePresenter accidentCheckTypePresenter;
    CurrencyAccidentLRPresenter currencyAccidentLRPresenter;
    Map<String, String> map = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    Map<String, String> firstmap = new HashMap<>();
    private CustomDatePickerDay customDatePicker1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        accidentCheckTypePresenter = new AccidentCheckTypePresenter(this, this);
        currencyAccidentLRPresenter = new CurrencyAccidentLRPresenter(this, this);
        initDatePicker();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_borrow_current;
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
    }

    private void setData() {
        map.put("defId", Constant.CURRENCYACCIDENT_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.CURRENCYACCIDENT_FORMDEFIS);
        map.put("jiekuanDate", tvTime.getText().toString());
        map.put("jiekuansy", etReason.getText().toString());
        map.put("jiekuanje", etSmallMoney.getText().toString());
        map.put("jiekuanren", tvName.getText().toString());
        map.put("dataUrl_save", "/joffice/busmanager/updateVersatileLoan.do?versatileLoanId=" + vocationId);
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
                twoPersenter.getTwoPerson(Constant.CURRENCYACCIDENT_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.CURRENCYACCIDENT_DEFID, data);
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
            accidentCheckTypePresenter.getAccidentCheckType(String.valueOf(s.getRunId()), vocationId);
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, "提交数据失败", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tvTime, R.id.btnUp, R.id.tvName, R.id.btnLR})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvName:
                Intent intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.btnLR:
                if (etReason.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写借款原因", Toast.LENGTH_SHORT).show();
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
                setDataFirst();
                currencyAccidentLRPresenter.getCurrencyAccidentLR(firstmap);
                break;
            case R.id.btnUp:
                if (selectTag.equals("2")) {
                    namelist.clear();
                    codeList.clear();
                    nameList.clear();
                    selectList.clear();
                    namelist1.clear();
                    dataList.clear();
                    if (etReason.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写借款原因", Toast.LENGTH_SHORT).show();
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
                    onePersenter = new OnePresenter(this, this);
                    onePersenter.getOnePerson(Constant.CURRENCYACCIDENT_DEFID);
                    twoPersenter = new TwoPresenter(this, this);
                    upYsdPersenter = new UPYSDPresenter(this, this);
                } else {
                    Toast.makeText(this, "请先录入", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void setDataFirst() {
        firstmap.put("jkDate", tvTime.getText().toString());
        firstmap.put("jkMoney", etSmallMoney.getText().toString());
        firstmap.put("jiekuanren", tvName.getText().toString());
        firstmap.put("jkreCard", eCard);
        firstmap.put("jkCause", etReason.getText().toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvName.setText(data.getStringArrayListExtra("beanId").get(0));
                        eCard = data.getStringArrayListExtra("bean").get(0);
                    }
                }
                break;
        }
    }

    @Override
    public void setCurrencyAccidentLR(AccidentLRData s) {
        if (s.isSuccess()) {
            vocationId = s.getVersatileLoanId();
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
    public void setCurrencyAccidentLRMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setAccidentCheckType(CheckType s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            btnUp.setEnabled(false);
            btnUp.setBackgroundColor(getResources().getColor(R.color.shouye));
            finish();
        }
    }

    @Override
    public void setAccidentCheckTypeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
