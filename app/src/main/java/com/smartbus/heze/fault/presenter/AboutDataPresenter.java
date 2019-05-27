package com.smartbus.heze.fault.presenter;

import android.content.Context;

import com.smartbus.heze.fault.bean.AboutData;
import com.smartbus.heze.fault.module.AboutDataContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AboutDataPresenter implements AboutDataContract.presenter {

    private Context context;
    private AboutDataContract.View view;

    public AboutDataPresenter(Context context, AboutDataContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAboutData(String busCode, String rq, String sj) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getAboutData(busCode,rq,sj).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<AboutData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(AboutData s) throws Exception {
                        view.setAboutData(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAboutData("失败了----->" + e.getMessage());
                    }
                });
    }
}
