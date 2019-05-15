package com.smartbus.heze.oaflow.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.smartbus.heze.fileapprove.module.UserdLeaveContract;
import com.smartbus.heze.fileapprove.presenter.OnePresenter;
import com.smartbus.heze.fileapprove.presenter.TwoPresenter;
import com.smartbus.heze.fileapprove.presenter.UPYSDPresenter;
import com.smartbus.heze.fileapprove.presenter.UserdLeavePresenter;
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
import com.smartbus.heze.oaflow.module.CheckTypeContract;
import com.smartbus.heze.oaflow.presenter.CheckTypePresenter;

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

import static android.R.attr.permission;
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 通用请假单
 */
public class UserdLeaveActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View, UserdLeaveContract.View,CheckTypeContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.etReason)
    EditText etReason;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.spinnerAM)
    Spinner spinnerAM;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.spinnerPM)
    Spinner spinnerPM;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.etDays)
    EditText etDays;
    @BindView(R.id.btnFirst)
    Button btnFirst;
    @BindView(R.id.btnUp)
    Button btnUp;

    String uId = "";
    String vocationId = "";
    String selectPersonId = "";
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter onePersenter;
    TwoPresenter twoPersenter;
    UserdLeavePresenter userdLeavePresenter;
    UPYSDPresenter upYsdPersenter;
    CheckTypePresenter checkTypePresenter;
    Map<String, String> map = new HashMap<>();
    Map<String, String> firstmap = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1, customDatePicker2;

    ArrayAdapter<String> TypeAdapter;
    ArrayAdapter<String> TimeAdapter;
    List<String> listTime = new ArrayList<String>();
    List<String> listType = new ArrayList<String>();
    Intent intent;
    String fileName = "";
    String selectTag = "1";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        userdLeavePresenter = new UserdLeavePresenter(this, this);
        checkTypePresenter = new CheckTypePresenter(this,this);
        initDatePicker();
        String uaserName = new SharedPreferencesHelper(this, "login").getData(this, "userName", "");
        listTime.add("上午");
        listTime.add("下午");
        listTime.add("全天");

        listType.add("事假");
        listType.add("病假");
        listType.add("产假");
        listType.add("年休假");
        listType.add("陪护假");
        listType.add("小产假");
        listType.add("婚假");
        listType.add("丧假");
        listType.add("其他");
        TypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listType);
        TypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(TypeAdapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        TimeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTime);
        TimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAM.setAdapter(TimeAdapter);

        TimeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTime);
        TimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPM.setAdapter(TimeAdapter);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_userd_leave;
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
        tvStartTime.setText(now.split(" ")[0]);
        tvEndTime.setText(now.split(" ")[0]);
        customDatePicker1 = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvStartTime.setText(time.split(" ")[0]);
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
                tvEndTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker2.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker2.setIsLoop(false);
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.tvData, R.id.btnUp,
            R.id.tvDepartment, R.id.btnFirst, R.id.tvPerson})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvPerson:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.tvDepartment:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvStartTime:
                customDatePicker1.show(tvStartTime.getText().toString());
                break;
            case R.id.tvEndTime:
                customDatePicker2.show(tvEndTime.getText().toString());
                break;
            case R.id.tvData:
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
                } else {
                    File file = new File(Environment.getExternalStorageDirectory().getPath());
                    if (null == file || !file.exists()) {
                        return;
                    }
                    Intent intentD = new Intent(Intent.ACTION_GET_CONTENT);
                    intentD.addCategory(Intent.CATEGORY_OPENABLE);
                    intentD.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentD.setDataAndType(Uri.fromFile(file), "file/*");
                    try {
                        startActivityForResult(Intent.createChooser(intentD, "Select a File to Upload"), TAG_TWO);
                    } catch (ActivityNotFoundException ex) {
                        // Potentially direct the user to the Market with a Dialog
                        Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.btnUp:
                namelist.clear();
                codeList.clear();
                nameList.clear();
                selectList.clear();
                namelist1.clear();
                dataList.clear();
                onePersenter = new OnePresenter(this, this);
                onePersenter.getOnePerson(Constant.USERDLEAVE_DEFID);
                twoPersenter = new TwoPresenter(this, this);
                upYsdPersenter = new UPYSDPresenter(this, this);
                break;
            case R.id.btnFirst:
                if (tvDepartment.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择部门", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvPerson.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择人员", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvEndTime.getText().toString().equals("")
                        || tvStartTime.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择时间", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etDays.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写请假天数", Toast.LENGTH_SHORT).show();
                    break;
                }
                setDataFirst();
                userdLeavePresenter.getUserdLeave(firstmap);
                break;
        }
    }

    private void setDataFirst() {
        firstmap.put("profileId", selectPersonId);
        firstmap.put("vocationType", spinner.getSelectedItem().toString());
        firstmap.put("depName", tvDepartment.getText().toString());
        firstmap.put("depId", depId);
        firstmap.put("beginDate", tvStartTime.getText().toString());
        if (spinnerAM.getSelectedItem().toString().equals("上午")) {
            firstmap.put("ksdayType", "1");
        } else if (spinnerAM.getSelectedItem().toString().equals("下午")) {
            firstmap.put("ksdayType", "2");
        } else if (spinnerAM.getSelectedItem().toString().equals("全天")) {
            firstmap.put("ksdayType", "0");
        }
        firstmap.put("endDate", tvEndTime.getText().toString());
        if (spinnerPM.getSelectedItem().toString().equals("上午")) {
            firstmap.put("jsdayType", "1");
        } else if (spinnerPM.getSelectedItem().toString().equals("下午")) {
            firstmap.put("jsdayType", "2");
        } else if (spinnerPM.getSelectedItem().toString().equals("全天")) {
            firstmap.put("jsdayType", "0");
        }
        firstmap.put("vocationDays", etDays.getText().toString());
    }

    private void setData() {
        map.put("defId", Constant.USERDLEAVE_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.USERDLEAVE_FORMDEFIS);
        map.put("vocationType", spinner.getSelectedItem().toString());
        map.put("depName", tvDepartment.getText().toString());
        map.put("fullname", tvPerson.getText().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        simpleDateFormat.format(date);
        map.put("TianDanRiQi", simpleDateFormat.format(date));
        map.put("depId", depId);
        map.put("beginDate", tvStartTime.getText().toString());
        map.put("ksdayType", spinnerAM.getSelectedItem().toString());
        map.put("endDate", tvEndTime.getText().toString());
        map.put("jsdayType", spinnerPM.getSelectedItem().toString());
        map.put("vocationDays", etDays.getText().toString());
        map.put("dataUrl_save", "/joffice21/hrm/updateLeaveDays.do?vocationId=" + vocationId);
        map.put("bumenjingli", "");
        map.put("fenguanjingli", "");
        map.put("zongjingli", "");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case TAG_ONE:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), TAG_TWO);
                } catch (ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog
                    Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
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
                        if (FileUtils.getPath(UserdLeaveActivity.this, uri) != null) {
                            file = FileUtils.getPath(UserdLeaveActivity.this, uri);
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
                        if (depName != null) {
                            tvDepartment.setText(depName);
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void setUserdLeave(InitBackData s) {
        if (s.isSuccess()) {
            vocationId = s.getVocationId();
            selectTag = "2";
            btnUp.setEnabled(true);
            Toast.makeText(this, "录入成功请提交数据", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "录入失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void setUserdLeaveMessage(String s) {
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
                twoPersenter.getTwoPerson(Constant.USERDLEAVE_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.USERDLEAVE_DEFID, data);
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
            checkTypePresenter.getCheckType(String.valueOf(s.getRunId()),vocationId);
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, "提交数据失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCheckType(CheckType s) {
        if (s.isSuccess()){
            Toast.makeText(this, "设置成功", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(UserdLeaveActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    tvData.setText(fileName);
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_TWO:
                    Toast.makeText(UserdLeaveActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}