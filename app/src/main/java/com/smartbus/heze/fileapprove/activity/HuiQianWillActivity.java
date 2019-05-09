package com.smartbus.heze.fileapprove.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartbus.heze.R;
import com.smartbus.heze.fileapprove.bean.HuiQianWill;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.HuiQianWillContract;
import com.smartbus.heze.fileapprove.module.NoEndContract;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.fileapprove.module.NormalContract;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.fileapprove.presenter.HuiQianWillPresenter;
import com.smartbus.heze.fileapprove.presenter.NoEndPresenter;
import com.smartbus.heze.fileapprove.presenter.NoHandlerPresenter;
import com.smartbus.heze.fileapprove.presenter.NormalPresenter;
import com.smartbus.heze.fileapprove.presenter.WillDoPresenter;
import com.smartbus.heze.fileapprove.util.SplitData;
import com.smartbus.heze.http.base.AlertDialogCallBackP;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.base.Constant;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.http.views.MyAlertDialog;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 会签发文待办
 */
public class HuiQianWillActivity extends BaseActivity implements HuiQianWillContract.View
        , NormalContract.View, NoEndContract.View, NoHandlerContract.View, WillDoContract.View {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.tvTitle)
    EditText tvTitle;
    @BindView(R.id.tvTheme)
    TextView tvTheme;
    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvData)
    TextView tvData;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.tvQianFa)
    TextView tvQianFa;
    @BindView(R.id.tvHuiQian)
    TextView tvHuiQian;
    @BindView(R.id.tvZhuSong)
    TextView tvZhuSong;
    @BindView(R.id.tvCaoSong)
    TextView tvCaoSong;
    @BindView(R.id.tvDepartment)
    TextView tvDepartment;
    @BindView(R.id.tvNiGao)
    TextView tvNiGao;
    @BindView(R.id.tvHeGao)
    TextView tvHeGao;
    @BindView(R.id.tvYinShua)
    TextView tvYinShua;
    @BindView(R.id.tvJiaoDui)
    TextView tvJiaoDui;
    @BindView(R.id.tvFenShu)
    TextView tvFenShu;
    @BindView(R.id.etHuiQian)
    EditText etHuiQian;
    @BindView(R.id.btnUp)
    Button btnUp;

    String uId;
    String hqMove = "";
    String mainId;
    String destType = "";
    String destName, signaName;
    String activityName, taskId;
    NormalPresenter normalPresenter;
    NoEndPresenter noEndPersenter;
    NoHandlerPresenter noHandlerPresenter;
    WillDoPresenter willDoPresenter;
    HuiQianWillPresenter borrowAccidentWillPresenter;
    List<String> namelist = new ArrayList<>();
    String leaderCode = "";
    String leaderName = "";
    String[] bigNametemp = null;
    String[] bigCodetemp = null;
    List<String> departmentList = new ArrayList<>();
    List<String> nameList = new ArrayList<>();
    List<String> codeList = new ArrayList<>();
    List<String> selectList = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    List<HuiQianWill.TransBean> destTypeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        normalPresenter = new NormalPresenter(this, this);
        noEndPersenter = new NoEndPresenter(this, this);
        noHandlerPresenter = new NoHandlerPresenter(this, this);
        willDoPresenter = new WillDoPresenter(this,this);
        Intent intent = getIntent();
        activityName = intent.getStringExtra("activityName");
        taskId = intent.getStringExtra("taskId");
        Log.e("sessionLogin ", taskId + "-" + activityName);
        borrowAccidentWillPresenter = new HuiQianWillPresenter(this, this);
        borrowAccidentWillPresenter.getBorrowAccidentWill(activityName, taskId, Constant.HUIQIAN_DEFID);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_huiqian_will;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.tvData, R.id.btnUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvData:
                break;
            case R.id.btnUp:
                if (etHuiQian.getVisibility() == View.VISIBLE) {
                    if (etHuiQian.getText().toString().equals("")) {
                        Toast.makeText(this, "请填写意见", Toast.LENGTH_SHORT).show();
                    } else {
                        if (destTypeList.size() != 0) {
                            if (destTypeList.size() == 1) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        destType = destTypeList.get(0).getDestType();
                                        destName = destTypeList.get(0).getDestination();
                                        if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                            normalPresenter.getNormalPerson(taskId, destName, "false");
                                        } else if (destType.indexOf("end") == -1) {
                                            noEndPersenter.getNoEndPerson(taskId, destName, "false");
                                        } else {
                                            noHandlerPresenter.getNoHandlerPerson(taskId);
                                        }
                                        signaName = destTypeList.get(0).getName();
                                    }
                                }).start();
                            } else {
                                for (int i = 0; i < destTypeList.size(); i++) {
                                    namelist.add(destTypeList.get(i).getDestination());
                                }
                                MyAlertDialog.MyListAlertDialog(this, namelist, new AlertDialogCallBackP() {
                                    @Override
                                    public void oneselect(final String data) {
                                        destName = data;
                                        for (int i = 0; i < destTypeList.size(); i++) {
                                            if (destName.equals(destTypeList.get(i).getDestination())) {
                                                signaName = destTypeList.get(i).getName();
                                                destType = destTypeList.get(i).getDestType();
                                            }
                                        }
                                        if (destType.equals("decision") || destType.equals("fork") || destType.equals("join")) {
                                            normalPresenter.getNormalPerson(taskId, destName, "false");
                                        } else if (destType.indexOf("end") == -1) {
                                            noEndPersenter.getNoEndPerson(taskId, destName, "false");
                                        } else {
                                            noHandlerPresenter.getNoHandlerPerson(taskId);
                                        }
                                    }

                                    @Override
                                    public void select(List<String> list) {

                                    }

                                    @Override
                                    public void confirm() {

                                    }

                                    @Override
                                    public void cancel() {

                                    }
                                });
                            }
                        } else {
                            Toast.makeText(this, "审批人为空", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void setBorrowAccidentWill(HuiQianWill s) {
        if (s != null) {
            tvTitle.setText(s.getMainform().get(0).getTitle());
            tvTheme.setText(s.getMainform().get(0).getThemeWord());
            tvContent.setText(s.getMainform().get(0).getContent());
            tvData.setText(s.getMainform().get(0).getFile());
            tv1.setText(s.getMainform().get(0).getHao1());
            tv2.setText(s.getMainform().get(0).getHao2());
            tv3.setText(s.getMainform().get(0).getSecret());
            tv4.setText(s.getMainform().get(0).getUrgency());
            tvQianFa.setText(s.getMainform().get(0).getIssue());
            tvZhuSong.setText(s.getMainform().get(0).getDelivery());
            tvCaoSong.setText(s.getMainform().get(0).getCopy());
            tvDepartment.setText(s.getMainform().get(0).getDraftingDep());
            tvNiGao.setText(s.getMainform().get(0).getDraft());
            tvHeGao.setText(s.getMainform().get(0).getNuclear() + "");
            tvYinShua.setText(s.getMainform().get(0).getPrinting());
            tvJiaoDui.setText(s.getMainform().get(0).getProofreading());
            tvFenShu.setText(s.getMainform().get(0).getNums());
            String huiqian = s.getMainform().get(0).getSign();
            mainId = String.valueOf(s.getMainform().get(0).getMainId());

            String move = s.getFormRights();
            try {
                JSONObject jsonObject = new JSONObject(move);
                hqMove = jsonObject.getString("sign");
                if (hqMove.equals("2")) {
                    tvHuiQian.setVisibility(View.GONE);
                    etHuiQian.setVisibility(View.VISIBLE);
                    if (huiqian != null && huiqian.length() != 0) {
                        etHuiQian.setText(new SplitData().getStringData(huiqian));
                    }
                } else {
                    tvHuiQian.setVisibility(View.VISIBLE);
                    etHuiQian.setVisibility(View.GONE);
                    if (huiqian != null && huiqian.length() != 0) {
                        tvHuiQian.setText(new SplitData().getStringData(huiqian));
                    }
                }
                for (int i = 0; i < s.getTrans().size(); i++) {
                    destTypeList.add(s.getTrans().get(i));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setBorrowAccidentWillMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 正常一级检查人
     *
     * @param s
     */
    @Override
    public void setNormalPerson(NormalPerson s) {
        if (s.getData() != null) {
            leaderName = s.getData().get(0).getUserNames();
            leaderCode = s.getData().get(0).getUserCodes();
            bigNametemp = leaderName.split(",");
            bigCodetemp = leaderCode.split(",");
            setDialog();
        }
    }

    @Override
    public void setNormalPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 不包含end的一级检查人
     *
     * @param s
     */
    @Override
    public void setNoEndPerson(NoEndPerson s) {
        if (s.getData() != null) {
            leaderName = s.getData().get(0).getUserNames();
            leaderCode = s.getData().get(0).getUserCodes();
            bigNametemp = leaderName.split(",");
            bigCodetemp = leaderCode.split(",");
            setDialog();
        }
    }

    @Override
    public void setNoEndPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 不让其他人操作的一级检查人
     *
     * @param s
     */
    @Override
    public void setNoHandlerPerson(NoHandlerPerson s) {

    }

    @Override
    public void setNoHandlerPersonMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    /**
     * 待办提交
     *
     * @param s
     */
    @Override
    public void setWillDo(WillDoUp s) {
        if (s.isSuccess()){
            Toast.makeText(this, "数据提交成功", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setWillDoMessage(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    private void setDialog() {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final AlertDialog alertDialog3 = alertDialogBuilder.create();
//                alertDialogBuilder.setTitle("java EE 常用框架");
        // 参数介绍
        // 第一个参数：弹出框的信息集合，一般为字符串集合
        // 第二个参数：被默认选中的，一个布尔类型的数组
        // 第三个参数：勾选事件监听
        final boolean[] checkedItems = new boolean[bigNametemp.length+1];
        for (int i = 0; i < bigNametemp.length; i++) {
            checkedItems[i] = false;
        }
        new AlertDialog.Builder(this)
                .setTitle("选择时间")//标题栏
                .setMultiChoiceItems(bigNametemp, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        // dialog：不常使用，弹出框接口
                        // which：勾选或取消的是第几个
                        // isChecked：是否勾选
                        if (isChecked) {
                            // 选中
                            checkedItems[which] = isChecked;
                        } else {
                            // 取消选中
                            checkedItems[which] = isChecked;
                        }
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                //TODO 业务逻辑代码
                for (int i = 0; i < checkedItems.length; i++) {
                    if (checkedItems[i]) {
                        selectList.add(bigCodetemp[i]);
                    }
                }
                getListData();
                setData();
                // 关闭提示框
                alertDialog3.dismiss();
                map.put("flowAssignId", destName + "|" + uId);
                willDoPresenter.getWillDo(map);
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO 业务逻辑代码

                // 关闭提示框
                alertDialog3.dismiss();
            }
        }).show();
    }

    private String getListData() {
        if (selectList.size() == 1) {
            //uName = backlist.get(0).getActivityName();
            uId = selectList.get(0);
        }
        if (selectList.size() > 1) {
            for (int i = 1; i < selectList.size(); i++) {
                if (i < selectList.size() - 1) {
                    uId = uId + selectList.get(i) + ",";
                } else {
                    uId = uId + selectList.get(i);
                }
            }
            uId = selectList.get(0) + "," + uId;
        }
        return uId;
    }

    private void setData() {
        map.put("defId", Constant.HUIQIAN_DEFID);
        map.put("startFlow", "true");
        map.put("formDefId", Constant.HUIQIAN_FORMDEFIS);
        map.put("depName", tvDepartment.getText().toString());
        map.put("hao1", tv1.getText().toString());
        map.put("hao2", tv2.getText().toString());
        map.put("urgency", tv3.getText().toString());
        map.put("secret", tv4.getText().toString());
        map.put("Issue", tvQianFa.getText().toString());
        map.put("delivery", tvZhuSong.getText().toString());
        map.put("copy", tvCaoSong.getText().toString());
        map.put("draftingDep", tvDepartment.getText().toString());
        map.put("draft", tvNiGao.getText().toString());
        map.put("nuclear", tvHeGao.getText().toString());
        map.put("printing", tvYinShua.getText().toString());
        map.put("proofreading", tvJiaoDui.getText().toString());
        map.put("nums", tvFenShu.getText().toString());
        map.put("file", tvData.getText().toString());
        map.put("themeWord", tvTheme.getText().toString());
        map.put("title", tvTitle.getText().toString());
        map.put("content", tvContent.getText().toString());
        map.put("mainId", mainId);
        map.put("taskId", taskId);
        if (tvHuiQian.getVisibility() == View.VISIBLE) {
            map.put("sign", new SplitData().SplitUpData(tvHuiQian.getText().toString()));
            map.put("comments", tvHuiQian.getText().toString());
        } else {
            map.put("sign", new SplitData().SplitUpData(etHuiQian.getText().toString()));
            map.put("comments", tvHuiQian.getText().toString());
        }
    }

}
