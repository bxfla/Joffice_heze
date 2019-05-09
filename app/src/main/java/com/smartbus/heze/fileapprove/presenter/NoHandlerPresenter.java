package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.module.NoHandlerContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class NoHandlerPresenter implements NoHandlerContract.presenter {

    private Context context;
    private NoHandlerContract.View view;

    public NoHandlerPresenter(Context context, NoHandlerContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getNoHandlerPerson(String taskId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getNoHandlerPerson(taskId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<NoHandlerPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(NoHandlerPerson s) throws Exception {
                        view.setNoHandlerPerson(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setNoHandlerPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
