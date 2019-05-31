package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.module.LostUpContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class LostUpPresenter implements LostUpContract.presenter {

    private Context context;
    private LostUpContract.View view;

    public LostUpPresenter(Context context, LostUpContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLostUp(String userName, String createDate, String createTime, String lineCode
            , String driverName, String receiveDate, String receiveTime, String ownerName
            , String ownerPhone, String returnMode, String ownerCertificates, String returnStatus
            , String situation, String remarks, String photo) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getLostUpData(userName,createDate,createTime
                ,lineCode,driverName,receiveDate,receiveTime,ownerName,ownerPhone,returnMode
                ,ownerCertificates,returnStatus,situation,remarks,photo).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UpData t) throws Exception {
                        view.setLostUp(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLostUpMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
