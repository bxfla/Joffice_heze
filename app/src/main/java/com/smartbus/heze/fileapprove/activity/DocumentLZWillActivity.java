package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.DocumentLZWill;
import com.smartbus.heze.fileapprove.bean.FileData;
import com.smartbus.heze.fileapprove.bean.LZLR;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.DocumentLRContract;
import com.smartbus.heze.fileapprove.module.DocumentLZWillContract;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.DocumentLRPresenter;
import com.smartbus.heze.fileapprove.presenter.DocumentLZWillPresenter;
import com.smartbus.heze.fileapprove.presenter.NoEndPresenter;
import com.smartbus.heze.fileapprove.presenter.NoHandlerPresenter;
import com.smartbus.heze.fileapprove.presenter.NormalPresenter;
import com.smartbus.heze.fileapprove.presenter.WillDoPresenter;
import com.smartbus.heze.fileapprove.util.DBHandler;
import com.smartbus.heze.fileapprove.util.MyStringSpilt;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;
import com.smartbus.heze.oaflow.bean.CheckType;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.smartbus.heze.http.base.Constant.TAG_NINE;
import static com.smartbus.heze.http.base.Constant.TAG_ONE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

/**
 * 公文流转
 */
public class DocumentLZWillActivity extends BaseActivity implements DocumentLZWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View
        , DocumentLRContract.View {
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
    @BindView(R.id.llcb)
    LinearLayout llcb;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.btnLR)
    Button btnLR;

    String mainId = "";
    String dataRes;
    String destType = "";
    String leaderCode = "";
    String leaderName = "";
    String vocationId = "";
    String nibanyj = "", ldyi = "", chengbanyj = "", comments = "";
    private long downloadId = 0;
    String destName, uId, signaName;
    String activityName, taskId;
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    NormalPresenter normalPresenter;
    NoEndPresenter noEndPersenter;
    NoHandlerPresenter noHandlerPresenter;
    WillDoPresenter willDoPresenter;
    DocumentLRPresenter documentLRPresenter;
    DocumentLZWillPresenter documentLZWillPresenter;
    List<String> selectList = new ArrayList<>();
    List<String> selectList1 = new ArrayList<>();
    List<String> selectNList1 = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    List<String> typelist = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    private DownloadManager downloadManager = null;
    private DownloadCompleteReceiver receiver = null;
    List<DocumentLZWill.TransBean> destTypeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        llcb.setVisibility(View.GONE);
        btnPerson.setVisibility(View.VISIBLE);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        normalPresenter = new NormalPresenter(this, this);
        noEndPersenter = new NoEndPresenter(this, this);
        noHandlerPresenter = new NoHandlerPresenter(this, this);
        willDoPresenter = new WillDoPresenter(this, this);
        Log.e("sessionLogin ", taskId + "-" + activityName);
        documentLRPresenter = new DocumentLRPresenter(this, this);
        documentLZWillPresenter = new DocumentLZWillPresenter(this, this);
        documentLZWillPresenter.getDocumentLZWill(activityName, taskId, Constant.DOCUMENTLZ_DEFID);
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

    @OnClick({R.id.btnPerson, R.id.btnUp, R.id.tvData})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvData:
                List<String> dataList = new ArrayList<>();
                if (!tvData.getText().toString().equals("")) {
                    dataList = new MyStringSpilt().stringSpiltList(tvData.getText().toString());
                    if (dataList.size() == 1) {
                        String id = new MyStringSpilt().stringSpilt(dataList.get(0));
                        final String url = ApiAddress.mainApi + ApiAddress.filedata + "?fileId=" + id;
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                DBHandler dbA = new DBHandler();
                                dataRes = dbA.OAQingJiaMyDetail(url);
                                if (dataRes.equals("获取数据失败") || dataRes.equals("")) {
                                    handler.sendEmptyMessage(TAG_TWO);
                                } else {
                                    handler.sendEmptyMessage(TAG_NINE);
                                }
                            }
                        }).start();
                    } else if (dataList.size() > 1) {
                        MyAlertDialog.MyListAlertDialog(this, dataList, new AlertDialogCallBackP() {
                            @Override
                            public void oneselect(final String data1) {
                                String id = new MyStringSpilt().stringSpilt(data1);
                                final String url = ApiAddress.mainApi + ApiAddress.filedata + "?fileId=" + id;
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        DBHandler dbA = new DBHandler();
                                        dataRes = dbA.OAQingJiaMyDetail(url);
                                        if (dataRes.equals("获取数据失败") || dataRes.equals("")) {
                                            handler.sendEmptyMessage(TAG_TWO);
                                        } else {
                                            handler.sendEmptyMessage(TAG_NINE);
                                        }
                                    }
                                }).start();
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
                }
                break;
            case R.id.btnPerson:
                Intent intent = new Intent(DocumentLZWillActivity.this, WorkPersonActivity.class);
                startActivityForResult(intent, TAG_ONE);
                break;
            case R.id.btnUp:
                if (destTypeList.size() != 0) {
                    if (destTypeList.size() == 1) {
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
                    if (selectList1.size() == 0) {
                        Toast.makeText(this, "请选择传阅人", Toast.LENGTH_SHORT).show();
                    } else {
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
        map.put("fujian", tvData.getText().toString());
        if (tvLeader.getVisibility() == View.VISIBLE) {
            if (!tvLeader.getText().toString().equals("")) {
                map.put("nibanyj", tvLeader.getText().toString());
            }
        } else {
            map.put("nibanyj", etLeader.getText().toString());
            map.put("comments", etLeader.getText().toString());
        }
        if (tvLeader1.getVisibility() == View.VISIBLE) {
            if (!tvLeader1.getText().toString().equals("")) {
                map.put("ldyj", tvLeader1.getText().toString());
            }
        } else {
            map.put("ldyj", etLeader1.getText().toString());
            map.put("comments", etLeader1.getText().toString());
        }
        if (tvLeader2.getVisibility() == View.VISIBLE) {
            if (!tvLeader2.getText().toString().equals("")) {
                map.put("chengbanjg", tvLeader2.getText().toString());
            }
        } else {
            map.put("chengbanjg", etLeader2.getText().toString());
            map.put("comments", etLeader2.getText().toString());
        }
    }

    private String getListData() {
        if (selectList.size() == 0) {
            if (selectList1.size() == 1) {
                uId = selectList1.get(0);
            }
            if (selectList1.size() > 1) {
                for (int i = 1; i < selectList.size(); i++) {
                    if (i == 1) {
                        uId = selectList.get(i);
                    }
                    if (i < selectList.size() - 1 && i != 1) {
                        uId = uId + "," + selectList.get(i) + ",";
                    } else {
                        uId = uId + "," + selectList.get(i);
                    }
                }
            }
        }
        if (selectList.size() == 1) {
            uId = selectList.get(0);
            if (selectList1.size() == 1) {
                uId = uId + "," + selectList1.get(0);
            }
            if (selectList1.size() > 1) {
                for (int i = 1; i < selectList.size(); i++) {
                    if (i == 1) {
                        uId = uId + "," + selectList.get(i);
                    }
                    if (i < selectList.size() - 1 && i != 1) {
                        uId = uId + "," + selectList.get(i) + ",";
                    } else {
                        uId = uId + "," + selectList.get(i);
                    }
                }
            }
        }
        if (selectList.size() > 1) {
            for (int i = 1; i < selectList.size(); i++) {
                if (i == 1) {
                    uId = selectList.get(i);
                }
                if (i < selectList.size() - 1 && i != 1) {
                    uId = uId + "," + selectList.get(i) + ",";
                } else {
                    uId = uId + "," + selectList.get(i);
                }
            }
            if (selectList1.size() > 1) {
                for (int i = 1; i < selectList.size(); i++) {
                    if (i == 1) {
                        uId = uId + "," + selectList.get(i);
                    }
                    if (i < selectList.size() - 1 && i != 1) {
                        uId = uId + "," + selectList.get(i) + ",";
                    } else {
                        uId = uId + "," + selectList.get(i);
                    }
                }
            }
//            uId = selectList.get(0) + "," + uId;
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
                        selectNList1 = data.getStringArrayListExtra("bean1");
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
            tvData.setText(s.getMainform().get(0).getFujian().toString());
            mainId = String.valueOf(s.getMainform().get(0).getMainId());
            String dataUrl_save = s.getMainform().get(0).getDataUrl_save().toString();
            String[] strarray = dataUrl_save.split("[=]");
            vocationId = strarray[1];
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
                        etLeader.setText(leader);
                    }
                } else {
                    tvLeader.setVisibility(View.VISIBLE);
                    etLeader.setVisibility(View.GONE);
                    if (leader != null && leader.length() != 0) {
                        tvLeader.setText(leader);
                    }
                }

                if (ldMove.equals("2")) {
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
        map.put("flowAssignId", destName + "|" + uId);
        willDoPresenter.getWillDo(map);
    }

    @Override
    public void setNoHandlerPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setWillDo(WillDoUp s) {
        if (s.isSuccess()) {
            map.put("destName", destName);
            map.put("fujian", tvData.getText().toString());
            if (tvLeader.getVisibility() == View.VISIBLE) {
                if (!tvLeader.getText().toString().equals("")) {
                    nibanyj = tvLeader.getText().toString();
                    map.put("nibanyj", tvLeader.getText().toString());
                }
            } else {
                nibanyj = etLeader.getText().toString();
                if (!etLeader.getText().toString().equals("")) {
                    comments = etLeader.getText().toString();
                }
                map.put("nibanyj", etLeader.getText().toString());
                map.put("comments", etLeader.getText().toString());
            }
            if (tvLeader1.getVisibility() == View.VISIBLE) {
                if (!tvLeader1.getText().toString().equals("")) {
                    ldyi = tvLeader1.getText().toString();
                    map.put("ldyj", tvLeader1.getText().toString());
                }
            } else {
                ldyi = tvLeader1.getText().toString();
                if (!etLeader.getText().toString().equals("")) {
                    comments = etLeader1.getText().toString();
                }
                map.put("ldyj", etLeader1.getText().toString());
                map.put("comments", etLeader1.getText().toString());
            }
            if (tvLeader2.getVisibility() == View.VISIBLE) {
                if (!tvLeader2.getText().toString().equals("")) {
                    chengbanyj = tvLeader2.getText().toString();
                    map.put("chengbanjg", tvLeader2.getText().toString());
                }
            } else {
                chengbanyj = etLeader2.getText().toString();
                if (!etLeader.getText().toString().equals("")) {
                    comments = etLeader2.getText().toString();
                }
                map.put("chengbanjg", etLeader2.getText().toString());
                map.put("comments", etLeader2.getText().toString());
            }
            documentLRPresenter.getCheckTypeLR(String.valueOf(s.getRunId()), vocationId, destName
                    , comments, nibanyj, ldyi, chengbanyj);
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
        String s = "";
        for (int i = 0; i < selectNList1.size(); i++) {
            if (i == 0) {
                s = selectNList1.get(i);
            } else {
                s = s + "," + selectNList1.get(i);
            }
        }
        new AlertDialog.Builder(this)
                .setTitle("已选:" + s)//标题栏
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

    @Override
    public void setDocumentLR(LZLR s) {

    }

    @Override
    public void setDocumentLRMessage(String s) {

    }

    @Override
    public void setCheckTypeLR(CheckType s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "发布成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setCheckTypeLRMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    // 自定义广播内部类
    class DownloadCompleteReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获得广播的频道来进行判断是否下载完毕
            if (intent.getAction().equals(
                    DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
                long loadId = intent.getLongExtra(
                        DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                if (loadId == downloadId) {
                    ProgressDialogUtil.stopLoad();
                    // 内容根据需求来写（如：下载完成后跳转到下载的记录）
                    Intent intent2 = new Intent();
                    // 跳转到下载记录的界面
                    intent2.setAction(DownloadManager.ACTION_VIEW_DOWNLOADS);
                    startActivityForResult(intent2, Constant.TAG_ONE);
                }
            }
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(DocumentLZWillActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    FileData file = gson2.fromJson(dataRes, FileData.class);
                    String filePath = file.getData().getFilePath();
                    String url = ApiAddress.downloadfile + filePath;
                    ProgressDialogUtil.startLoad(DocumentLZWillActivity.this, "文件下载中");
                    downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

                    // 动态注册广播接收器
                    receiver = new DownloadCompleteReceiver();
                    IntentFilter intentFilter = new IntentFilter(
                            DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                    registerReceiver(receiver, intentFilter);

                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                    request.setTitle("下载文件");
                    // 保存的文件名
                    request.setDescription(filePath);
                    // 存储的位置
                    request.setDestinationInExternalFilesDir(DocumentLZWillActivity.this,
                            Environment.DIRECTORY_DOWNLOADS, filePath);
                    // 默认显示出来
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
                    // 下载结束后显示出来
                    request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    downloadId = downloadManager.enqueue(request);
                    break;
            }
        }
    };

}
