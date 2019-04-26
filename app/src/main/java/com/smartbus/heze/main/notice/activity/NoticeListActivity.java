package com.smartbus.heze.main.notice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.welcome.bean.Notice;
import com.smartbus.heze.welcome.module.WelcomeContract;
import com.smartbus.heze.welcome.presenter.WelcomePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoticeListActivity extends BaseActivity implements WelcomeContract.View {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Intent intent;
    BaseRecyclerAdapter mAdapter;
    private WelcomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        presenter = new WelcomePresenter(this, this);
        presenter.getNoticeList();
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_notice_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @Override
    public void setNoticeList(Notice bean) {
        List<Notice.ResultBean> beanList = new ArrayList<>();
        for (int i = 0; i < bean.getResult().size(); i++) {
            beanList.add(bean.getResult().get(i));
        }
        LinearLayoutManager manager = new LinearLayoutManager(NoticeListActivity.this);
        recyclerView.setLayoutManager(manager);
        mAdapter = new BaseRecyclerAdapter<Notice.ResultBean>(NoticeListActivity.this, R.layout.notice_item_layout, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final Notice.ResultBean noticeBean) {
                holder.setText(R.id.tv_title,"\t" +noticeBean.getSubject());
                holder.setText1(R.id.tv_content, noticeBean.getContent());
                holder.setOnClickListener(R.id.noticeItem, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent = new Intent(NoticeListActivity.this, NoticeDetailActivity.class);
                        intent.putExtra("bean",noticeBean);
                        startActivity(intent);
                    }
                });
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setNoticeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
