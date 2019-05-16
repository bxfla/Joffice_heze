package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.module.AtWorkContract;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AtWorkPresenter implements AtWorkContract.presenter {

    private Context context;
    private AtWorkContract.View view;

    public AtWorkPresenter(Context context, AtWorkContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAtWork(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getAtWork(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InitBackData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(InitBackData s) throws Exception {
                        if (s.isSuccess()){
                            view.setAtWork(s);
                        }else {
                            view.setAtWorkMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAtWorkMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
