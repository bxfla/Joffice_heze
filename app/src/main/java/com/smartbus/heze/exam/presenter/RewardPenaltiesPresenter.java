package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.RewardPenalties;
import com.smartbus.heze.exam.module.RewardPenaltiesContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class RewardPenaltiesPresenter implements RewardPenaltiesContract.presenter {

    private Context context;
    private RewardPenaltiesContract.View view;

    public RewardPenaltiesPresenter(Context context, RewardPenaltiesContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getRewardPenalties(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getrewardspenalties(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<RewardPenalties>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(RewardPenalties s) throws Exception {
                        view.setRewardPenalties(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setRewardPenaltiesMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
