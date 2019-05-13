package com.smartbus.heze;

import android.content.Context;
import android.database.DataSetObserver;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/5/11.
 */

public class TestAdapter extends BaseExpandableListAdapter {
    List<String> groudList = new ArrayList<>();
    List<List<TestBean>>childList = new ArrayList<>();
    Context context;

    public TestAdapter(TestActivity testActivity, List<String> groudList, List<List<TestBean>> childList) {
        this.context = testActivity;
        this.groudList = groudList;
        this.childList = childList;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    //返回一级列表的个数
    @Override
    public int getGroupCount() {
        return groudList.size();
    }

    //返回每个二级列表的个数
    @Override
    public int getChildrenCount(int groupPosition) { //参数groupPosition表示第几个一级列表
        Log.d("smyhvae", "-->" + groupPosition);
        return childList.get(groupPosition).size();
    }

    //返回一级列表的单个item（返回的是对象）
    @Override
    public Object getGroup(int groupPosition) {
        return groudList.get(groupPosition);
    }

    //返回二级列表中的单个item（返回的是对象）
    @Override
    public Object getChild(int groupPosition, int childPosition) {
//            return childs[groupPosition][childPosition];
        return childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    //每个item的id是否是固定？一般为true
    @Override
    public boolean hasStableIds() {
        return true;
    }

    //【重要】填充一级列表
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_group_item, null);
        }
        TextView tv_group = (TextView) convertView.findViewById(R.id.textView);
        tv_group.setText(groudList.get(groupPosition));
        return convertView;
    }

    //【重要】填充二级列表
    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_chlid_item, null);
        }
        TextView tv_child = (TextView) convertView.findViewById(R.id.textView);
        RadioButton rb1 = (RadioButton) convertView.findViewById(R.id.rb1);
        RadioButton rb2 = (RadioButton) convertView.findViewById(R.id.rb2);
        EditText et = (EditText) convertView.findViewById(R.id.editText);

        //iv_child.setImageResource(resId);
        tv_child.setText(childList.get(groupPosition).get(childPosition).getText());
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                List<TestBean> beanList = childList.get(groupPosition);
                TestBean bean = beanList.get(childPosition);
                bean.setNum(s.toString());
                beanList.set(childPosition,bean);
                childList.set(groupPosition,beanList);
            }
        });

        return convertView;
    }

    //二级列表中的item是否能够被选中？可以改为true
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public List<List<TestBean>> backData(){
        return childList;
    }
}
