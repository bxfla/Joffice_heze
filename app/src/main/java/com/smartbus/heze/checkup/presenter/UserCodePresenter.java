package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UserCode;
import com.smartbus.heze.checkup.module.UserCodeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UserCodePresenter implements UserCodeContract.presenter {

    private Context context;
    private UserCodeContract.View view;

    public UserCodePresenter(Context context, UserCodeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUserCode() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUserCode().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UserCode>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UserCode s) throws Exception {
                        view.setUserCode(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUserCodeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
