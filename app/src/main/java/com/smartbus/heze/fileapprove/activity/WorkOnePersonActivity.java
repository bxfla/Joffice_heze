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
import com.smartbus.heze.fileapprove.adapter.WorkOnePersonAdapter;
import com.smartbus.heze.fileapprove.bean.WorkOnePerson;
import com.smartbus.heze.fileapprove.bean.WorkOnePersonDataBean;
import com.smartbus.heze.fileapprove.module.WorkOnePersonContract;
import com.smartbus.heze.fileapprove.presenter.WorkOnePersonPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.azlistview.EditTextWithDel;
import com.smartbus.heze.http.utils.azlistview.PinyinComparatorOnePerson;
import com.smartbus.heze.http.utils.azlistview.PinyinUtils;
import com.smartbus.heze.http.utils.azlistview.SideBar;
import com.smartbus.heze.http.views.Header;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkOnePersonActivity extends BaseActivity implements WorkOnePersonContract.View {

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

    WorkOnePersonPresenter workPersonPresenter;
    WorkOnePersonDataBean selectDepartment = new WorkOnePersonDataBean();
    WorkOnePersonAdapter departmentAdapter;
    List<WorkOnePersonDataBean> workpersonList = new ArrayList<>();
    List<String> backList = new ArrayList<>();
    List<String> backListId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        header.setTvTitle(getResources().getString(R.string.person_list));
        workpersonList = DataSupport.findAll(WorkOnePersonDataBean.class);
        //
        if (workpersonList.size() != 0) {
            initDatas();
            initEvents();
            setAdapter();
        } else {
            workPersonPresenter = new WorkOnePersonPresenter(this, this);
            workPersonPresenter.getWorkOnePerson();
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
                    selectDepartment = workpersonList.get(position);
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
        Collections.sort(workpersonList, new PinyinComparatorOnePerson());
        departmentAdapter = new WorkOnePersonAdapter(this, workpersonList);
        lvContact.setAdapter(departmentAdapter);
        departmentAdapter.setOnClientMyTextView(new WorkOnePersonAdapter.CallBackPosition() {
            @Override
            public void myTextViewClient(WorkOnePersonDataBean bean, String s) {
                backList.add(bean.getProfileId());
                backListId.add(bean.getFullname());
                Intent intent = new Intent();
                intent.putStringArrayListExtra("bean", (ArrayList<String>) backList);
                intent.putStringArrayListExtra("beanId", (ArrayList<String>) backListId);
                intent.putExtra("department", bean.getDepName());
                intent.putExtra("departmentId", bean.getDepId());
                setResult(Constant.TAG_ONE, intent);
                finish(); //结束当前的activity的生命周期
            }
        });
    }

    /**
     * 根据输入框中的值来过滤数据并更新ListView
     *
     * @param filterStr
     */
    private void filterData(String filterStr) {
        List<WorkOnePersonDataBean> mSortList = new ArrayList<>();
        if (TextUtils.isEmpty(filterStr)) {
            mSortList = workpersonList;
        } else {
            mSortList.clear();
            for (WorkOnePersonDataBean sortModel : workpersonList) {
                String name = sortModel.getFullname();
                if (name.toUpperCase().indexOf(filterStr.toString().toUpperCase()) != -1 || PinyinUtils.getPingYin(name).toUpperCase().startsWith(filterStr.toString().toUpperCase())) {
                    mSortList.add(sortModel);
                }
            }
        }
        // 根据a-z进行排序
        Collections.sort(mSortList, new PinyinComparatorOnePerson());
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
    }

    @Override
    public void setWorkOnePerson(WorkOnePerson workOnePerson) {
        for (int i = 0; i < workOnePerson.getData().size(); i++) {
            WorkOnePersonDataBean databean = new WorkOnePersonDataBean();
            databean.setPosition(workOnePerson.getData().get(i).getPosition());
            databean.setUserCode(workOnePerson.getData().get(i).getUserCode());
            databean.setPositionDate(workOnePerson.getData().get(i).getPositionDate());
            databean.setProfileId(workOnePerson.getData().get(i).getProfileId());
            databean.setVehicleClass(workOnePerson.getData().get(i).getVehicleClass());
            databean.seteCard(workOnePerson.getData().get(i).getECard());
            databean.setDepName(workOnePerson.getData().get(i).getDepName());
            databean.setMnemonicCard(workOnePerson.getData().get(i).getMnemonicCard());
            databean.setDepId(workOnePerson.getData().get(i).getDepId());
            databean.setFullname(workOnePerson.getData().get(i).getFullname());
            //汉字转换成拼音
            String pinyin = PinyinUtils.getPingYin(workOnePerson.getData().get(i).getFullname());
            String sortString = pinyin.substring(0, 1).toUpperCase();

            // 正则表达式，判断首字母是否是英文字母
            if (sortString.matches("[A-Z]")) {
                databean.setLetters(sortString);
            } else {
                databean.setLetters("#");
            }
            workpersonList.add(databean);
            databean.save();
        }
        setAdapter();
    }

    @Override
    public void setWorkOnePersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
