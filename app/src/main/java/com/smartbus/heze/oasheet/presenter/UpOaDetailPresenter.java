package com.smartbus.heze.oasheet.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oasheet.module.UpOaDetailContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class UpOaDetailPresenter implements UpOaDetailContract.presenter {

    private Context context;
    private UpOaDetailContract.View view;

    public UpOaDetailPresenter(Context context, UpOaDetailContract.View view) {
        this.context = context;
        this.view = view;
    }


    @Override
    public void getUpOaDetail(String flag, String status, String clResult, String clPhoto, String workId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpOaDetail(flag,status,clResult,clPhoto,workId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(UpData s) throws Exception {
                        if (s.isSuccess()){
                            view.setUpOaDetail(s);
                        }else {
                            view.setUpOaDetailMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUpOaDetailMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
