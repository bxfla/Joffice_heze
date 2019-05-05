package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.module.TwoContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class TwoPresenter implements TwoContract.presenter {

    private Context context;
    private TwoContract.View view;

    public TwoPresenter(Context context, TwoContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getTwoPerson(String defId,String activityName) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getTwoPerson(defId,activityName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<TwoPerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(TwoPerson twoPerson) throws Exception {
                        view.setTwoPerson(twoPerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setTwoPersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
