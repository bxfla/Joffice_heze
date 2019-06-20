package com.smartbus.heze.checkup.activitydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.bean.UserCode;
import com.smartbus.heze.checkup.bean.UserCodeData;
import com.smartbus.heze.checkup.module.UserCodeContract;
import com.smartbus.heze.checkup.presenter.UserCodePresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.BaseRecyclerAdapter;
import com.smartbus.heze.http.utils.BaseViewHolder;
import com.smartbus.heze.http.utils.azlistview.EditTextWithDel;
import com.smartbus.heze.http.utils.azlistview.PinyinUtils;
import com.smartbus.heze.http.views.Header;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserCodeActivity extends BaseActivity implements UserCodeContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;

    String tag;
    BaseRecyclerAdapter adapter;
    UserCodePresenter userCodePresenter;
    List<UserCodeData> beanListData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tag = getIntent().getStringExtra("tag");
        if (tag.equals("userCode")){
            header.setTvTitle(getResources().getString(R.string.user_code));
        }else if (tag.equals("userName")){
            header.setTvTitle(getResources().getString(R.string.user_name));
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        userCodePresenter = new UserCodePresenter(this, this);
        beanListData = DataSupport.findAll(UserCodeData.class);
        if (beanListData.size() != 0) {
            setAdapter(beanListData);
        } else {
            userCodePresenter.getUserCode();
        }

        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterData(s.toString());
            }
        });
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<UserCodeData> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = beanListData;
        } else {
            mSortList.clear();
            for (UserCodeData sortModel : beanListData) {
                String name = sortModel.getFullname();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
            setAdapter(mSortList);
            beanListData.clear();
            beanListData = mSortList;
        }
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_line_code;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    private void setAdapter(List<UserCodeData> mSortList) {
        adapter = new BaseRecyclerAdapter<UserCodeData>(this, R.layout.adapter_easy_item, mSortList) {
            @Override
            public void convert(BaseViewHolder holder, final UserCodeData o) {
                if (tag.equals("userCode")){
                    holder.setText(R.id.textView, o.getECard());
                }else if (tag.equals("userName")){
                    holder.setText(R.id.textView, o.getFullname());
                }

                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("userCode", o);
                        setResult(Constant.TAG_THERE, intent);
                        finish(); //结束当前的activity的生命周期
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * 获取员工编号
     * @param s
     */
    @Override
    public void setUserCode(UserCode s) {
        if (s != null) {
            for (int i = 0; i < s.getData().size(); i++) {
                UserCodeData bean = new UserCodeData();
                bean.setSex(s.getData().get(i).getSex());
                bean.setIdCard(s.getData().get(i).getIdCard());
                bean.setUserCode(s.getData().get(i).getUserCode());
                bean.setECard(s.getData().get(i).getECard());
                bean.setDepName(s.getData().get(i).getDepName());
                bean.setDepId(s.getData().get(i).getDepId());
                bean.setFullname(s.getData().get(i).getFullname());
                bean.setPositionDate(s.getData().get(i).getPositionDate());
                bean.setVehicleClass(s.getData().get(i).getVehicleClass());
                beanListData.add(bean);
                bean.save();
            }
        }
        setAdapter(beanListData);
    }

   @Override
    public void setUserCodeMessage(String s) {
       Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
