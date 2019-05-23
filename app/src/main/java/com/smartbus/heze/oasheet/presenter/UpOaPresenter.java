package com.smartbus.heze.oasheet.presenter;

import android.content.Context;

import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oasheet.module.UpOaContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static android.R.attr.type;


/**
 * @description:
 */

public class UpOaPresenter implements UpOaContract.presenter {

    private Context context;
    private UpOaContract.View view;

    public UpOaPresenter(Context context, UpOaContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getUpOa(String flag,String no,String overDepName,String overDepId,String sendDepName
            ,String sendDepId,String sendPerson,String upDate,String upTime,String endTime,String title
            ,String type,String content,String fileName) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getUpOa(flag,no,overDepName,overDepId,sendDepName,sendDepId
                ,sendPerson,upDate,upTime,endTime,title,type,content,fileName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<UpData>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(UpData s) throws Exception {
                        if (s.isSuccess()){
                            view.setUpOa(s);
                        }else {
                            view.setUpOaMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setUpOaMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
