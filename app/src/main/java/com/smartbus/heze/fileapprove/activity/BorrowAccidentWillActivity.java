package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.BorrowAccidentWill;
import com.smartbus.heze.fileapprove.bean.DepartBudgetWill;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.BorrowAccidentWillContract;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.BorrowAccidentWillPresenter;
import com.smartbus.heze.fileapprove.presenter.NoEndPresenter;
import com.smartbus.heze.fileapprove.presenter.NoHandlerPresenter;
import com.smartbus.heze.fileapprove.presenter.NormalPresenter;
import com.smartbus.heze.fileapprove.presenter.WillDoPresenter;
import com.smartbus.heze.fileapprove.util.SplitData;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 事故科的事故借款单待办
 */
public class BorrowAccidentWillActivity extends BaseActivity implements BorrowAccidentWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvTime1)
    TextView tvTime1;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.tvLuBie)
    TextView tvLuBie;
    @BindView(R.id.tvCarNo)
    TextView tvCarNo;
    @BindView(R.id.tvDriver)
    TextView tvDriver;
    @BindView(R.id.tvBlame)
    TextView tvBlame;
    @BindView(R.id.tvReason)
    TextView tvReason;
    @BindView(R.id.tvSmallMoney)
    TextView tvSmallMoney;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvNum)
    TextView tvNum;
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

    String destType = "";
    String leaderCode = "";
    String leaderName = "";
    String destName, uId,signaName;
    String activityName, taskId;
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    NormalPresenter normalPresenter;
    NoEndPresenter noEndPersenter;
    NoHandlerPresenter noHandlerPresenter;
    WillDoPresenter willDoPresenter;
    BorrowAccidentWillPresenter borrowAccidentWillPresenter;
    List<String> selectList = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    List<DepartBudgetWill.TransBean> destTypeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        normalPresenter = new NormalPresenter(this, this);
        noEndPersenter = new NoEndPresenter(this, this);
        noHandlerPresenter = new NoHandlerPresenter(this, this);
        willDoPresenter = new WillDoPresenter(this, this);
        Log.e("sessionLogin ", taskId + "-" + activityName);
        borrowAccidentWillPresenter = new BorrowAccidentWillPresenter(this, this);
        borrowAccidentWillPresenter.getBorrowAccidentWill(activityName, taskId, Constant.HUIQIAN_DEFID);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_borrow_accident_will;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick(R.id.btnUp)
    public void onViewClicked() {
        if (etLeader.getVisibility() == View.VISIBLE
                ||etLeader1.getVisibility() == View.VISIBLE
                ||etLeader2.getVisibility() == View.VISIBLE) {
            if (etLeader.getText().toString().equals("")
                    ||etLeader1.getText().toString().equals("")
                    ||etLeader2.getText().toString().equals("")) {
                Toast.makeText(this, "请填写意见", Toast.LENGTH_SHORT).show();
            } else {
                if (destTypeList.size() != 0) {
                    if (destTypeList.size() == 1) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                destType = destTypeList.get(0).getDestType();
                                destName = destTypeList.get(0).getDestination();
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    normalPresenter.getNormalPerson(taskId, destName, "false");
                                } else if (destType.indexOf("end") == -1) {
                                    noEndPersenter.getNoEndPerson(taskId, destName, "false");
                                } else {
                                    noHandlerPresenter.getNoHandlerPerson(taskId);
                                }
                                signaName = destTypeList.get(0).getName();
                            }
                        }).start();
                    } else {
                        for (int i = 0; i < destTypeList.size(); i++) {
                            namelist.add(destTypeList.get(i).getDestination());
                        }
                        MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data) {
                                destName = data;
                                for (int i = 0; i < destTypeList.size(); i++) {
                                    if (destName.equals(destTypeList.get(i).getDestination())) {
                                        signaName = destTypeList.get(i).getName();
                                        destType = destTypeList.get(i).getDestType();
                                    }
                                }
                                if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                    normalPresenter.getNormalPerson(taskId, destName, "false");
                                } else if (destType.indexOf("end") == -1) {
                                    noEndPersenter.getNoEndPerson(taskId, destName, "false");
                                } else {
                                    noHandlerPresenter.getNoHandlerPerson(taskId);
                                }
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
        }
    }

    private void setData() {
        map.put("defId", Constant.BORROWACCIDENT_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.BORROWACCIDENT_FORMDEFIS);
        map.put("depName", tvDepartment.getText().toString());
        map.put("jiekuanDate", tvTime.getText().toString());
        map.put("atDate", tvTime1.getText().toString());
        map.put("atPlace", tvAddress.getText().toString());
        map.put("lineCode", tvLuBie.getText().toString());
        map.put("carNo", tvCarNo.getText().toString());
        map.put("driverName", tvDriver.getText().toString());
        map.put("acDuty", tvBlame.getText().toString());
        map.put("atAfter", tvReason.getText().toString());
        map.put("atje", tvSmallMoney.getText().toString());
        map.put("acNumber", tvNum.getText().toString());
        map.put("jiekuanren", tvName.getText().toString());
        if (tvLeader.getVisibility() == View.VISIBLE) {
            map.put("kezhang", new SplitData().SplitUpData(tvLeader.getText().toString()));
        } else {
            map.put("kezhang", new SplitData().SplitUpData(etLeader.getText().toString()));
            map.put("comments", etLeader.getText().toString());
        }
        if (tvLeader1.getVisibility() == View.VISIBLE) {
            map.put("fenguanlingdao", new SplitData().SplitUpData(tvLeader1.getText().toString()));
        } else {
            map.put("fenguanlingdao", new SplitData().SplitUpData(etLeader1.getText().toString()));
            map.put("comments", etLeader1.getText().toString());
        }
        if (tvLeader2.getVisibility() == View.VISIBLE) {
            map.put("caiwujingli", new SplitData().SplitUpData(tvLeader2.getText().toString()));
        } else {
            map.put("caiwujingli", new SplitData().SplitUpData(etLeader2.getText().toString()));
            map.put("comments", etLeader2.getText().toString());
        }
        if (tvLeader3.getVisibility() == View.VISIBLE) {
            map.put("ldps", new SplitData().SplitUpData(tvLeader3.getText().toString()));
        } else {
            map.put("ldps", new SplitData().SplitUpData(etLeader3.getText().toString()));
            map.put("comments", etLeader3.getText().toString());
        }
    }

    @Override
    public void setBorrowAccidentWill(BorrowAccidentWill s) {

    }

    @Override
    public void setBorrowAccidentWillMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNormalPerson(NormalPerson s) {
        if (s.getData() != null) {
            leaderName = s.getData().get(0).getUserNames();
            leaderCode = s.getData().get(0).getUserCodes();
            bigNametemp = leaderName.split(",");
            bigCodetemp = leaderCode.split(",");
            setDialog();
        }
    }

    @Override
    public void setNormalPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNoEndPerson(NoEndPerson s) {
        if (s.getData() != null) {
            leaderName = s.getData().get(0).getUserNames();
            leaderCode = s.getData().get(0).getUserCodes();
            bigNametemp = leaderName.split(",");
            bigCodetemp = leaderCode.split(",");
            setDialog();
        }
    }

    @Override
    public void setNoEndPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNoHandlerPerson(NoHandlerPerson s) {
        setData();
        map.put("flowAssignId", destName + "|" + uId);
    }

    @Override
    public void setNoHandlerPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWillDo(WillDoUp s) {

    }

    @Override
    public void setWillDoMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void setDialog() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog alertDialog3 = alertDialogBuilder.create();
//                alertDialogBuilder.setTitle("java EE 常用框架");
        // 参数介绍
        // 第一个参数：弹出框的信息集合，一般为字符串集合
        // 第二个参数：被默认选中的，一个布尔类型的数组
        // 第三个参数：勾选事件监听
        final boolean[] checkedItems = new boolean[bigNametemp.length + 1];
        for (int i = 0; i < bigNametemp.length; i++) {
            checkedItems[i] = false;
        }
        new AlertDialog.Builder(this)
                .setTitle("选择时间")//标题栏
                .setMultiChoiceItems(bigNametemp, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
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
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //TODO 业务逻辑代码
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        selectList.add(bigCodetemp[i]);
                    }
                }
                getListData();
                setData();
                // 关闭提示框
                alertDialog3.dismiss();
                map.put("flowAssignId", destName + "|" + uId);
                willDoPresenter.getWillDo(map);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO 业务逻辑代码

                // 关闭提示框
                alertDialog3.dismiss();
            }
        }).show();
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
}
