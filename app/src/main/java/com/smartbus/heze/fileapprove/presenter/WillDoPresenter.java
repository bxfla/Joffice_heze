package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.module.WillDoContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class WillDoPresenter implements WillDoContract.presenter {

    private Context context;
    private WillDoContract.View view;

    public WillDoPresenter(Context context, WillDoContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getWillDo(Map<String,String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDoUp(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<WillDoUp>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(WillDoUp s) throws Exception {
                        view.setWillDo(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setWillDoMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
