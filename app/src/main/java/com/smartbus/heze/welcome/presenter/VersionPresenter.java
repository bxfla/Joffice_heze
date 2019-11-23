package com.smartbus.heze.welcome.presenter;

import android.content.Context;

import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.welcome.bean.Version;
import com.smartbus.heze.welcome.module.VersionContract;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class VersionPresenter implements VersionContract.presenter {

    private Context context;
    private VersionContract.View view;

    public VersionPresenter(Context context, VersionContract.View view) {
        this.context = context;
        this.view = view;
    }

    /**
     * 获取版本号
     *
     */

    @Override
    public void getVersion() {
        RetrofitUtil.getInstance().initRetrofitSetSession().getVersion().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<Version>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(Version t) throws Exception {
                        if (t.isSuccess()){
                            view.setVersion(t);
                        }else {
                            view.setVersionMessage("失败了----->" + "");
                        }
                    }
                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setVersionMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
