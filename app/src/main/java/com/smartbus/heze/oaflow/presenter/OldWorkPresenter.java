package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.module.OldWorkContract;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class OldWorkPresenter implements OldWorkContract.presenter {

    private Context context;
    private OldWorkContract.View view;

    public OldWorkPresenter(Context context, OldWorkContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOldWork(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOldWork(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<InitBackData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(InitBackData s) throws Exception {
                        if (s.isSuccess()){
                            view.setOldWork(s);
                        }else {
                            view.setOldWorkMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOldWorkMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
