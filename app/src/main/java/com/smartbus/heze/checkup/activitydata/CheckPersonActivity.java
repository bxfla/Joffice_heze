package com.smartbus.heze.checkup.activitydata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.adapter.CheckPersonAdapter;
import com.smartbus.heze.checkup.bean.CheckPerson;
import com.smartbus.heze.checkup.bean.CheckPersonData;
import com.smartbus.heze.checkup.module.CheckPersonContract;
import com.smartbus.heze.checkup.presenter.CheckPersonPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.azlistview.EditTextWithDel;
import com.smartbus.heze.http.utils.azlistview.PinyinUtils;
import com.smartbus.heze.http.views.Header;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CheckPersonActivity extends BaseActivity implements CheckPersonContract.View,CheckPersonAdapter.CallBackPosition {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;

    String tag;
    String name = "";
    CheckPersonAdapter adapter;
    CheckPersonPresenter checkPersonPresenter;
    private List<String> selectPerson = new ArrayList<>();
    List<CheckPersonData> beanListData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.check_person));
        tag = getIntent().getStringExtra("tag");
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        checkPersonPresenter = new CheckPersonPresenter(this, this);
        beanListData = DataSupport.findAll(CheckPersonData.class);
        if (beanListData.size() != 0) {
            setAdapter(beanListData);
        } else {
            checkPersonPresenter.getCheckPerson();
        }

        //根据输入框输入值的改变来过滤搜索
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
                filterData(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<CheckPersonData> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = beanListData;
        } else {
            mSortList.clear();
            for (CheckPersonData sortModel : beanListData) {
                String name = sortModel.getFullname();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
            setAdapter(mSortList);
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
        if (selectPerson.size()!=0){
            for (int i = 0;i<selectPerson.size();i++){
                if (i!=selectPerson.size()-1){
                    name = name+selectPerson.get(i)+",";
                }else {
                    name = name+selectPerson.get(i);
                }
            }
        }
        Intent i = new Intent();
        i.putExtra("name", name);
        setResult(Constant.TAG_FOUR, i);
        finish();
    }

    private void setAdapter(List<CheckPersonData> mSortList) {
//        adapter = new BaseRecyclerAdapter<CheckPersonData>(this, R.layout.adapter_easy_item, mSortList) {
//            @Override
//            public void convert(BaseViewHolder holder, final CheckPersonData o) {
//                holder.setText(R.id.textView, o.getFullname());
//
//                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent();
//                        intent.putExtra("carCode", o);
//                        setResult(Constant.TAG_TWO, intent);
//                        finish(); //结束当前的activity的生命周期
//                    }
//                });
//            }
//        };
        adapter = new CheckPersonAdapter(this,mSortList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemLitener(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCheckPerson(CheckPerson s) {
        if (s != null) {
            for (int i = 0; i < s.getData().size(); i++) {
                CheckPersonData bean = new CheckPersonData();
                beanListData.add(bean);
                bean.setPosition(s.getData().get(i).getPosition());
                bean.setUserCode(s.getData().get(i).getUserCode());
                bean.setProfileId(s.getData().get(i).getProfileId());
                bean.setECard(s.getData().get(i).getECard());
                bean.setDepName(s.getData().get(i).getDepName());
                bean.setDepId(s.getData().get(i).getDepId());
                bean.setFullname(s.getData().get(i).getFullname());
                bean.save();
            }
        }
        setAdapter(beanListData);
    }

    @Override
    public void setCheckPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(int position) {
        if (selectPerson.contains(beanListData.get(position).getFullname())){
            selectPerson.remove(beanListData.get(position).getFullname());
        }else {
            selectPerson.add(beanListData.get(position).getFullname());
        }
    }
}
