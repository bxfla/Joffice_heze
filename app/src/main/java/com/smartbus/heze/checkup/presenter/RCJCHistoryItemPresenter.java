package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.RCJCHistoryItem;
import com.smartbus.heze.checkup.module.RCJCHistoryItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class RCJCHistoryItemPresenter implements RCJCHistoryItemContract.presenter {

    private Context context;
    private RCJCHistoryItemContract.View view;

    public RCJCHistoryItemPresenter(Context context, RCJCHistoryItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getRCJCHistoryItem(String id) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getRCJCHistoryItem(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<RCJCHistoryItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(RCJCHistoryItem s) throws Exception {
                        view.setRCJCHistoryItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setRCJCHistoryItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
