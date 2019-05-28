package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.exam.module.LearnLeftContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class LearnLeftPresenter implements LearnLeftContract.presenter {

    private Context context;
    private LearnLeftContract.View view;

    public LearnLeftPresenter(Context context, LearnLeftContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLearnLeft() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getLearnLeft().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LearnLeft>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(LearnLeft s) throws Exception {
                        view.setLearnLeft(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLearnLeftMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
