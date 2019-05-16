package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.module.CheckWorkContract;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class CheckWorkPresenter implements CheckWorkContract.presenter {

    private Context context;
    private CheckWorkContract.View view;

    public CheckWorkPresenter(Context context, CheckWorkContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getCheckWork(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCheckWork(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InitBackData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(InitBackData s) throws Exception {
                        if (s.isSuccess()){
                            view.setCheckWork(s);
                        }else {
                            view.setCheckWorkMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCheckWorkMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
