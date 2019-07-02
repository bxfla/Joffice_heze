package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.StartContent;
import com.smartbus.heze.exam.module.StartContentContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class StartContentPresenter implements StartContentContract.presenter {

    private Context context;
    private StartContentContract.View view;

    public StartContentPresenter(Context context, StartContentContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getStartContent(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getstartcontent(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<StartContent>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(StartContent s) throws Exception {
                        view.setStartContent(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setStartContentMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
