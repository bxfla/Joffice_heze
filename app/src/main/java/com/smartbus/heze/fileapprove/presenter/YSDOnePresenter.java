package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.module.YSDOneContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class YSDOnePresenter implements YSDOneContract.presenter {

    private Context context;
    private YSDOneContract.View view;

    public YSDOnePresenter(Context context, YSDOneContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getYSD(String defId) {
        RetrofitUtil.getInstance().initRetrofitMain().getOnePerson(defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OnePerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OnePerson onePerson) throws Exception {
                        view.setYSD(onePerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setYSDMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
