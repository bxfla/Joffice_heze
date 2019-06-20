package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
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
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.FileCirculateWill;
import com.smartbus.heze.fileapprove.bean.FileData;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.FileCirculateWillContract;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.FileCirculateWillPresenter;
import com.smartbus.heze.fileapprove.presenter.NoEndPresenter;
import com.smartbus.heze.fileapprove.presenter.NoHandlerPresenter;
import com.smartbus.heze.fileapprove.presenter.NormalPresenter;
import com.smartbus.heze.fileapprove.presenter.WillDoPresenter;
import com.smartbus.heze.fileapprove.util.DBHandler;
import com.smartbus.heze.fileapprove.util.SplitData;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

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
 * 文件传阅待办详情
 */
public class FileCirculateWillActivity extends BaseActivity implements FileCirculateWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.btnPerson)
    Button btnPerson;

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
    FileCirculateWillPresenter fileCirculateWillPresenter;
    List<String> selectList = new ArrayList<>();
    List<String> selectList1 = new ArrayList<>();
    List<String> selectNList1 = new ArrayList<>();
    List<String> namelist = new ArrayList<>();
    List<String> typelist = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    List<FileCirculateWill.TransBean> destTypeList = new ArrayList<>();

    private DownloadManager downloadManager = null;
    private long downloadId = 0;
    private DownloadCompleteReceiver receiver = null;

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
        fileCirculateWillPresenter = new FileCirculateWillPresenter(this, this);
        fileCirculateWillPresenter.getFileCirculateWill(activityName, taskId, Constant.HUIQIAN_DEFID);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_file_circulate;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private void setData() {
        map.put("defId", Constant.FILECIR_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.FILECIR_FORMDEFIS);
        map.put("lrrq", tvTime.getText().toString());
        map.put("mainId", mainId);
        map.put("taskId", taskId);
        map.put("fileId", tvData.getText().toString());
        map.put("signalName", signaName);
        map.put("destName", destName);
    }

    @OnClick({R.id.tvData, R.id.btnPerson, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvData:
                List<String> dataList = new ArrayList<>();
                if (!tvData.getText().toString().equals("")) {
                    dataList = new SplitData().stringSpiltList(tvData.getText().toString());
                    if (dataList.size() == 1) {
                        String id = new SplitData().stringSpilt(dataList.get(0));
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
                                String id = new SplitData().stringSpilt(data1);
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
                Intent intent = new Intent(FileCirculateWillActivity.this, WorkPersonActivity.class);
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
//                        map.put("flowAssignId", destName + "|" + uId);
                        willDoPresenter.getWillDo(map);
                    }
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
                        selectList1 = data.getStringArrayListExtra("bean");
                        selectNList1 = data.getStringArrayListExtra("bean1");
                    }
                }
                break;
        }
    }

    @Override
    public void setFileCirculateWill(FileCirculateWill s) {
        if (s != null) {
            tvTime.setText(s.getMainform().get(0).getLrrq().toString().split(" ")[0]);
            tvData.setText(s.getMainform().get(0).getFileId().toString());
            mainId = String.valueOf(s.getMainform().get(0).getMainId());
            for (int i = 0; i < s.getTrans().size(); i++) {
                destTypeList.add(s.getTrans().get(i));
            }
        }
    }

    @Override
    public void setFileCirculateWillMessage(String s) {
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
                .setTitle("已选:" + s)
//                .setMessage(s)
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
        if (selectList.size() == 0) {
            if (selectList1.size() == 1) {
                uId = selectList1.get(0);
            }
            if (selectList1.size() > 1) {
                for (int i = 1; i < selectList.size(); i++) {
                    if (i==1){
                        uId = selectList.get(i);
                    }
                    if (i < selectList.size() - 1&&i!=1) {
                        uId = uId +","+ selectList.get(i) + ",";
                    } else {
                        uId = uId +","+ selectList.get(i);
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
                    if (i==1){
                        uId = uId + "," +selectList.get(i);
                    }
                    if (i < selectList.size() - 1&&i!=1) {
                        uId = uId +","+ selectList.get(i) + ",";
                    } else {
                        uId = uId +","+ selectList.get(i);
                    }
                }
            }
        }
        if (selectList.size() > 1) {
            for (int i = 1; i < selectList.size(); i++) {
                if (i==1){
                    uId = selectList.get(i);
                }
                if (i < selectList.size() - 1&&i!=1) {
                    uId = uId +","+ selectList.get(i) + ",";
                } else {
                    uId = uId +","+ selectList.get(i);
                }
            }
            if (selectList1.size() > 1) {
                for (int i = 1; i < selectList.size(); i++) {
                    if (i==1){
                        uId = uId + "," +selectList.get(i);
                    }
                    if (i < selectList.size() - 1&&i!=1) {
                        uId = uId +","+ selectList.get(i) + ",";
                    } else {
                        uId = uId +","+ selectList.get(i);
                    }
                }
            }
//            uId = selectList.get(0) + "," + uId;
        }

//        if (selectList1.size() == 1) {
//            //uName = backlist.get(0).getActivityName();
//            if (selectList.size() == 0) {
//                uId = uId + selectList1.get(0);
//            } else {
//                uId = uId + "," + selectList1.get(0);
//            }
//        }
//        if (selectList1.size() > 1) {
//            for (int i = 0; i < selectList1.size(); i++) {
//                if (i < selectList1.size() - 1) {
//                    if (uId == null || uId.equals("")) {
//                        uId = selectList1.get(i);
//                    } else {
//                        uId = uId + "," + selectList1.get(i);
//                    }
//                } else {
//                    if (uId == null || uId.equals("")) {
//                        uId = uId + "," + selectList1.get(i);
//                    } else {
//                        uId = uId + "," + selectList1.get(i);
//                    }
//                }
//            }
//        }
        return uId;
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(FileCirculateWillActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    FileData file = gson2.fromJson(dataRes, FileData.class);
                    String filePath = file.getData().getFilePath();
                    String url = ApiAddress.downloadfile + filePath;
                    ProgressDialogUtil.startLoad(FileCirculateWillActivity.this, "文件下载中");
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
                    request.setDestinationInExternalFilesDir(FileCirculateWillActivity.this,
                            Environment.DIRECTORY_DOWNLOADS, filePath);
                    // 默认显示出来
                    request.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
                    // 下载结束后显示出来
                    request.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                    downloadId = downloadManager.enqueue(request);
                    break;
            }
        }
    };

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //下载完之后就解绑了
//        unregisterReceiver(receiver);
    }
}