package com.smartbus.heze.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.smartbus.heze.R;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.utils.GlideImageLoader;
import com.smartbus.heze.http.views.ScrollForeverTextView;
import com.smartbus.heze.main.notice.activity.NoticeDetailActivity;
import com.smartbus.heze.main.notice.activity.NoticeListActivity;
import com.smartbus.heze.welcome.bean.Notice;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 * 换乘查询
 */

public class Fragment01 extends Fragment {
    View view;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.tvSeeItNow)
    ScrollForeverTextView tvSeeItNow;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rb5)
    RadioButton rb5;
    @BindView(R.id.rb6)
    RadioButton rb6;
    @BindView(R.id.rb7)
    RadioButton rb7;
    @BindView(R.id.rb8)
    RadioButton rb8;
    @BindView(R.id.rb9)
    RadioButton rb9;
    @BindView(R.id.rb10)
    RadioButton rb10;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;

    int num = 0;
    Intent intent;
    BaseRecyclerAdapter mAdapter;
    List<Integer> imageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment01, container, false);
        unbinder = ButterKnife.bind(this, view);
        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);
        setBanner();
        EventBus.getDefault().register(this);
        return view;
    }

    private void setBanner() {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageList);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置轮播时间
        banner.setDelayTime(6000);
//        //标题
//        banner.setBannerTitles(imageList);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 接收welcomeActivity传来的notice数据
     * @param beanList
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveMessage(List<Notice.ResultBean> beanList){
        String s = "";
        for (int i = 0;i<beanList.size();i++){
            s = s+beanList.get(i).getSubject()+ "\n" + "\n" + "\n";
        }
        tvSeeItNow.setText(s);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        if (beanList.size()>2){
            List<Notice.ResultBean> beanList1 = new ArrayList<>();
            beanList1.add(beanList.get(0));
            beanList1.add(beanList.get(1));
            beanList.clear();
            beanList = beanList1;
        }
        mAdapter = new BaseRecyclerAdapter<Notice.ResultBean>(getActivity(), R.layout.notice_item_layout, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final Notice.ResultBean noticeBean) {
                num+=1;
                if (num<=2){
                    holder.setText(R.id.tv_title,"\t" +noticeBean.getSubject());
                    holder.setText1(R.id.tv_content, noticeBean.getContent());
                    holder.setOnClickListener(R.id.noticeItem, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intent = new Intent(getActivity(), NoticeDetailActivity.class);
                            intent.putExtra("bean",noticeBean);
                            startActivity(intent);
                        }
                    });
                }
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4,R.id.rb5, R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9
            , R.id.rb10,R.id.tvSeeItNow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvSeeItNow:
                intent = new Intent(getActivity(), NoticeListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb1:
                intent = new Intent(getActivity(), NoticeListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                break;
            case R.id.rb3:
                break;
            case R.id.rb4:
                break;
            case R.id.rb5:
                break;
            case R.id.rb6:
                break;
            case R.id.rb7:
                break;
            case R.id.rb8:
                break;
            case R.id.rb9:
                break;
            case R.id.rb10:
                break;
        }
    }
}
