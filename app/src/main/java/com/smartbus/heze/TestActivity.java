package com.smartbus.heze;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends BaseActivity {
    @BindView(R.id.header)
    Header header;
    @BindView(R.id.expandList)
    ExpandableListView expandList;
    List<String> beanList1 = new ArrayList<>();
    List<TestBean> beanList2 = new ArrayList<>();
    List<TestBean> beanList3 = new ArrayList<>();
    List<TestBean> beanList4 = new ArrayList<>();
    List<List<TestBean>> beanList5 = new ArrayList<>();

    List<String> moneyList = new ArrayList<>();
    List<String> checkList = new ArrayList<>();
    TestAdapter myAdapter;

//    private String[] groups = {};
//    private String[][] childs = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        getData();
        myAdapter = new TestAdapter(this,beanList1,beanList5);
        expandList.setAdapter(myAdapter);

        expandList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(getBaseContext(), "Child clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_test;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {
        beanList5 = myAdapter.backData();
        Toast.makeText(this, beanList5.get(0).size()+"", Toast.LENGTH_SHORT).show();
        for (int i = 0;i<beanList5.get(0).size();i++){
            Log.e("XXX",beanList5.get(0).get(i).getNum());
        }
        for (int i = 0;i<beanList5.get(1).size();i++){
            Log.e("XXX",beanList5.get(1).get(i).getNum());
        }
    }

    private void getData() {
        String data = "{\"success\":true,\"data\":[{\"type\":\"安全行车\",\"projectName\":\"安全文明驾驶\",\"score\":2.00},{\"type\":\"安全行车\",\"projectName\":\"平稳驾驶\",\"score\":3.00},{\"type\":\"安全行车\",\"projectName\":\"规范进出站\",\"score\":3.00},{\"type\":\"安全行车\",\"projectName\":\"安检\",\"score\":2.00},{\"type\":\"安全行车\",\"projectName\":\"正点、规范运营\",\"score\":100.00},{\"type\":\"安全行车\",\"projectName\":\"应急情况处理\",\"score\":3.00},{\"type\":\"安全行车\",\"projectName\":\"到站停车\",\"score\":100.00},{\"type\":\"安全行车\",\"projectName\":\"车辆发生故障时引导接应换乘乘客\",\"score\":2.00},{\"type\":\"安全行车\",\"projectName\":\"终点站上客\",\"score\":100.00},{\"type\":\"驾驶技能\",\"projectName\":\"八不走\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"出车前怠速运转\",\"score\":3.00},{\"type\":\"驾驶技能\",\"projectName\":\"启动前仪表检查\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"起动\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"起步档位\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"灯光使用\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"开关门和起步程序\",\"score\":100.00},{\"type\":\"驾驶技能\",\"projectName\":\"增减档\",\"score\":2.00},{\"type\":\"驾驶技能\",\"projectName\":\"总电源关闭\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"仪容仪表\",\"score\":1.00},{\"type\":\"服务规范\",\"projectName\":\"服务语言态度\",\"score\":3.00},{\"type\":\"服务规范\",\"projectName\":\"普通话\",\"score\":3.00},{\"type\":\"服务规范\",\"projectName\":\"重点照顾\",\"score\":1.00},{\"type\":\"服务规范\",\"projectName\":\"疏导\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"报站器使用\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"温度调节\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"车辆卫生\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"物品摆放\",\"score\":1.00},{\"type\":\"服务规范\",\"projectName\":\"服务展示牌使用\",\"score\":3.00},{\"type\":\"服务规范\",\"projectName\":\"违站不停\",\"score\":100.00},{\"type\":\"服务规范\",\"projectName\":\"二次进站、跑来等\",\"score\":2.00},{\"type\":\"服务规范\",\"projectName\":\"班前吃异味食品\",\"score\":1.00},{\"type\":\"服务规范\",\"projectName\":\"终点站检查\",\"score\":1.00}]}";
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0;i<jsonArray.length();i++){
                moneyList.add("");
                checkList.add("1");
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if (!beanList1.contains(jsonObject1.getString("type"))){
                    beanList1.add(jsonObject1.getString("type"));
                }
            }
//            groups = (String[])beanList1.toArray(new String[beanList1.size()]);
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                if (jsonObject1.getString("type").equals(beanList1.get(0))){
                    TestBean bean1 = new TestBean();
                    bean1.setText(String.valueOf(jsonObject1.get("projectName")));
                    bean1.setNum("0");
                    bean1.setType("1");
                    beanList2.add(bean1);
                }
                if (jsonObject1.getString("type").equals(beanList1.get(1))){
                    TestBean bean1 = new TestBean();
                    bean1.setText(String.valueOf(jsonObject1.get("projectName")));
                    bean1.setNum("0");
                    bean1.setType("1");
                    beanList3.add(bean1);
                }
                if (jsonObject1.getString("type").equals(beanList1.get(2))){
                    TestBean bean1 = new TestBean();
                    bean1.setText(String.valueOf(jsonObject1.get("projectName")));
                    bean1.setNum("0");
                    bean1.setType("1");
                    beanList4.add(bean1);
                }
            }
//            String[] array1 = (String[])beanList2.toArray(new String[beanList2.size()]);
//            String[] array2 = (String[])beanList3.toArray(new String[beanList3.size()]);
//            String[] array3 = (String[])beanList4.toArray(new String[beanList4.size()]);
            beanList5.add(beanList2);
            beanList5.add(beanList3);
            beanList5.add(beanList4);
//            childs = (String[])beanList5.toArray(new String[beanList5.size()]);
            Log.e("XXX",beanList1.toString());
            Log.e("XXX",beanList5.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
