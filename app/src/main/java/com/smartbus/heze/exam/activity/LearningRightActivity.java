package com.smartbus.heze.exam.activity;

import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.R;
import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.exam.bean.LearnRight;
import com.smartbus.heze.exam.module.LearnRightContract;
import com.smartbus.heze.exam.presenter.LearnRightPresenter;
import com.smartbus.heze.fileapprove.bean.FileData;
import com.smartbus.heze.fileapprove.util.DBHandler;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.ProgressDialogUtil;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.smartbus.heze.http.base.Constant.TAG_NINE;
import static com.smartbus.heze.http.base.Constant.TAG_TWO;

public class LearningRightActivity extends BaseActivity implements LearnRightContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    String dataRes;
    private long downloadId = 0;
    LearnLeft.ResultBean leftBean;
    LearnRightPresenter learnRightPresenter;
    BaseRecyclerAdapter baseRecyclerAdapter;
    private DownloadCompleteReceiver receiver = null;
    private DownloadManager downloadManager = null;
    List<LearnRight.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        leftBean = (LearnLeft.ResultBean) intent.getSerializableExtra("bean");
        String type = leftBean.getNodeKey();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        learnRightPresenter = new LearnRightPresenter(this, this);
        learnRightPresenter.getLearnRight(type);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_learning;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setLearnRight(final LearnRight s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        baseRecyclerAdapter = new BaseRecyclerAdapter<LearnRight.ResultBean>(this, R.layout.adapter_easy_item, beanList) {
            @Override
            public void convert(BaseViewHolder holder, LearnRight.ResultBean o) {
                holder.setText(R.id.textView, o.getFileName());
                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id = String.valueOf(s.getResult().get(0).getFileId());
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
                });
            }
        };
        recyclerView.setAdapter(baseRecyclerAdapter);
        baseRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setLearnRightMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case TAG_TWO:
                    Toast.makeText(LearningRightActivity.this, "操作数据失败", Toast.LENGTH_SHORT).show();
                    ProgressDialogUtil.stopLoad();
                    break;
                case TAG_NINE:
                    Gson gson2 = new Gson();
                    FileData file = gson2.fromJson(dataRes, FileData.class);
                    String filePath = file.getData().getFilePath();
                    String url = ApiAddress.downloadfile+filePath;
                    ProgressDialogUtil.startLoad(LearningRightActivity.this,"文件下载中");
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
                    request.setDestinationInExternalFilesDir(LearningRightActivity.this,
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
                    startActivity(intent2);
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
