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
import com.smartbus.heze.fileapprove.bean.DocumentLZWill;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.DocumentLZWillContract;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.DocumentLZWillPresenter;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_ONE;

/**
 * 公文流转
 */
public class DocumentLZWillActivity extends BaseActivity implements DocumentLZWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View {
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
    @BindView(R.id.etLeader2)
    EditText etLeader2;
    @BindView(R.id.tvLeader2)
    TextView tvLeader2;
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
    @BindView(R.id.btnUp)
    Button btnUp;

    String mainId = "";
    String dataRes;
    String destType = "";
    String leaderCode = "";
    String leaderName = "";
    String destName, uId, signaName;
    String activityName, taskId;
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    NormalPresenter normalPresenter;
    NoEndPresenter noEndPersenter;
    NoHandlerPresenter noHandlerPresenter;
    WillDoPresenter willDoPresenter;
    DocumentLZWillPresenter documentLZWillPresenter;
    List<String> selectList = new ArrayList<>();
    List<String> selectList1 = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    List<String> typelist = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    List<DocumentLZWill.TransBean> destTypeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        btnPerson.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        normalPresenter = new NormalPresenter(this, this);
        noEndPersenter = new NoEndPresenter(this, this);
        noHandlerPresenter = new NoHandlerPresenter(this, this);
        willDoPresenter = new WillDoPresenter(this, this);
        Log.e("sessionLogin ", taskId + "-" + activityName);
        documentLZWillPresenter = new DocumentLZWillPresenter(this, this);
        documentLZWillPresenter.getDocumentLZWill(activityName, taskId, Constant.BORROWACCIDENT_DEFID);
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

    }

    @OnClick({R.id.btnPerson, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnPerson:
                Intent intent = new Intent(DocumentLZWillActivity.this, WorkPersonActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.btnUp:
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
                                destName = destTypeList.get(0).getDestination();
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
                                        destName = destTypeList.get(i).getDestination();
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
                    if (selectList1.size()==0){
                        Toast.makeText(this, "请选择传阅人", Toast.LENGTH_SHORT).show();
                    }else {
                        setData();
                        getListData();
                        map.put("flowAssignId", destName + "|" + uId);
                        willDoPresenter.getWillDo(map);
                    }
                }
                break;
        }
    }

    private void setData() {
        map.put("defId", Constant.DOCUMENTLZ_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.DOCUMENTLZ_FORMDEFIS);
        map.put("shouwenRq", tvTime.getText().toString());
        map.put("fawenjig", tvDepartment.getText().toString());
        map.put("wenjianNo", etBianHao.getText().toString());
        map.put("fawennum", etNum.getText().toString());
        map.put("mainId", mainId);
        map.put("taskId", taskId);
        map.put("signalName", signaName);
        map.put("destName", destName);
        if (tvLeader.getVisibility() == View.VISIBLE) {
            if (!tvLeader.getText().toString().equals("")){
                map.put("nibanyj", new SplitData().SplitUpData(tvLeader.getText().toString()));
            }
        } else {
            map.put("nibanyj", new SplitData().SplitUpData(etLeader.getText().toString()));
            map.put("comments", etLeader.getText().toString());
        }
        if (tvLeader1.getVisibility() == View.VISIBLE) {
            if (!tvLeader1.getText().toString().equals("")){
                map.put("ldyj", new SplitData().SplitUpData(tvLeader1.getText().toString()));
            }
        } else {
            map.put("ldyj", new SplitData().SplitUpData(etLeader1.getText().toString()));
            map.put("comments", etLeader1.getText().toString());
        }
        if (tvLeader2.getVisibility() == View.VISIBLE) {
            if (!tvLeader2.getText().toString().equals("")){
                map.put("chengbanjg",tvLeader2.getText().toString());
            }
        } else {
            map.put("chengbanjg", etLeader2.getText().toString());
            map.put("comments", etLeader2.getText().toString());
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

        if (selectList1.size() == 1) {
            //uName = backlist.get(0).getActivityName();
            if (selectList.size()==0){
                uId = uId + selectList1.get(0);
            }else {
                uId = uId +","+ selectList1.get(0);
            }
        }
        if (selectList1.size() > 1) {
            for (int i = 0; i < selectList1.size(); i++) {
                if (i < selectList1.size()-1) {
                    if (uId==null||uId.equals("")){
                        uId = selectList1.get(i);
                    }else {
                        uId = uId + ","+ selectList1.get(i);
                    }
                } else {
                    if (uId==null||uId.equals("")){
                        uId = uId + ","+ selectList1.get(i);
                    }else {
                        uId = uId + ","+ selectList1.get(i);
                    }
                }
            }
        }
        return uId;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAG_ONE:
                if (resultCode == TAG_ONE) {
                    if (data != null) {
                        selectList1 = data.getStringArrayListExtra("bean");
                    }
                }
                break;
        }
    }

    @Override
    public void setDocumentLZWill(DocumentLZWill s) {
        if (s != null) {
            tvTime.setText(s.getMainform().get(0).getShouwenRq().toString());
            tvDepartment.setText(s.getMainform().get(0).getFawenjig().toString());
            etBianHao.setText(s.getMainform().get(0).getWenjianNo().toString());
            etNum.setText(s.getMainform().get(0).getFawennum().toString());
            etTitle.setText(s.getMainform().get(0).getTitle().toString());
            mainId = String.valueOf(s.getMainform().get(0).getMainId());
            String leader = s.getMainform().get(0).getNibanyj();
            String leader1 = s.getMainform().get(0).getLdyj();
            String leader2 = s.getMainform().get(0).getChengbanjg();
            String move = s.getFormRights();
            try {
                JSONObject jsonObject = new JSONObject(move);
                String nbMove = jsonObject.getString("nibanyj");
                String ldMove = jsonObject.getString("ldyj");
                String jgMove = jsonObject.getString("chengbanjg");
                if (nbMove.equals("2")) {
                    tvLeader.setVisibility(View.GONE);
                    etLeader.setVisibility(View.VISIBLE);
                    if (leader != null && leader.length() != 0) {
                        etLeader.setText(new SplitData().getStringData(leader));
                    }
                } else {
                    tvLeader.setVisibility(View.VISIBLE);
                    etLeader.setVisibility(View.GONE);
                    if (leader != null && leader.length() != 0) {
                        tvLeader.setText(new SplitData().getStringData(leader));
                    }
                }

                if (ldMove.equals("2")) {
                    tvLeader1.setVisibility(View.GONE);
                    etLeader1.setVisibility(View.VISIBLE);
                    if (leader1 != null && leader1.length() != 0) {
                        etLeader1.setText(new SplitData().getStringData(leader1));
                    }
                } else {
                    tvLeader1.setVisibility(View.VISIBLE);
                    etLeader1.setVisibility(View.GONE);
                    if (leader1 != null && leader1.length() != 0) {
                        tvLeader1.setText(new SplitData().getStringData(leader1));
                    }
                }

                if (jgMove.equals("2")) {
                    tvLeader2.setVisibility(View.GONE);
                    etLeader2.setVisibility(View.VISIBLE);
                    if (leader2 != null && leader2.length() != 0) {
                        etLeader2.setText(leader2);
                    }
                } else {
                    tvLeader2.setVisibility(View.VISIBLE);
                    etLeader2.setVisibility(View.GONE);
                    if (leader2 != null && leader2.length() != 0) {
                        tvLeader2.setText(leader2);
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
    public void setDocumentLZWillMessage(String s) {
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
        getListData();
//        map.put("flowAssignId", null);
        willDoPresenter.getWillDo(map);
    }

    @Override
    public void setNoHandlerPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWillDo(WillDoUp s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "数据提交成功", Toast.LENGTH_SHORT).show();
            finish();
        }
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

}
