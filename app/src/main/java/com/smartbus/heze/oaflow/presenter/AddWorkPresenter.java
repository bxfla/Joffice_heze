package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.module.AddWorkContract;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class AddWorkPresenter implements AddWorkContract.presenter {

    private Context context;
    private AddWorkContract.View view;

    public AddWorkPresenter(Context context, AddWorkContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getAddWork(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getAddWork(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InitBackData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(InitBackData s) throws Exception {
                        if (s.isSuccess()){
                            view.setAddWork(s);
                        }else {
                            view.setAddWorkMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setAddWorkMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
