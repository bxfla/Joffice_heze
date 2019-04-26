package com.smartbus.heze.main.notice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.welcome.bean.Notice;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticeDetailActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.tvContent)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Notice.ResultBean bean = (Notice.ResultBean) intent.getSerializableExtra("bean");
        tvTitle.setText(bean.getSubject());
        tvContent.setText(bean.getContent());
        tvTime.setText(bean.getCreatetime());
        tvDepartment.setText(bean.getAuthor());

    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_notice_detail;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }
}
