package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.module.UPYSDContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UPYSDPresenter implements UPYSDContract.presenter {

    private Context context;
    private UPYSDContract.View view;

    public UPYSDPresenter(Context context, UPYSDContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUPYSD(Map<String,String> map) {
        RetrofitUtil.getInstance().initRetrofitMain().getUpysd(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<String>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(String s) throws Exception {
                        view.setUPYSD(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUPYSDMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
