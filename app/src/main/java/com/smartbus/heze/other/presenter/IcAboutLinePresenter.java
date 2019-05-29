package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.bean.IcAboutLine;
import com.smartbus.heze.other.module.IcAboutLineContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class IcAboutLinePresenter implements IcAboutLineContract.presenter {

    private Context context;
    private IcAboutLineContract.View view;

    public IcAboutLinePresenter(Context context, IcAboutLineContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getIcAboutLine(String driverCode) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getIcAboutLine(driverCode).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<IcAboutLine>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(IcAboutLine t) throws Exception {
                        view.setIcAboutLine(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setIcAboutLineMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
