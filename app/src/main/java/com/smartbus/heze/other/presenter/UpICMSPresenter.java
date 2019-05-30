package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.module.UpICMSContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class UpICMSPresenter implements UpICMSContract.presenter {

    private Context context;
    private UpICMSContract.View view;

    public UpICMSPresenter(Context context, UpICMSContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUpICMS(String userName,String driverName,String driverCode,String lineCode
        ,String cardId,String cardType,String money,String reasons,String date,String memo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpData(userName,driverName,driverCode
            ,lineCode,cardId,cardType,money,reasons,date,memo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UpData t) throws Exception {
                        view.setUpICMS(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUpICMSMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
