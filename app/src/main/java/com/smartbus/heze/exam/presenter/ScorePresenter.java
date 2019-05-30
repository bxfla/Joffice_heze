package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.Score;
import com.smartbus.heze.exam.module.ScoreContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class ScorePresenter implements ScoreContract.presenter {

    private Context context;
    private ScoreContract.View view;

    public ScorePresenter(Context context, ScoreContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getScore(String userName) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getScore(userName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Score>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Score s) throws Exception {
                        view.setScore(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setScoreMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
