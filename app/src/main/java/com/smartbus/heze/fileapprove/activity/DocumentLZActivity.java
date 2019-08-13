package com.smartbus.heze.fileapprove.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.MyApplication;
import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.fileapprove.bean.LZLR;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.DocumentLRContract;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.fileapprove.presenter.DocumentLRPresenter;
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
import static com.smartbus.heze.http.base.Constant.TAG_FOUR;
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 公文流转
 */
public class DocumentLZActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View, DocumentLRContract.View {
    //, CheckTypeLRContract.View
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.etBianHao)
    EditText etBianHao;
    @BindView(R.id.etNum)
    EditText etNum;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.btnPerson)
    Button btnPerson;
    @BindView(R.id.tvCBDW)
    TextView tvCBDW;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.btnLR)
    Button btnLR;
    @BindView(R.id.btnUp)
    Button btnUp;

    Intent intent;
    String uId = "",runId = "";
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
    DocumentLRPresenter documentLRPresenter;
    Map<String, String> map = new HashMap<>();
    Map<String, String> lrMap = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> selectList1 = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private CustomDatePickerDay customDatePicker1;
    String fileName ,fileId= "";
    String selectTag = "1";
    String vocationId = "";
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        btnLR.setVisibility(View.VISIBLE);
        initDatePicker();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_document_lz;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent(this,DocumentLZListActivity.class);
        startActivity(intent);
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
        map.put("defId", Constant.DOCUMENTLZ_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.DOCUMENTLZ_FORMDEFIS);
        map.put("destName", userDepart);
        map.put("shouwenRq", tvTime.getText().toString());
        map.put("fawenjig", tvDepartment.getText().toString());
        map.put("wenjianNo", etBianHao.getText().toString());
        map.put("fawennum", etNum.getText().toString());
        map.put("title", etTitle.getText().toString());
        map.put("fujian", tvData.getText().toString()+"");
        map.put("dataUrl_save", "/joffice/hrm/updateLeaveDays.do?vocationId=" + vocationId);
        map.put("nibanyj", "");
        map.put("ldyj", "");
        map.put("chengbanjg", "");
    }

    private void setLZ() {
        lrMap.put("lvUndertake", tvDepartment.getText().toString());
        lrMap.put("lvDepId", depId);
        lrMap.put("lvDepName", tvCBDW.getText().toString());
        lrMap.put("lvDate", tvTime.getText().toString());
        lrMap.put("lvCode", etBianHao.getText().toString());
        lrMap.put("lvnumber", etNum.getText().toString());
        lrMap.put("lvTitle", etTitle.getText().toString());
        lrMap.put("fileIds", fileId);
        lrMap.put("zt", "0");
        lrMap.put("lvProposedopinions", "");
        lrMap.put("lvInstructions", "");
        lrMap.put("lvResult", "");
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
                twoPersenter.getTwoPerson(Constant.DOCUMENTLZ_DEFID, namelist.get(0));
//                Intent intent = new Intent(this, WorkPersonActivity.class);
//                startActivity(intent);
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        twoPersenter.getTwoPerson(Constant.DOCUMENTLZ_DEFID, data);
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
                if (selectList1 != null) {
                    for (int i = 0; i < selectList1.size(); i++) {
                        selectList.add(selectList1.get(i));
                    }
                }
                getListData();
                setData();
                map.put("flowAssignId", userDepart + "|" + uId);
                upYsdPersenter.getUPYSD(map);
            } else {
                MyAlertDialog.MyListAlertDialog(isShow, codeList, nameList, namelist1, this, new AlertDialogCallBackP() {

                    @Override
                    public void select(List<String> data) {
                        selectList = data;
                        selectList.add(codeList.get(0));
                        if (selectList1 != null) {
                            for (int i = 0; i < selectList1.size(); i++) {
                                selectList.add(selectList1.get(i));
                            }
                        }
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
            runId = String.valueOf(s.getRunId());
            documentLRPresenter.getCheckTypeLR(runId,vocationId,userDepart,"","","","");
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, "提交数据失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setDocumentLR(LZLR s) {
        if (s.isSuccess()) {
            vocationId = s.getLvId();
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
    public void setDocumentLRMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCheckTypeLR(CheckType s) {
        if (s.isSuccess()){
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setCheckTypeLRMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.tvTime, R.id.tvDepartment, R.id.btnPerson, R.id.btnUp, R.id.tvCBDW
            , R.id.tvData, R.id.btnLR})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLR:
                setLZ();
                documentLRPresenter = new DocumentLRPresenter(this,this);
                documentLRPresenter.getDocumentLR(lrMap);
                break;
            case R.id.tvCBDW:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, Constant.TAG_THERE);
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
                        startActivityForResult(Intent.createChooser(intentD, "Select a File to Upload"), Constant.TAG_FOUR);
                    } catch (ActivityNotFoundException ex) {
                        // Potentially direct the user to the Market with a Dialog
                        Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.tvTime:
                customDatePicker1.show(tvTime.getText().toString());
                break;
            case R.id.tvDepartment:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, Constant.TAG_ONE);
                break;
            case R.id.btnPerson:
                intent = new Intent(this, WorkPersonActivity.class);
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.btnUp:
                namelist.clear();
                codeList.clear();
                nameList.clear();
                selectList.clear();
                namelist1.clear();
                dataList.clear();
                onePersenter = new OnePresenter(this, this);
                onePersenter.getOnePerson(Constant.DOCUMENTLZ_DEFID);
                twoPersenter = new TwoPresenter(this, this);
                upYsdPersenter = new UPYSDPresenter(this, this);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case Constant.TAG_ONE:
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), Constant.TAG_FOUR);
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
                if (resultCode == Constant.TAG_ONE) {
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
                        selectList1 = data.getStringArrayListExtra("bean");
                    }
                }
                break;
            case TAG_THERE:
                if (resultCode == Constant.TAG_ONE) {
                    if (data != null) {
                        DepartmentDataBean departmentDataBean = (DepartmentDataBean) data.getSerializableExtra("department");
//                        depId = departmentDataBean.getDepId();
                        depName = departmentDataBean.getDepName();
                        tvCBDW.setText(depName);
                    }
                }
                break;
            case TAG_FOUR:
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    File file = null;
                    String[] proj = {MediaStore.Images.Media.DATA};
                    Cursor actualimagecursor = this.managedQuery(uri, proj, null, null, null);
                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    actualimagecursor.moveToFirst();
                    String img_path = actualimagecursor.getString(actual_image_column_index);
                    if (img_path == null) {
                        try {
                            if (FileUtils.getPath(DocumentLZActivity.this, uri) != null) {
                                file = FileUtils.getPath(DocumentLZActivity.this, uri);
                            }
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    } else {
                        file = new File(img_path);
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
                                fileId = jsonObject.getString("fileId");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            Message message = new Message();
                            message.what = Constant.TAG_ONE;
                            handler.sendMessage(message);
                        }

                        @Override
                        public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                            super.onFailure(statusCode, headers, responseBody, error);
                            Log.i("XXX", "XXXXX");
                            Message message = new Message();
                            message.what = Constant.TAG_TWO;
                            handler.sendMessage(message);
                        }
                    });
                }
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(DocumentLZActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    tvData.setText(fileName);
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(DocumentLZActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };

}
