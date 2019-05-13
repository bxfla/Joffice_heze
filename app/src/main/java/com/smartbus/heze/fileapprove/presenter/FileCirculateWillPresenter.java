package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.FileCirculateWill;
import com.smartbus.heze.fileapprove.module.FileCirculateWillContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class FileCirculateWillPresenter implements FileCirculateWillContract.presenter {

    private Context context;
    private FileCirculateWillContract.View view;

    public FileCirculateWillPresenter(Context context, FileCirculateWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getFileCirculateWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getFileCirculate(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<FileCirculateWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(FileCirculateWill s) throws Exception {
                        view.setFileCirculateWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setFileCirculateWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
