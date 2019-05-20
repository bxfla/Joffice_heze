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
import com.smartbus.heze.checkup.bean.LineCode;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.checkup.module.LineCodeContract;
import com.smartbus.heze.checkup.presenter.LineCodePresenter;
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

public class LineCodeActivity extends BaseActivity implements LineCodeContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    BaseRecyclerAdapter adapter;
    LineCodePresenter lineCodePresenter;
    List<LineCodeData> beanListData = new ArrayList<>();
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.line_code));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        lineCodePresenter = new LineCodePresenter(this, this);
        beanListData = DataSupport.findAll(LineCodeData.class);
        if (beanListData.size() != 0) {
            setAdapter(beanListData);
        } else {
            lineCodePresenter.getLineCode();
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
        List<LineCodeData> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = beanListData;
        } else {
            mSortList.clear();
            for (LineCodeData sortModel : beanListData) {
                String name = sortModel.getLineCode();
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

    }

    /**
     * 获取线路编号
     *
     * @param s
     */
    @Override
    public void setLineCode(LineCode s) {
        if (s != null) {
            for (int i = 0; i < s.getData().size(); i++) {
                LineCodeData bean = new LineCodeData();
                beanListData.add(bean);
                bean.setLineCode(s.getData().get(i).getLineCode());
                bean.setLineInfoId(s.getData().get(i).getLineInfoId());
                bean.setLineName(s.getData().get(i).getLineName());
                bean.save();
            }
        }
        setAdapter(beanListData);
    }


    private void setAdapter(List<LineCodeData> mSortList) {
        adapter = new BaseRecyclerAdapter<LineCodeData>(this, R.layout.adapter_easy_item, mSortList) {
            @Override
            public void convert(BaseViewHolder holder, final LineCodeData o) {
                holder.setText(R.id.textView, o.getLineCode());
                holder.setOnClickListener(R.id.textView, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.putExtra("lineCode", o);
                        setResult(Constant.TAG_ONE, intent);
                        finish(); //结束当前的activity的生命周期
                    }
                });
            }
        };
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setLineCodeMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
