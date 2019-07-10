package com.smartbus.heze.oaflow.activity;

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
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.NoEndPresenter;
import com.smartbus.heze.fileapprove.presenter.NoHandlerPresenter;
import com.smartbus.heze.fileapprove.presenter.NormalPresenter;
import com.smartbus.heze.fileapprove.presenter.WillDoPresenter;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;
import com.smartbus.heze.oaflow.bean.CheckType;
import com.smartbus.heze.oaflow.bean.OldWorkWill;
import com.smartbus.heze.oaflow.module.OldCheckTypeContract;
import com.smartbus.heze.oaflow.module.OldWorkWillContract;
import com.smartbus.heze.oaflow.presenter.OldWorkCheckTypePresenter;
import com.smartbus.heze.oaflow.presenter.OldWorkWillPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 补勤待办
 */
public class OldWorkWillActivity extends BaseActivity implements OldWorkWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View
        , OldCheckTypeContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvPerson)
    TextView tvPerson;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvStartTime)
    TextView tvStartTime;
    @BindView(R.id.tvEndTime)
    TextView tvEndTime;
    @BindView(R.id.tvType)
    TextView tvType;
    @BindView(R.id.etReason)
    TextView etReason;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tvLeader)
    TextView tvLeader;
    @BindView(R.id.etLeader)
    EditText etLeader;
    @BindView(R.id.tvLeader1)
    TextView tvLeader1;
    @BindView(R.id.etLeader1)
    EditText etLeader1;
    @BindView(R.id.btnUp)
    Button btnUp;

    String role = "";
    String vocationId = "";
    String mainId = "";
    String destType = "";
    String leaderCode = "";
    String leaderName = "";
    String destName, uId = "", signaName;
    String activityName, taskId;
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    NormalPresenter normalPresenter;
    NoEndPresenter noEndPersenter;
    NoHandlerPresenter noHandlerPresenter;
    WillDoPresenter willDoPresenter;
    OldWorkCheckTypePresenter checkTypePresenter;
    OldWorkWillPresenter oldWorkWillPresenter;
    List<String> selectList = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    List<OldWorkWill.TransBean> destTypeList = new ArrayList<>();
    @BindView(R.id.tvMonth)
    TextView tvMonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        checkTypePresenter = new OldWorkCheckTypePresenter(this, this);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        normalPresenter = new NormalPresenter(this, this);
        noEndPersenter = new NoEndPresenter(this, this);
        noHandlerPresenter = new NoHandlerPresenter(this, this);
        willDoPresenter = new WillDoPresenter(this, this);
        Log.e("sessionLogin ", taskId + "-" + activityName);
        oldWorkWillPresenter = new OldWorkWillPresenter(this, this);
        oldWorkWillPresenter.getOldWorkWill(activityName, taskId, Constant.OLDWORK_DEFID);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_will_old_work;
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
                || etLeader1.getVisibility() == View.VISIBLE) {
            if (etLeader.getText().toString().equals("")
                    && etLeader1.getText().toString().equals("")) {
                Toast.makeText(this, "请填写意见", Toast.LENGTH_SHORT).show();
            } else {
                getSomeData();
            }
        } else {
            getSomeData();
        }
    }

    public void getSomeData() {
        if (destTypeList.size() != 0) {
            if (destTypeList.size() == 1) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
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
//                    }
//                }).start();
            } else {
                namelist.clear();
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

    private void setData() {
        map.put("defId", Constant.OLDWORK_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.OLDWORK_FORMDEFIS);
        map.put("userName", tvPerson.getText().toString());
        map.put("createTime", tvStartTime.getText().toString());
        map.put("fillDate", tvEndTime.getText().toString());
        map.put("dayType", tvType.getText().toString());
        map.put("memo", etReason.getText().toString());
        map.put("mainId", mainId);
        map.put("taskId", taskId);
        map.put("signalName", signaName);
        map.put("destName", destName);
        if (tvLeader.getVisibility() == View.VISIBLE) {
            if (!tvLeader.getText().toString().equals("")) {
                map.put("bumenjingli", tvLeader.getText().toString());
            }
        } else {
            map.put("bumenjingli", etLeader.getText().toString());
            map.put("comments", etLeader.getText().toString());
        }
        if (tvLeader1.getVisibility() == View.VISIBLE) {
            if (!tvLeader1.getText().toString().equals("")) {
                map.put("fenguanjingli", tvLeader1.getText().toString());
            }
        } else {
            map.put("fenguanjingli", etLeader1.getText().toString());
            map.put("comments", etLeader1.getText().toString());
        }
    }

    @Override
    public void setOldWorkWill(OldWorkWill s) {
        if (s != null) {
            tvPerson.setText(s.getMainform().get(0).getUserName().toString());
            tvStartTime.setText(s.getMainform().get(0).getCreateTime().toString());
            if (s.getMainform().get(0).getFillDate() != null) {
                tvEndTime.setText(s.getMainform().get(0).getFillDate().toString());
            }
            if (s.getMainform().get(0).getDayType() != null) {
//                if (s.getMainform().get(0).getDayType().equals("1")){
                tvType.setText(s.getMainform().get(0).getDayType());
//                }else if (s.getMainform().get(0).getDayType().equals("2")){
//                    tvType.setText("下午");
//                }else if (s.getMainform().get(0).getDayType().equals("2")){
//                    tvType.setText("全天");
//                }
            }
            if (s.getMainform().get(0).getMemo().toString() != null) {
                etReason.setText(s.getMainform().get(0).getMemo().toString());
            }
            mainId = String.valueOf(s.getMainform().get(0).getMainId());
            String dataUrl_save = s.getMainform().get(0).getDataUrl_save().toString();
            String[] strarray = dataUrl_save.split("[=]");
            vocationId = strarray[1];
            String leader = (String) s.getMainform().get(0).getBumenjingli();
            String leader1 = (String) s.getMainform().get(0).getFenguanjingli();
            String move = s.getFormRights();
            try {
                JSONObject jsonObject = new JSONObject(move);
                String kzMove = jsonObject.getString("bumenjingli");
                String fgMove = jsonObject.getString("fenguanjingli");
                if (kzMove.equals("2")) {
                    tvLeader.setVisibility(View.GONE);
                    etLeader.setVisibility(View.VISIBLE);
                    if (leader != null && leader.length() != 0) {
                        etLeader.setText(leader);
                    }
                } else {
                    tvLeader.setVisibility(View.VISIBLE);
                    etLeader.setVisibility(View.GONE);
                    if (leader != null && leader.length() != 0) {
                        tvLeader.setText(leader);
                    }
                }

                if (fgMove.equals("2")) {
                    tvLeader1.setVisibility(View.GONE);
                    etLeader1.setVisibility(View.VISIBLE);
                    if (leader1 != null && leader1.length() != 0) {
                        etLeader1.setText(leader1);
                    }
                } else {
                    tvLeader1.setVisibility(View.VISIBLE);
                    etLeader1.setVisibility(View.GONE);
                    if (leader1 != null && leader1.length() != 0) {
                        tvLeader1.setText(leader1);
                    }
                }

                for (int i = 0; i < s.getTrans().size(); i++) {
                    destTypeList.add(s.getTrans().get(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setOldWorkWillMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setNormalPerson(NormalPerson s) {
        if (s.getData() != null) {
            role = s.getData().get(0).getRole();
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
            role = s.getData().get(0).getRole();
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
        map.put("flowAssignId", role + "|" + uId);
        willDoPresenter.getWillDo(map);
    }

    @Override
    public void setNoHandlerPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWillDo(WillDoUp s) {
        checkTypePresenter.getCheckType(String.valueOf(s.getRunId()), vocationId);
    }

    @Override
    public void setWillDoMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCheckType(CheckType s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "设置成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setCheckTypeMessage(String s) {
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
                .setTitle("选择审核人")//标题栏
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
                map.put("flowAssignId", role + "|" + uId);
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
            for (int i = 0; i < selectList.size(); i++) {
                if (i == selectList.size() - 1) {
                    uId = uId + selectList.get(i);
                } else {
                    uId = uId + selectList.get(i) + ",";
                }
            }
        }
        return uId;
    }

}
