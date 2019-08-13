package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.DayCompare;
import com.smartbus.heze.exam.module.DayCompareItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DayCompareItemPresenter implements DayCompareItemContract.presenter {

    private Context context;
    private DayCompareItemContract.View view;

    public DayCompareItemPresenter(Context context, DayCompareItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDayCompareItem(String categoryCode,String tag) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getDayCompareItem(categoryCode,tag).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<DayCompare>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(DayCompare s) throws Exception {
                        view.setDayCompareItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDayCompareItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
