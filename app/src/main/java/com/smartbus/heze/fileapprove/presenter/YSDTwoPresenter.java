package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.YSDTwoContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class YSDTwoPresenter implements YSDTwoContract.presenter {

    private Context context;
    private YSDTwoContract.View view;

    public YSDTwoPresenter(Context context, YSDTwoContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getYSDTwo(String defId,String activityName) {
        RetrofitUtil.getInstance().initRetrofitMain().getTwoPerson(defId,activityName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<TwoPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(TwoPerson twoPerson) throws Exception {
                        view.setYSDTwo(twoPerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setYSDTwoMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
