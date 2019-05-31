package com.smartbus.heze.other.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.other.module.SaferUpContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Field;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class SaferUpPresenter implements SaferUpContract.presenter {

    private Context context;
    private SaferUpContract.View view;

    public SaferUpPresenter(Context context, SaferUpContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getSaferUp(String userName, String apPlace,String apType,String apDate
            , String apReason,String apPhoto) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getSaferUpData(userName,apPlace,apType
                ,apDate,apReason,apPhoto).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(UpData t) throws Exception {
                        view.setSaferUp(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setSaferUpMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
