package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.exam.bean.LearnRight;
import com.smartbus.heze.exam.module.LearnLeftContract;
import com.smartbus.heze.exam.module.LearnRightContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class LearnRightPresenter implements LearnRightContract.presenter {

    private Context context;
    private LearnRightContract.View view;

    public LearnRightPresenter(Context context, LearnRightContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getLearnRight(String type) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getLearnRight(type).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LearnRight>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(LearnRight s) throws Exception {
                        view.setLearnRight(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setLearnRightMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
