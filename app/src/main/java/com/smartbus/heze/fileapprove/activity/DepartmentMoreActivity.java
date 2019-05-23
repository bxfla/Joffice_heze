package com.smartbus.heze.fileapprove.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.adapter.DepartmentMoreAdapter;
import com.smartbus.heze.fileapprove.bean.Department;
import com.smartbus.heze.fileapprove.bean.DepartmentDataBean;
import com.smartbus.heze.fileapprove.module.DepartmentContract;
import com.smartbus.heze.fileapprove.presenter.DepartmentPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.azlistview.EditTextWithDel;
import com.smartbus.heze.http.utils.azlistview.PinyinComparatorP;
import com.smartbus.heze.http.utils.azlistview.PinyinUtils;
import com.smartbus.heze.http.utils.azlistview.SideBar;
import com.smartbus.heze.http.views.Header;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DepartmentMoreActivity extends BaseActivity implements DepartmentContract.View{

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.et_search)
    EditTextWithDel etSearch;
    @BindView(R.id.lv_contact)
    ListView lvContact;
    @BindView(R.id.dialog)
    TextView dialog;
    @BindView(R.id.sidrbar)
    SideBar sidrbar;

    DepartmentPresenter departmentPresenter;
    DepartmentDataBean selectDepartment = new DepartmentDataBean();
    DepartmentMoreAdapter departmentAdapter;
    List<String> backList = new ArrayList<>();
    List<String> backList1 = new ArrayList<>();
    List<DepartmentDataBean> departmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        departmentList = DataSupport.findAll(DepartmentDataBean.class);
        //
        if (departmentList.size() != 0) {
            initDatas();
            initEvents();
            setAdapter();
        }else {
            departmentPresenter = new DepartmentPresenter(this,this);
            departmentPresenter.getDepartment();
        }
    }

    private void initDatas() {
        sidrbar.setTextView(dialog);
    }

    private void initEvents() {
        //设置右侧触摸监听
        sidrbar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                //该字母首次出现的位置
                int position = departmentAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    lvContact.setSelection(position + 1);
                }
            }
        });

        //ListView的点击事件
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (ListView.CHOICE_MODE_MULTIPLE == lvContact.getChoiceMode()) {
                    selectDepartment = departmentList.get(position);
                }
            }
        });

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

    private void setAdapter() {
        Collections.sort(departmentList, new PinyinComparatorP());
        departmentAdapter = new DepartmentMoreAdapter(this, departmentList);
        lvContact.setAdapter(departmentAdapter);
        departmentAdapter.setOnClientMyTextView(new DepartmentMoreAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(DepartmentDataBean bean,String s) {
                if (s.equals("add")){
                    backList.add(bean.getDepName());
                    backList1.add(bean.getDepId());
                }else if (s.equals("remove")){
                    backList.remove(bean.getDepName());
                    backList1.remove(bean.getDepId());
                }
//                Intent intent = new Intent();
//                intent.putExtra("department", bean);
//                setResult(Constant.TAG_ONE, intent);
//                finish(); //结束当前的activity的生命周期
            }
        });
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<DepartmentDataBean> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = departmentList;
        } else {
            mSortList.clear();
            for (DepartmentDataBean sortModel : departmentList) {
                String name = sortModel.getDepName();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparatorP());
        departmentAdapter.updateListView(mSortList);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_department;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        Intent intent = new Intent();
        intent.putStringArrayListExtra("bean", (ArrayList<String>) backList);
        intent.putStringArrayListExtra("beanId", (ArrayList<String>) backList1);
        setResult(Constant.TAG_ONE, intent);
        finish(); //结束当前的activity的生命周期
    }

    @Override
    public void setDepartment(Department department) {
        for (int i = 0; i < department.getData().size(); i++) {
            DepartmentDataBean databean = new DepartmentDataBean();
            databean.setDepId(department.getData().get(i).getDepId());
            databean.setDepName(department.getData().get(i).getDepName());
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(department.getData().get(i).getDepName());
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                databean.setLetters(sortString);
            } else {
                databean.setLetters("#");
            }
            departmentList.add(databean);
            databean.save();
        }
        setAdapter();
    }

    @Override
    public void setDepartmentMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
