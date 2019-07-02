package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.SendNum;
import com.smartbus.heze.exam.module.SendNumContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class SendNumPresenter implements SendNumContract.presenter {

    private Context context;
    private SendNumContract.View view;

    public SendNumPresenter(Context context, SendNumContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSendNum(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getsendnum(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<SendNum>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(SendNum s) throws Exception {
                        view.setSendNum(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSendNumMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
