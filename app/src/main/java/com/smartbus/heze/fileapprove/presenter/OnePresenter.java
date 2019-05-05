package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.module.OneContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OnePresenter implements OneContract.presenter {

    private Context context;
    private OneContract.View view;

    public OnePresenter(Context context, OneContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOnePerson(String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOnePerson(defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OnePerson>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OnePerson onePerson) throws Exception {
                        view.setOnePerson(onePerson);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOnePersonMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
