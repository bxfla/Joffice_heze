package com.smartbus.heze.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.activity.BorrowAccidentWillActivity;
import com.smartbus.heze.fileapprove.activity.CurrencyAccidentWillActivity;
import com.smartbus.heze.fileapprove.activity.DepartBudgetWillActivity;
import com.smartbus.heze.fileapprove.activity.DocumentLZWillActivity;
import com.smartbus.heze.fileapprove.activity.FileCirculateWillActivity;
import com.smartbus.heze.fileapprove.activity.HuiQianWillActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.main.bean.WillDoList;
import com.smartbus.heze.main.module.WillDoListContract;
import com.smartbus.heze.main.presenter.WillDoListPresenter;
import com.smartbus.heze.oaflow.activity.AddWorkWillActivity;
import com.smartbus.heze.oaflow.activity.AtWorkWillActivity;
import com.smartbus.heze.oaflow.activity.OldWorkWillActivity;
import com.smartbus.heze.oaflow.activity.UserdLeaveWillActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/12.
 * 待办列表
 */

public class Fragment02 extends Fragment implements WillDoListContract.View {
    View view;
    @BindView(R.id.llNoContent)
    LinearLayout llNoContent;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter adapter;
    List<WillDoList.ResultBean> beanList = new ArrayList<>();
    WillDoListPresenter willDoListPresenter;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment02, container, false);
        unbinder = ButterKnife.bind(this, view);
        willDoListPresenter = new WillDoListPresenter(getActivity(), this);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        return view;
    }

    @Override
    public void setWillDoList(WillDoList willDoList) {
        if (willDoList.getResult().size()==0){
            recyclerView.setVisibility(View.GONE);
            llNoContent.setVisibility(View.VISIBLE);
        }else {
            recyclerView.setVisibility(View.VISIBLE);
            llNoContent.setVisibility(View.GONE);
            for (int i = 0;i<willDoList.getResult().size();i++){
                beanList.add(willDoList.getResult().get(i));
            }
            adapter = new BaseRecyclerAdapter<WillDoList.ResultBean>(getActivity(),R.layout.adapter_easy_item,beanList) {
                @Override
                public void convert(BaseViewHolder holder, final WillDoList.ResultBean o) {
                    holder.setText(R.id.textView,o.getTaskName());
                    holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (o.getFormDefId().equals(Constant.YSD_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), DepartBudgetWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.BORROWACCIDENT_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), BorrowAccidentWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.CURRENCYACCIDENT_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), CurrencyAccidentWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.HUIQIAN_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), HuiQianWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.FILECIR_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), FileCirculateWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.DOCUMENTLZ_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), DocumentLZWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.USERDLEAVE_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), UserdLeaveWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.ADDWORK_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), AddWorkWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.OLDWORK_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), OldWorkWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                            if (o.getFormDefId().equals(Constant.ATWORK_FORMDEFIS)){
                                Intent intent = new Intent(getActivity(), AtWorkWillActivity.class);
                                intent.putExtra("activityName", o.getActivityName());
                                intent.putExtra("taskId", o.getTaskId());
                                startActivity(intent);
                            }
                        }
                    });
                }
            };
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setWillDoListMessage(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onResume() {
        super.onResume();
        beanList.clear();
        willDoListPresenter.getWillDoList();
    }
}
