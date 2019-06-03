package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
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
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.R.attr.permission;
import static com.smartbus.heze.http.base.Constant.TAG_FIVE;
import static com.smartbus.heze.http.base.Constant.TAG_FOUR;
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_SIX;
import static com.smartbus.heze.http.base.Constant.TAG_THERE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 会签发文
 */
public class HuiQianActivity extends BaseActivity implements OneContract.View
        , TwoContract.View, UPYSDContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etTitle)
    EditText etTitle;
    @BindView(R.id.etTheme)
    EditText etTheme;
    @BindView(R.id.etContent)
    EditText etContent;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.et2)
    EditText et2;
    @BindView(R.id.et3)
    EditText et3;
    @BindView(R.id.et4)
    EditText et4;
    @BindView(R.id.tvQianFa)
    TextView tvQianFa;
    @BindView(R.id.tvHuiQian)
    TextView tvHuiQian;
    @BindView(R.id.tvZhuSong)
    TextView tvZhuSong;
    @BindView(R.id.tvCaoSong)
    TextView tvCaoSong;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.etNiGao)
    EditText etNiGao;
    @BindView(R.id.etHeGao)
    EditText etHeGao;
    @BindView(R.id.etYinShua)
    EditText etYinShua;
    @BindView(R.id.etJiaoDui)
    EditText etJiaoDui;
    @BindView(R.id.etFenShu)
    EditText etFenShu;
    @BindView(R.id.btnUp)
    Button btnUp;

    String uId = "";
    String fileName = "";
    String userDepart = "";
    String userCode = "";
    String userName = "";
    Intent intent;
    String[] nametemp = null;
    String[] codetemp = null;
    String depId = "", depName = "";
    OnePresenter ysdOnePersenter;
    TwoPresenter ysdTwoPersenter;
    UPYSDPresenter upYsdPersenter;
    Map<String, String> map = new HashMap<>();
    List<String> namelist = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    List<String> namelist1 = new ArrayList<>();
    List<TwoPerson.DataBean> dataList = new ArrayList<>();
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_huiqian;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvData, R.id.btnUp, R.id.tvDepartment,R.id.tvQianFa, R.id.tvHuiQian, R.id.tvZhuSong, R.id.tvCaoSong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDepartment:
                intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
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
                        startActivityForResult(Intent.createChooser(intentD, "Select a File to Upload"), Constant.TAG_TWO);
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
                if (tvDepartment.getText().toString().equals("")) {
                    Toast.makeText(this, "请选择部门", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etTitle.getText().toString().equals("") || etTheme.getText().toString().equals("")
                        || etContent.getText().toString().equals("")) {
                    Toast.makeText(this, "请填写标题，主题词和内容", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvQianFa.getText().toString().equals("") || tvHuiQian.getText().toString().equals("")) {
                    Toast.makeText(this, "签发人，会签人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvZhuSong.getText().toString().equals("") || tvCaoSong.getText().toString().equals("")) {
                    Toast.makeText(this, "主送人，抄送人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etNiGao.getText().toString().equals("") || etHeGao.getText().toString().equals("")) {
                    Toast.makeText(this, "拟稿人，核稿人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (tvDepartment.getText().toString().equals("") || etYinShua.getText().toString().equals("")
                        || etJiaoDui.getText().toString().equals("") || etFenShu.getText().toString().equals("")) {
                    Toast.makeText(this, "部门，印刷，校对，分数不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                ysdOnePersenter = new OnePresenter(this, this);
                ysdOnePersenter.getOnePerson(Constant.HUIQIAN_DEFID);
                ysdTwoPersenter = new TwoPresenter(this, this);
                upYsdPersenter = new UPYSDPresenter(this, this);
                break;
            case R.id.tvQianFa:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_THERE);
                break;
            case R.id.tvHuiQian:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_FOUR);
                break;
            case R.id.tvZhuSong:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_FIVE);
                break;
            case R.id.tvCaoSong:
                intent = new Intent(this, WorkOnePersonActivity.class);
                startActivityForResult(intent, TAG_SIX);
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
                    startActivityForResult(Intent.createChooser(intent, "Select a File to Upload"), Constant.TAG_TWO);
                } catch (ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog
                    Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void setData() {
        map.put("defId", Constant.HUIQIAN_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.HUIQIAN_FORMDEFIS);
        map.put("depNameDid", depId);
        map.put("depName", depName);
        map.put("hao1", et1.getText().toString());
        map.put("hao2", et2.getText().toString());
        map.put("urgency", et3.getText().toString());
        map.put("secret", et4.getText().toString());
        map.put("Issue", tvQianFa.getText().toString());
        map.put("sign", "");
        map.put("delivery", tvZhuSong.getText().toString());
        map.put("copy", tvCaoSong.getText().toString());
        map.put("draftingDep", tvDepartment.getText().toString());
        map.put("draft", etNiGao.getText().toString());
        map.put("nuclear", etHeGao.getText().toString());
        map.put("printing", etYinShua.getText().toString());
        map.put("proofreading", etJiaoDui.getText().toString());
        map.put("nums", etFenShu.getText().toString());
        map.put("file", fileName);
        map.put("themeWord", etTheme.getText().toString());
        map.put("title", etTitle.getText().toString());
        map.put("content", etContent.getText().toString());
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
                    String[] proj = { MediaStore.Images.Media.DATA };
                    Cursor actualimagecursor = this.managedQuery(uri,proj,null,null,null);
                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    actualimagecursor.moveToFirst();
                    String img_path = actualimagecursor.getString(actual_image_column_index);
                    file = new File(img_path);
//                    try {
//                        if (FileUtils.getPath(HuiQianActivity.this, uri) != null) {
//                            file = FileUtils.getPath(HuiQianActivity.this, uri);
//                        }
//                    } catch (URISyntaxException e) {
//                        e.printStackTrace();
//                    }
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
                            message.what = Constant.TAG_ONE;
                            handler.sendMessage(message);
                        }

                        @Override
                        public void onFailure(int statusCode, org.apache.http.Header[] headers, byte[] responseBody, Throwable error) {
                            super.onFailure(statusCode, headers, responseBody, error);
                            Log.i("XXX", error.getMessage().toString());
                            Message message = new Message();
                            message.what = Constant.TAG_TWO;
                            handler.sendMessage(message);
                        }
                    });
                }
                break;
            case TAG_THERE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvQianFa.setText(data.getStringArrayListExtra("beanId").get(0));
                    }
                }
                break;
            case TAG_FOUR:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvHuiQian.setText(data.getStringArrayListExtra("beanId").get(0));
                    }
                }
                break;
            case TAG_FIVE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvZhuSong.setText(data.getStringArrayListExtra("beanId").get(0));
                    }
                }
                break;
            case TAG_SIX:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        tvCaoSong.setText(data.getStringArrayListExtra("beanId").get(0));
                    }
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
                ysdTwoPersenter.getTwoPerson(Constant.HUIQIAN_DEFID, namelist.get(0));
            } else {
                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                    @Override
                    public void oneselect(final String data) {
                        userDepart = data;
                        ysdTwoPersenter.getTwoPerson(Constant.HUIQIAN_DEFID, data);
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
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                final AlertDialog alertDialog3 = alertDialogBuilder.create();
//                alertDialogBuilder.setTitle("java EE 常用框架");
                // 参数介绍
                // 第一个参数：弹出框的信息集合，一般为字符串集合
                // 第二个参数：被默认选中的，一个布尔类型的数组
                // 第三个参数：勾选事件监听
                final boolean[] checkedItems = new boolean[]{};
                String[] array = (String[]) nameList.toArray(new String[nameList.size()]);
                for (int i = 0; i < nameList.size(); i++) {
                    checkedItems[i] = false;
                }
                alertDialogBuilder.setMultiChoiceItems(array, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // dialog：不常使用，弹出框接口
                        // which：勾选或取消的是第几个
                        // isChecked：是否勾选
                        if (isChecked) {
                            // 选中
                            checkedItems[which] = isChecked;
                        } else {
                            // 取消选中
                            checkedItems[which] = isChecked;
                        }
                    }
                });
                alertDialogBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        //TODO 业务逻辑代码
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                selectList.add(namelist.get(i));
                            }
                        }
                        getListData();
                        setData();
                        map.put("flowAssignId", userDepart + "|" + uId);
                        // 关闭提示框
                        alertDialog3.dismiss();
                        upYsdPersenter.getUPYSD(map);
                    }
                });
                alertDialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO 业务逻辑代码

                        // 关闭提示框
                        alertDialog3.dismiss();
                    }
                });
                alertDialog3.show();
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
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setUPYSDMessage(String s) {
        Toast.makeText(this, "提交数据失败", Toast.LENGTH_SHORT).show();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case Constant.TAG_ONE:
                    Toast.makeText(HuiQianActivity.this, "文件上传成功", Toast.LENGTH_SHORT).show();
                    tvData.setText(fileName);
                    ProgressDialogUtil.stopLoad();
                    break;
                case Constant.TAG_TWO:
                    Toast.makeText(HuiQianActivity.this, "文件上传失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
            }
        }
    };
}
