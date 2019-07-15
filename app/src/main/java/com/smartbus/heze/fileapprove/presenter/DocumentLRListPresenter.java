package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.DocumentLZList;
import com.smartbus.heze.fileapprove.module.DocumentLRListContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DocumentLRListPresenter implements DocumentLRListContract.presenter {

    private Context context;
    private DocumentLRListContract.View view;

    public DocumentLRListPresenter(Context context, DocumentLRListContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDocumentLRList(String startTime, String endTime) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getDocumentLzList(startTime,endTime).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<DocumentLZList>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(DocumentLZList s) throws Exception {
                        view.setDocumentLRList(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDocumentLRListMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
