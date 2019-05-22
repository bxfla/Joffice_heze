package com.smartbus.heze.checkup.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.checkup.activitydata.CarCodeActivity;
import com.smartbus.heze.checkup.activitydata.CheckPersonActivity;
import com.smartbus.heze.checkup.activitydata.LineCodeActivity;
import com.smartbus.heze.checkup.activitydata.UserCodeActivity;
import com.smartbus.heze.checkup.adapter.CarCheckAdapter;
import com.smartbus.heze.checkup.bean.CarCheckItem;
import com.smartbus.heze.checkup.bean.CarCodeData;
import com.smartbus.heze.checkup.bean.LineCodeData;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.checkup.bean.UserCodeData;
import com.smartbus.heze.checkup.module.CarCehckUpDataContract;
import com.smartbus.heze.checkup.module.CarCheckItemContract;
import com.smartbus.heze.checkup.presenter.CarCheckItemPresenter;
import com.smartbus.heze.checkup.presenter.CarCheckUpDataPresenter;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.utils.time_select.CustomDatePickerDay;
import com.smartbus.heze.http.views.Header;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 车辆巡检
 */
public class CarCheckActivity extends BaseActivity implements CarCheckItemContract.View,
        CarCheckAdapter.GetItemPosition, CarCehckUpDataContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.etLine)
    EditText etLine;
    @BindView(R.id.imLine)
    ImageView imLine;
    @BindView(R.id.etCarCode)
    EditText etCarCode;
    @BindView(R.id.imCarCode)
    ImageView imCarCode;
    @BindView(R.id.etCarNo)
    EditText etCarNo;
    @BindView(R.id.imCarNo)
    ImageView imCarNo;
    @BindView(R.id.etPersonCode)
    EditText etPersonCode;
    @BindView(R.id.imPersonCode)
    ImageView imPersonCode;
    @BindView(R.id.etPersonName)
    EditText etPersonName;
    @BindView(R.id.imPersonName)
    ImageView imPersonName;
    @BindView(R.id.etRummager)
    EditText etRummager;
    @BindView(R.id.imRummager)
    ImageView imRummager;
    @BindView(R.id.etCarType)
    EditText etCarType;
    @BindView(R.id.tvClassTime)
    TextView tvClassTime;
    @BindView(R.id.tvTime)
    TextView tvTime;
    @BindView(R.id.etRemarks)
    EditText etRemarks;
    @BindView(R.id.btnUp)
    Button btnUp;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll4)
    LinearLayout ll4;
    @BindView(R.id.llType)
    LinearLayout llType;
    @BindView(R.id.llTime)
    LinearLayout llTime;

    Intent intent;
    String depName, depId, positionDate,categoryCode;
    CarCheckAdapter adapter;
    CarCheckItemPresenter carCheckItemPresenter;
    CarCheckUpDataPresenter carCheckUpDataPresenter;
    private CustomDatePickerDay customDatePicker;
    List<CarCheckItem.ResultBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initDatePicker();
        llTime.setVisibility(View.GONE);
        llType.setVisibility(View.GONE);
        header.setTvTitle(getResources().getString(R.string.first_anquan));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        carCheckItemPresenter = new CarCheckItemPresenter(this, this);
        carCheckUpDataPresenter = new CarCheckUpDataPresenter(this, this);
    }

    /**
     * 选择时间
     */
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        tvTime.setText(now.split(" ")[0]);
        customDatePicker = new CustomDatePickerDay(this, new CustomDatePickerDay.ResultHandler() {
            @Override
            public void handle(String time) {
                // 回调接口，获得选中的时间
                tvTime.setText(time.split(" ")[0]);
            }
            // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        }, "2000-01-01 00:00", "2030-01-01 00:00");
        // 不显示时和分
        customDatePicker.showSpecificTime(false);
        // 不允许循环滚动
        customDatePicker.setIsLoop(false);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_rcjc;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.imLine, R.id.imCarCode, R.id.imCarNo, R.id.imPersonCode, R.id.imPersonName,
            R.id.imRummager, R.id.tvClassTime, R.id.tvTime, R.id.btnUp, R.id.ll1, R.id.ll2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imLine:
                intent = new Intent(this, LineCodeActivity.class);
                startActivityForResult(intent, Constant.TAG_ONE);
                break;
            case R.id.imCarCode:
                intent = new Intent(this, CarCodeActivity.class);
                intent.putExtra("tag", "carCode");
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imCarNo:
                intent = new Intent(this, CarCodeActivity.class);
                intent.putExtra("tag", "carNo");
                startActivityForResult(intent, Constant.TAG_TWO);
                break;
            case R.id.imPersonCode:
                intent = new Intent(this, UserCodeActivity.class);
                intent.putExtra("tag", "userCode");
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imPersonName:
                intent = new Intent(this, UserCodeActivity.class);
                intent.putExtra("tag", "userName");
                startActivityForResult(intent, Constant.TAG_THERE);
                break;
            case R.id.imRummager:
                intent = new Intent(this, CheckPersonActivity.class);
                startActivityForResult(intent, Constant.TAG_FOUR);
                break;
            case R.id.tvClassTime:
                break;
            case R.id.tvTime:
                customDatePicker.show(tvTime.getText().toString());
                break;
            case R.id.btnUp:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setStackFromEnd(true);
                recyclerView.setLayoutManager(linearLayoutManager);
                adapter.setOnInnerItemOnClickListener(this);
                //包装数据
                JSONArray jsonArrayData = new JSONArray();
                JSONArray jsonArrayfkData = new JSONArray();
                try {
                    for (int i = 0; i < beanList.size(); i++) {
                        JSONObject jsonObjectType = new JSONObject();
                        JSONObject jsonObjectMoney = new JSONObject();
                        jsonObjectType.put(beanList.get(i).getProjectName(), beanList.get(i).getState());
                        jsonObjectMoney.put(beanList.get(i).getProjectName(), beanList.get(i).getFkje());
                        jsonArrayData.put(jsonObjectType);
                        jsonArrayfkData.put(jsonObjectMoney);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "数据拼接错误", Toast.LENGTH_SHORT).show();
                }
                carCheckUpDataPresenter.getUpData(jsonArrayData.toString(), jsonArrayfkData.toString(),
                        tvTime.getText().toString(), etLine.getText().toString(), etCarNo.getText().toString()
                        , etCarCode.getText().toString(), depId, depName, etPersonName.getText().toString()
                        , etPersonCode.getText().toString(), etRummager.getText().toString(), etRemarks.getText().toString(),categoryCode);
                break;
            case R.id.ll1:
                if (ll3.getVisibility() == View.VISIBLE) {
                    ll3.setVisibility(View.GONE);
                    ll4.setVisibility(View.VISIBLE);
                } else if (ll3.getVisibility() == View.GONE) {
                    ll3.setVisibility(View.VISIBLE);
                    ll4.setVisibility(View.GONE);
                }
                break;
            case R.id.ll2:
                if (categoryCode==null||categoryCode.equals("")){
                    Toast.makeText(this, "请选择车辆", Toast.LENGTH_SHORT).show();
                }else {
                    if (ll4.getVisibility() == View.VISIBLE) {
                        ll4.setVisibility(View.GONE);
                        ll3.setVisibility(View.VISIBLE);
                    } else if (ll4.getVisibility() == View.GONE) {
                        ll4.setVisibility(View.VISIBLE);
                        ll3.setVisibility(View.GONE);
                    }
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constant.TAG_ONE:
                if (resultCode == Constant.TAG_ONE) {
                    LineCodeData lineCodeData = (LineCodeData) data.getSerializableExtra("lineCode");
                    etLine.setText(lineCodeData.getLineCode());
                }
                break;
            case Constant.TAG_TWO:
                if (resultCode == Constant.TAG_TWO) {
                    CarCodeData carCodeData = (CarCodeData) data.getSerializableExtra("carCode");
                    etCarCode.setText(carCodeData.getBusCode());
                    etCarNo.setText(carCodeData.getCarNo());
                    depName = carCodeData.getDepName();
                    depId = carCodeData.getDepId();
                    String materialType = carCodeData.getMaterialType();
                    if (materialType.equals("电耗")){
                        categoryCode = "4776";
                    }else if (materialType.equals("燃油")){
                        categoryCode = "4775";
                    }
                    carCheckItemPresenter.getCarCheckItem(categoryCode,"2");
                }
                break;
            case Constant.TAG_THERE:
                if (resultCode == Constant.TAG_THERE) {
                    UserCodeData userCodeData = (UserCodeData) data.getSerializableExtra("userCode");
                    etPersonCode.setText(userCodeData.getECard());
                    etPersonName.setText(userCodeData.getFullname());
                    positionDate = userCodeData.getPositionDate();
                    etCarType.setText(userCodeData.getVehicleClass());
                    tvClassTime.setText(userCodeData.getPositionDate());
                }
            case Constant.TAG_FOUR:
                if (resultCode == Constant.TAG_FOUR) {
                    String selectName = data.getStringExtra("name");
                    etRummager.setText(selectName);
                }
                break;
        }
    }

    @Override
    public void setCarCheckItem(CarCheckItem s) {
        for (int i = 0; i < s.getResult().size(); i++) {
            beanList.add(s.getResult().get(i));
        }
        adapter = new CarCheckAdapter(this, beanList);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        adapter.setOnInnerItemOnClickListener(this);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCarCheckItemMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 数据提交
     *
     * @param s
     */
    @Override
    public void setUpData(UpData s) {
        if (s.isSuccess()) {
            Toast.makeText(this, "数据提交成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setUpDataMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getPosition(int position, String money, String tag) {
        CarCheckItem.ResultBean bean = new CarCheckItem.ResultBean();
        bean.setProjectId(beanList.get(position).getProjectId());
        bean.setProjectName(beanList.get(position).getProjectName());
        bean.setFkje(Double.parseDouble(money));
        if (tag.equals("rb1")) {
            bean.setState(1);
        } else if (tag.equals("rb2")) {
            bean.setState(0);
        }
        bean.setProjectKey(beanList.get(position).getProjectKey());
        beanList.set(position, bean);
    }

}