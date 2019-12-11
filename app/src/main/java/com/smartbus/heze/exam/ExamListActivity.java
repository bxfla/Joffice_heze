package com.smartbus.heze.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.smartbus.heze.R;
import com.smartbus.heze.exam.activity.CarVehicleActivity;
import com.smartbus.heze.exam.activity.ClassMileageActivity;
import com.smartbus.heze.exam.activity.ComparListActivity;
import com.smartbus.heze.exam.activity.ComplaintFinesActivity;
import com.smartbus.heze.exam.activity.DayComparActivity;
import com.smartbus.heze.exam.activity.FoundActivity;
import com.smartbus.heze.exam.activity.GpsMileageActivity;
import com.smartbus.heze.exam.activity.InComeRankActivity;
import com.smartbus.heze.exam.activity.LearningLeftActivity;
import com.smartbus.heze.exam.activity.MaintainActivity;
import com.smartbus.heze.exam.activity.OilConsumptionActivity;
import com.smartbus.heze.exam.activity.OnLineListActivity;
import com.smartbus.heze.exam.activity.RewardsPenaltiesActivity;
import com.smartbus.heze.exam.activity.SafeMileageActivity;
import com.smartbus.heze.exam.activity.SendNumActivity;
import com.smartbus.heze.exam.activity.SimulateListActivity;
import com.smartbus.heze.exam.activity.StartContentActivity;
import com.smartbus.heze.exam.activity.StartDriverActivity;
import com.smartbus.heze.http.base.BaseActivity;
import com.smartbus.heze.http.views.Header;
import com.smartbus.heze.other.activity.JianZhiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExamListActivity extends BaseActivity {

    @BindView(R.id.header)
    Header header;
    @BindView(R.id.rb1)
    RadioButton rb1;
    @BindView(R.id.rb2)
    RadioButton rb2;
    @BindView(R.id.rb3)
    RadioButton rb3;
    @BindView(R.id.rb4)
    RadioButton rb4;
    @BindView(R.id.rb5)
    RadioButton rb5;
    @BindView(R.id.rb6)
    RadioButton rb6;
    @BindView(R.id.rb7)
    RadioButton rb7;
    @BindView(R.id.rb8)
    RadioButton rb8;
    @BindView(R.id.rb9)
    RadioButton rb9;
    @BindView(R.id.rb10)
    RadioButton rb10;
    @BindView(R.id.rb11)
    RadioButton rb11;
    @BindView(R.id.rb12)
    RadioButton rb12;
    @BindView(R.id.rb13)
    RadioButton rb13;
    @BindView(R.id.rb14)
    RadioButton rb14;
    @BindView(R.id.rb15)
    RadioButton rb15;
    @BindView(R.id.rb16)
    RadioButton rb16;
    @BindView(R.id.rb17)
    RadioButton rb17;
    @BindView(R.id.rb18)
    RadioButton rb18;
    @BindView(R.id.rb19)
    RadioButton rb19;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_exam_list;
    }

    @Override
    protected boolean isHasHeader() {
        return true;
    }

    @Override
    protected void rightClient() {

    }

    @OnClick({R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5, R.id.rb6, R.id.rb7, R.id.rb8
            , R.id.rb9, R.id.rb10, R.id.rb11, R.id.rb12, R.id.rb13, R.id.rb14, R.id.rb15
            , R.id.rb16, R.id.rb17, R.id.rb18, R.id.rb19})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rb1:
                intent = new Intent(this, LearningLeftActivity.class);
                startActivity(intent);
                break;
            case R.id.rb2:
                intent = new Intent(this, OnLineListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb3:
                intent = new Intent(this, FoundActivity.class);
                startActivity(intent);
                break;
            case R.id.rb4:
                intent = new Intent(this, SimulateListActivity.class);
                startActivity(intent);
                break;
            case R.id.rb5:
                intent = new Intent(this, InComeRankActivity.class);
                startActivity(intent);
                break;
            case R.id.rb6:
                intent = new Intent(this, ClassMileageActivity.class);
                startActivity(intent);
                break;
            case R.id.rb7:
                intent = new Intent(this, RewardsPenaltiesActivity.class);
                startActivity(intent);
                break;
            case R.id.rb8:
                intent = new Intent(this, OilConsumptionActivity.class);
                startActivity(intent);
                break;
            case R.id.rb9:
                intent = new Intent(this, MaintainActivity.class);
                startActivity(intent);
                break;
            case R.id.rb10:
                intent = new Intent(this, SafeMileageActivity.class);
                startActivity(intent);
                break;
            case R.id.rb11:
                intent = new Intent(this, ComplaintFinesActivity.class);
                startActivity(intent);
                break;
            case R.id.rb12:
                intent = new Intent(this, SendNumActivity.class);
                startActivity(intent);
                break;
            case R.id.rb13:
                intent = new Intent(this, StartContentActivity.class);
                startActivity(intent);
                break;
            case R.id.rb14:
                intent = new Intent(this, StartDriverActivity.class);
                startActivity(intent);
                break;
            case R.id.rb15:
                intent = new Intent(this, GpsMileageActivity.class);
                startActivity(intent);
                break;
            case R.id.rb16:
                intent = new Intent(this, CarVehicleActivity.class);
                startActivity(intent);
                break;
            case R.id.rb17:
                intent = new Intent(this, DayComparActivity.class);
                startActivity(intent);
                break;
            case R.id.rb18:
                intent = new Intent(this, JianZhiActivity.class);
                startActivity(intent);
                break;
            case R.id.rb19:
                intent = new Intent(this, ComparListActivity.class);
                startActivity(intent);
                break;
        }
    }
}
