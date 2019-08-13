package com.smartbus.heze.main.notice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smartbus.heze.ApiAddress;
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
    @BindView(R.id.imageView)
    ImageView imageView;

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
        String subjectIcon = bean.getSubjectIcon();
        if (subjectIcon.equals("")){
            imageView.setVisibility(View.GONE);
        }else {
            Glide.with(this)
                    .load(ApiAddress.downloadfile+subjectIcon)
                    .placeholder(R.drawable.loading)
                    .into(imageView);
        }
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
