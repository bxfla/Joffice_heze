package com.smartbus.heze.checkup.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.SafeItem;
import com.smartbus.heze.checkup.module.SafeItemContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class SafeItemPresenter implements SafeItemContract.presenter {

    private Context context;
    private SafeItemContract.View view;

    public SafeItemPresenter(Context context, SafeItemContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSafeItem() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getSafeItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<SafeItem>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(SafeItem s) throws Exception {
                        view.setSafeItem(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSafeItemMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
