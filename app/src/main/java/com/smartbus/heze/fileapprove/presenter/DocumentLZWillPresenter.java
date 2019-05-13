package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.DocumentLZWill;
import com.smartbus.heze.fileapprove.module.DocumentLZWillContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DocumentLZWillPresenter implements DocumentLZWillContract.presenter {

    private Context context;
    private DocumentLZWillContract.View view;

    public DocumentLZWillPresenter(Context context, DocumentLZWillContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDocumentLZWill(String activityName, String taskId, String defId) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getWillDocumentLZ(activityName,taskId,defId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<DocumentLZWill>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(DocumentLZWill s) throws Exception {
                        view.setDocumentLZWill(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDocumentLZWillMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
