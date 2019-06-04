package com.smartbus.heze.main.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.main.bean.OaWillDo;
import com.smartbus.heze.main.module.OaWillListContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class OaWillListPresenter implements OaWillListContract.presenter {

    private Context context;
    private OaWillListContract.View view;

    public OaWillListPresenter(Context context, OaWillListContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getOaWillList(String userName,String type,String type1,int start,int limit) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getOaWillDo(userName,type,type1,start,limit).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<OaWillDo>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(OaWillDo t) throws Exception {
                        view.setOaWillList(t);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setOaWillListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
