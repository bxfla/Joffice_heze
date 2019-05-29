package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.exam.bean.OnLineUp;
import com.smartbus.heze.exam.module.OnLineUpContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OnLineUpPresenter implements OnLineUpContract.presenter {

    private Context context;
    private OnLineUpContract.View view;

    public OnLineUpPresenter(Context context, OnLineUpContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOnLineUp(String userName, String type, HashMap<String,ExaminationData.DataBean> hasMap) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOnLineUp(userName,type,hasMap).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OnLineUp>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OnLineUp s) throws Exception {
                        view.setOnLineUp(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOnLineUpMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
