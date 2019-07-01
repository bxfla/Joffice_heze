package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.InComeRank;
import com.smartbus.heze.exam.module.InComeRankContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class InComeRankPresenter implements InComeRankContract.presenter {

    private Context context;
    private InComeRankContract.View view;

    public InComeRankPresenter(Context context, InComeRankContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getInComeRank(String startTime,String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getInComeRank(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InComeRank>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(InComeRank s) throws Exception {
                        view.setInComeRank(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setInComeRankMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
