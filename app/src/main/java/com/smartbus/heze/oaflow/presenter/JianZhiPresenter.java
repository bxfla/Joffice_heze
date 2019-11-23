package com.smartbus.heze.oaflow.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.JianZhi;
import com.smartbus.heze.oaflow.module.JianZhiContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class JianZhiPresenter implements JianZhiContract.presenter {

    private Context context;
    private JianZhiContract.View view;

    public JianZhiPresenter(Context context, JianZhiContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getJianZhi(String name, String userCode, String adress, String phone, String comp,
                           String depId, String line, String beizhu) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getJianZhi(name,userCode,adress,phone,comp
                                    ,depId,line,beizhu).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<JianZhi>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(JianZhi s) throws Exception {
                        if (s.getSuccess().equals("true")){
                            view.setJianZhi(s);
                        }else {
                            view.setJianZhiMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setJianZhiMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
