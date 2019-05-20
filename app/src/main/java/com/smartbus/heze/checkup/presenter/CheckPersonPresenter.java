package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.CheckPerson;
import com.smartbus.heze.checkup.module.CheckPersonContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CheckPersonPresenter implements CheckPersonContract.presenter {

    private Context context;
    private CheckPersonContract.View view;

    public CheckPersonPresenter(Context context, CheckPersonContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCheckPerson() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCheckPerson().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckPerson s) throws Exception {
                        view.setCheckPerson(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCheckPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
