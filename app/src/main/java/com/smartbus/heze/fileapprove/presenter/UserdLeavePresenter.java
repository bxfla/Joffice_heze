package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.fileapprove.module.UserdLeaveContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UserdLeavePresenter implements UserdLeaveContract.presenter {

    private Context context;
    private UserdLeaveContract.View view;

    public UserdLeavePresenter(Context context, UserdLeaveContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUserdLeave(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUserdLeave(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InitBackData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(InitBackData s) throws Exception {
                        if (s.isSuccess()){
                            view.setUserdLeave(s);
                        }else {
                            view.setUserdLeaveMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUserdLeaveMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
