package com.smartbus.heze.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.SharedPreferencesHelper;
import com.smartbus.heze.checkup.activity.CarCheckActivity;
import com.smartbus.heze.checkup.activity.HealthActivity;
import com.smartbus.heze.checkup.activity.RCJCActivity;
import com.smartbus.heze.checkup.activity.SafeActivity;
import com.smartbus.heze.exam.ExamListActivity;
import com.smartbus.heze.fault.FaultUpActivity;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.utils.GlideImageLoader;
import com.smartbus.heze.http.views.ScrollForeverTextView;
import com.smartbus.heze.main.activity.ProcessActivity;
import com.smartbus.heze.main.bean.ItemBean;
import com.smartbus.heze.main.notice.activity.NoticeDetailActivity;
import com.smartbus.heze.main.notice.activity.NoticeListActivity;
import com.smartbus.heze.main.view.MaxHeightRecyclerView;
import com.smartbus.heze.oasheet.OAPublishActivity;
import com.smartbus.heze.other.OtherListActivity;
import com.smartbus.heze.welcome.bean.Notice;
import com.smartbus.heze.welcome.module.WelcomeContract;
import com.smartbus.heze.welcome.presenter.WelcomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 */

public class Fragment01 extends Fragment implements WelcomeContract.View {
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
    @BindView(R.id.ll)
    SwipeRefreshLayout ll;
    @BindView(R.id.maxRecyclerView)
    MaxHeightRecyclerView maxRecyclerView;
    Unbinder unbinder;

    int num = 0;
    Intent intent;
    BaseRecyclerAdapter mAdapter;
    BaseRecyclerAdapter mAdapter1;
    private WelcomePresenter presenter;
    List<Integer> imageList = new ArrayList<>();
    List<ItemBean> itemList = new ArrayList<>();
    List<Notice.ResultBean> beanList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment01, container, false);
        unbinder = ButterKnife.bind(this, view);
        //添加模块
        addItem();
        setItemAdapter();


        imageList.add(R.drawable.banner1);
        imageList.add(R.drawable.banner2);
        imageList.add(R.drawable.banner3);
        setBanner();
        presenter = new WelcomePresenter(getActivity(), this);
        presenter.getNoticeList();
        ll.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getNoticeList();
            }
        });
        return view;
    }

    private void setItemAdapter() {
        GridLayoutManager manager = new GridLayoutManager (getActivity(),5);
        maxRecyclerView.setLayoutManager(manager);
        mAdapter1 = new BaseRecyclerAdapter<ItemBean>(getActivity(), R.layout.adapter_itembean, itemList) {
            @Override
            public void convert(BaseViewHolder holder, final ItemBean itemBean) {
                holder.setText(R.id.textView, itemBean.getName());
                holder.setImageResource(R.id.imageView, itemBean.getAddress());
                holder.setOnClickListener(R.id.linearLayout, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (itemBean.getName().equals(getResources().getString(R.string.first_notice))){
                            intent = new Intent(getActivity(), NoticeListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_process))){
                            intent = new Intent(getActivity(), ProcessActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_oa))){
                            intent = new Intent(getActivity(), OAPublishActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_xunjian))){
                            intent = new Intent(getActivity(), CarCheckActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_anquan))){
                            intent = new Intent(getActivity(), SafeActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_richang))){
                            intent = new Intent(getActivity(), RCJCActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_dianjian))){
                            intent = new Intent(getActivity(), HealthActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_shigu))){
                            intent = new Intent(getActivity(), FaultUpActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_yuangong))){
                            intent = new Intent(getActivity(), ExamListActivity.class);
                            startActivity(intent);
                        }else if (itemBean.getName().equals(getResources().getString(R.string.first_qita))){
                            intent = new Intent(getActivity(), OtherListActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }
        };
        maxRecyclerView.setAdapter(mAdapter1);
        mAdapter1.notifyDataSetChanged();
    }

    private void addItem() {
        String positionStatus = new SharedPreferencesHelper(getActivity(),"login").getData(getActivity(),"positionStatus","");
        if (positionStatus.equals("1")){
            ItemBean bean1 = new ItemBean();
            int drawableId1 = getResources().getIdentifier("rb1", "drawable", getActivity().getPackageName());
            bean1.setAddress(drawableId1);
            bean1.setName(getResources().getString(R.string.first_notice));
            itemList.add(bean1);

            ItemBean bean9 = new ItemBean();
            int drawableId9 = getResources().getIdentifier("rb9", "drawable", getActivity().getPackageName());
            bean9.setAddress(drawableId9);
            bean9.setName(getResources().getString(R.string.first_yuangong));
            itemList.add(bean9);

        }else {
            ItemBean bean1 = new ItemBean();
            int drawableId1 = getResources().getIdentifier("rb1", "drawable", getActivity().getPackageName());
            bean1.setAddress(drawableId1);
            bean1.setName(getResources().getString(R.string.first_notice));
            itemList.add(bean1);

            ItemBean bean2 = new ItemBean();
            int drawableId2 = getResources().getIdentifier("rb2", "drawable", getActivity().getPackageName());
            bean2.setAddress(drawableId2);
            bean2.setName(getResources().getString(R.string.first_process));
            itemList.add(bean2);

            ItemBean bean3 = new ItemBean();
            int drawableId3 = getResources().getIdentifier("rb3", "drawable", getActivity().getPackageName());
            bean3.setAddress(drawableId3);
            bean3.setName(getResources().getString(R.string.first_oa));
            itemList.add(bean3);

            ItemBean bean4 = new ItemBean();
            int drawableId4 = getResources().getIdentifier("rb4", "drawable", getActivity().getPackageName());
            bean4.setAddress(drawableId4);
            bean4.setName(getResources().getString(R.string.first_xunjian));
            itemList.add(bean4);

            ItemBean bean5 = new ItemBean();
            int drawableId5 = getResources().getIdentifier("rb5", "drawable", getActivity().getPackageName());
            bean5.setAddress(drawableId5);
            bean5.setName(getResources().getString(R.string.first_anquan));
            itemList.add(bean5);

            ItemBean bean6 = new ItemBean();
            int drawableId6 = getResources().getIdentifier("rb6", "drawable", getActivity().getPackageName());
            bean6.setAddress(drawableId6);
            bean6.setName(getResources().getString(R.string.first_richang));
            itemList.add(bean6);

            ItemBean bean7 = new ItemBean();
            int drawableId7 = getResources().getIdentifier("rb7", "drawable", getActivity().getPackageName());
            bean7.setAddress(drawableId7);
            bean7.setName(getResources().getString(R.string.first_dianjian));
            itemList.add(bean7);

            ItemBean bean8 = new ItemBean();
            int drawableId8 = getResources().getIdentifier("rb8", "drawable", getActivity().getPackageName());
            bean8.setAddress(drawableId8);
            bean8.setName(getResources().getString(R.string.first_shigu));
            itemList.add(bean8);

            ItemBean bean9 = new ItemBean();
            int drawableId9 = getResources().getIdentifier("rb9", "drawable", getActivity().getPackageName());
            bean9.setAddress(drawableId9);
            bean9.setName(getResources().getString(R.string.first_yuangong));
            itemList.add(bean9);

            ItemBean bean10 = new ItemBean();
            int drawableId10 = getResources().getIdentifier("rb10", "drawable", getActivity().getPackageName());
            bean10.setAddress(drawableId10);
            bean10.setName(getResources().getString(R.string.first_qita));
            itemList.add(bean10);
        }
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

    @Override
    public void setNoticeList(Notice bean) {
        beanList.clear();
        for (int i = 0; i < bean.getResult().size(); i++) {
            beanList.add(bean.getResult().get(i));
        }
        String s = "";
        for (int i = 0; i < beanList.size(); i++) {
            s = s + beanList.get(i).getSubject() + "\n" + "\n" + "\n";
        }
        tvSeeItNow.setText(s);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        if (beanList.size() > 2) {
            List<Notice.ResultBean> beanList1 = new ArrayList<>();
            beanList1.add(beanList.get(0));
            beanList1.add(beanList.get(1));
            beanList.clear();
            beanList = beanList1;
        }
        mAdapter = new BaseRecyclerAdapter<Notice.ResultBean>(getActivity(), R.layout.notice_item_layout, beanList) {
            @Override
            public void convert(BaseViewHolder holder, final Notice.ResultBean noticeBean) {
                num = 0;
                if (num <= 2) {
                    holder.setText(R.id.tv_title, "\t" + noticeBean.getSubject());
                    holder.setText1(R.id.tv_content, noticeBean.getContent());
                    holder.setOnClickListener(R.id.noticeItem, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            intent = new Intent(getActivity(), NoticeDetailActivity.class);
                            intent.putExtra("bean", noticeBean);
                            startActivity(intent);
                        }
                    });
                }
                num += 1;
            }
        };
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        ll.setRefreshing(false);
    }

    //获取错误信息
    @Override
    public void setNoticeMessage(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9
            , R.id.rb10, R.id.tvSeeItNow})
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
                intent = new Intent(getActivity(), ProcessActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(getActivity(), OAPublishActivity.class);
                startActivity(intent);
                break;
            case R.id.rb4:
                intent = new Intent(getActivity(), CarCheckActivity.class);
                startActivity(intent);
                break;
            case R.id.rb5:
                intent = new Intent(getActivity(), SafeActivity.class);
                startActivity(intent);
                break;
            case R.id.rb6:
                intent = new Intent(getActivity(), RCJCActivity.class);
                startActivity(intent);
                break;
            case R.id.rb7:
                intent = new Intent(getActivity(), HealthActivity.class);
                startActivity(intent);
                break;
            case R.id.rb8:
                intent = new Intent(getActivity(), FaultUpActivity.class);
                startActivity(intent);
                break;
            case R.id.rb9:
                intent = new Intent(getActivity(), ExamListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb10:
                intent = new Intent(getActivity(), OtherListActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        mAdapter.notifyDataSetChanged();
    }
}
