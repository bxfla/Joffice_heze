package com.smartbus.heze.oaflow.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.MyApplication;
import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.fileapprove.activity.DepartmentActivity;
import com.smartbus.heze.fileapprove.activity.WorkOnePersonActivity;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.fileapprove.presenter.OnePresenter;
import com.smartbus.heze.fileapprove.presenter.TwoPresenter;
import com.smartbus.heze.fileapprove.presenter.UPYSDPresenter;
import com.smartbus.heze.fileapprove.util.FileUtils;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;
import com.smartbus.heze.oaflow.bean.CheckType;
import com.smartbus.heze.oaflow.module.CheckCheckTypeContract;
import com.smartbus.heze.oaflow.module.CheckWorkContract;
import com.smartbus.heze.oaflow.presenter.CheckWorkCheckTypePresenter;
import com.smartbus.heze.oaflow.presenter.CheckWorkPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 通用调休单
 */
public class CheckWorkActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View, CheckWorkContract.View, CheckCheckTypeContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.etLeader)
    TextView etLeader;
    @BindView(R.id.etLeader1)
    TextView etLeader1;
    @BindView(R.id.btnFirst)
    Button btnFirst;
    @BindView(R.id.btnUp)
    Button btnUp;

    Intent intent;
    String ecard = "";
    String mnemonicCard = "";
    String selectTag = "1";
    String vocationId = "";
    String selectPersonId = "";
    String uId = "";
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter onePersenter;
    TwoPresenter twoPersenter;
    UPYSDPresenter upYsdPersenter;
    CheckWorkPresenter checkWorkPresenter;
    CheckWorkCheckTypePresenter checkWorkCheckTypePresenter;
    Map<String, String> map = new HashMap<>();
    Map<String, String> firstmap = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker2;
    List<String> listTime = new ArrayList<String>();
    String fileName = "";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        header.setTvTitle(getResources().getString(R.string.change_work));
        checkWorkPresenter = new CheckWorkPresenter(this,this);
        checkWorkCheckTypePresenter = new CheckWorkCheckTypePresenter(this,this);
        listTime.add("上午");
        listTime.add("下午");
        listTime.add("全天");
        ArrayAdapter TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTime);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(TypeAdapter);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_at_work;
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
        tvEndTime.setText(now.split(" ")[0]);
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

    private void setData() {
        map.put("defId", Constant.CHECKWORK_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.CHECKWORK_FORMDEFIS);
        map.put("memo", etReason.getText().toString());
        map.put("dayType", spinner.getSelectedItem().toString());
        map.put("createTime", tvEndTime.getText().toString());
        map.put("userName", tvPerson.getText().toString());
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Date curDate =  new Date(System.currentTimeMillis());
        String str = formatter.format(curDate);
        map.put("fillDate", str);
        map.put("dataUrl_save", "/joffice21/hrm/updateLeaveDays.do?vocationId=" + vocationId);
    }

    private void setDataFirst() {
        firstmap.put("userCode", ecard);
        firstmap.put("depId", depId);
        firstmap.put("userName", tvPerson.getText().toString());
        firstmap.put("fillDate", tvEndTime.getText().toString());
        firstmap.put("dayType", spinner.getSelectedItem().toString());
        firstmap.put("memo", etReason.getText().toString());
    }

    @OnClick({R.id.tvPerson, R.id.tvDepartment, R.id.tvEndTime, R.id.btnFirst, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPerson:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
            break;
            case R.id.btnFirst:
                if (tvPerson.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择申请人", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etReason.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写调休说明", Toast.LENGTH_SHORT).show();
                    break;
                }
                setDataFirst();
                checkWorkPresenter.getCheckWork(firstmap);
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvDepartment:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.btnUp:
                if (selectTag.equals("2")){
                    namelist.clear();
                    codeList.clear();
                    nameList.clear();
                    selectList.clear();
                    namelist1.clear();
                    dataList.clear();
                    if (etReason.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写调休说明", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if (tvPerson.getText().toString().equals("")) {
                        Toast.makeText(this, "请选择申请人", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    onePersenter = new OnePresenter(this, this);
                    onePersenter.getOnePerson(Constant.CHECKWORK_DEFID);
                    twoPersenter = new TwoPresenter(this, this);
                    upYsdPersenter = new UPYSDPresenter(this, this);
                }else {
                    Toast.makeText(this, "请先录入", Toast.LENGTH_SHORT).show();
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
                        depId = departmentDataBean.getDepId();
                        depName = departmentDataBean.getDepName();
                        tvDepartment.setText(depName);
                    }
                }
                break;
            case TAG_TWO:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    File file = null;
                    try {
                        if (FileUtils.getPath(CheckWorkActivity.this, uri) != null) {
                            file = FileUtils.getPath(CheckWorkActivity.this, uri);
                        }
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    Log.e("XXX", file.toString());
                    final AsyncHttpClient client = new AsyncHttpClient();
                    final String url = ApiAddress.mainApi + ApiAddress.dataup;
                    String userId = new SharedPreferencesHelper(MyApplication.getContext(), "login").
                            getData(MyApplication.getContext(), "userId", "");
                    final RequestParams params = new RequestParams();
                    try {
                        params.put("upload", file);
                        params.put("fullname", file.getName());
                        params.put("userId", userId);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ProgressDialogUtil.startLoad(this, MainUtil.upData);
                    client.post(url, params, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int arg0, String arg1) {
                            super.onSuccess(arg0, arg1);
                            Log.i("XXX", arg1);
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(arg1.toString());
                                fileName = jsonObject.getString("fileName");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Message message = new Message();
                            message.what = TAG_ONE;
                            handler.sendMessage(message);
                        }

                        @Override
                        public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                            super.onFailure(statusCode, headers, responseBody, error);
                            Log.i("XXX", "XXXXX");
                            Message message = new Message();
                            message.what = TAG_TWO;
                            handler.sendMessage(message);
                        }
                    });
                }
                break;
            case TAG_THERE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvPerson.setText(data.getStringArrayListExtra("beanId").get(0));
                        selectPersonId = data.getStringArrayListExtra("bean").get(0);
                        depName = data.getStringExtra("department");
                        depId = data.getStringExtra("departmentId");
                        mnemonicCard = data.getStringExtra("mnemonicCard");
                        ecard = data.getStringExtra("ecard");
                        if (depName != null) {
                            tvDepartment.setText(depName);
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void setCheckWork(InitBackData s) {
        if (s.isSuccess()) {
            vocationId = s.getVocationId();
            selectTag = "2";
            btnUp.setEnabled(true);
            btnFirst.setEnabled(false);
            btnFirst.setBackgroundColor(getResources().getColor(R.color.shouye));
            Toast.makeText(this, "录入成功请提交数据", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "录入失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setCheckWorkMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
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
                twoPersenter.getTwoPerson(Constant.CHECKWORK_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.CHECKWORK_DEFID, data);
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
            checkWorkCheckTypePresenter.getCheckType(String.valueOf(s.getRunId()), vocationId);
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCheckType(CheckType s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            btnUp.setEnabled(false);
            btnUp.setBackgroundColor(getResources().getColor(R.color.shouye));
            finish();
        }
    }

    @Override
    public void setCheckTypeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_ONE:
                    Toast.makeText(CheckWorkActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    tvData.setText(fileName);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(CheckWorkActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
