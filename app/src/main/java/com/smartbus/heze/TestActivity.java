package com.smartbus.heze;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.DownloadManager.Request;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class TestActivity extends AppCompatActivity {
    private DownloadManager downloadManager = null;
    private String urlString = "http://img2.duitang.com/uploads/item/201207/19/20120719132725_UkzCN.jpeg";
    private long downloadId = 0;
    private DownloadCompleteReceiver receiver = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        // 动态注册广播接收器
        receiver = new DownloadCompleteReceiver();
        IntentFilter intentFilter = new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        registerReceiver(receiver, intentFilter);

        Request request = new Request(Uri.parse(urlString));
        request.setTitle("下载文件");
        // 保存的文件名
        request.setDescription("song_abc.mp4");
        // 存储的位置
        request.setDestinationInExternalFilesDir(this,
                Environment.DIRECTORY_DOWNLOADS, "song_abc.mp4");
        // 默认显示出来
        request.setNotificationVisibility(Request.VISIBILITY_VISIBLE);
        // 下载结束后显示出来
        request.setNotificationVisibility(Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        downloadId = downloadManager.enqueue(request);
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
        unregisterReceiver(receiver);
    }
}
