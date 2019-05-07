package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
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
import com.smartbus.heze.fileapprove.util.FileUtils;
import com.smartbus.heze.fileapprove.util.SplitData;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;
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
    @BindView(R.id.etQianFa)
    EditText etQianFa;
    @BindView(R.id.etHuiQian)
    EditText etHuiQian;
    @BindView(R.id.etZhuSong)
    EditText etZhuSong;
    @BindView(R.id.etCaoSong)
    EditText etCaoSong;
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
    String isShow = "true";
    String userDepart = "";
    String userCode = "";
    String userName = "";
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
    private CustomDatePickerDay customDatePicker1;

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

    @OnClick({R.id.tvData, R.id.btnUp, R.id.tvDepartment})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDepartment:
                Intent intent = new Intent(this, DepartmentActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.tvData:
                Intent intentD = new Intent(Intent.ACTION_GET_CONTENT);
                intentD.setType("*/*");
                intentD.addCategory(Intent.CATEGORY_OPENABLE);
                try {
                    startActivityForResult(Intent.createChooser(intentD, "Select a File to Upload"), Constant.TAG_TWO);
                } catch (android.content.ActivityNotFoundException ex) {
                    // Potentially direct the user to the Market with a Dialog
                    Toast.makeText(this, "Please install a File Manager.", Toast.LENGTH_SHORT).show();
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
                if (etQianFa.getText().toString().equals("") || etHuiQian.getText().toString().equals("")) {
                    Toast.makeText(this, "签发人，会签人不能为空", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (etZhuSong.getText().toString().equals("") || etCaoSong.getText().toString().equals("")) {
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
                } catch (android.content.ActivityNotFoundException ex) {
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
        map.put("Issue", etQianFa.getText().toString());
        map.put("sign", new SplitData().SplitUpData(etHuiQian.getText().toString()));
        map.put("delivery", etZhuSong.getText().toString());
        map.put("copy", etCaoSong.getText().toString());
        map.put("draftingDep", tvDepartment.getText().toString());
        map.put("draft", etNiGao.getText().toString());
        map.put("nuclear", etHeGao.getText().toString());
        map.put("printing", etYinShua.getText().toString());
        map.put("proofreading", etJiaoDui.getText().toString());
        map.put("nums", etFenShu.getText().toString());
        map.put("file", "");
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
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    Log.d("XXX", "File Uri: " + uri.toString());
                    // Get the path
                    String path = null;
                    try {
                        path = FileUtils.getPath(this, uri);
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                    Log.d("XXX", "File Path: " + path);
                    // Get the file instance
                    // File file = new File(path);
                    // Initiate the upload
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

}
