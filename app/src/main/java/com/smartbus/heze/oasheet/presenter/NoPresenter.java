package com.smartbus.heze.oasheet.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oasheet.bean.OANO;
import com.smartbus.heze.oasheet.module.NoContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class NoPresenter implements NoContract.presenter {

    private Context context;
    private NoContract.View view;

    public NoPresenter(Context context, NoContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getNo(String alias) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOaNo(alias).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OANO>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(OANO s) throws Exception {
                        if (s.isSuccess()){
                            view.setNo(s);
                        }else {
                            view.setNoMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setNoMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
