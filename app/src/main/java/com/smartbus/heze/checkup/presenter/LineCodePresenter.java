package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.LineCode;
import com.smartbus.heze.checkup.module.LineCodeContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class LineCodePresenter implements LineCodeContract.presenter {

    private Context context;
    private LineCodeContract.View view;

    public LineCodePresenter(Context context, LineCodeContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLineCode() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getLineCode().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LineCode>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(LineCode s) throws Exception {
                        view.setLineCode(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLineCodeMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
