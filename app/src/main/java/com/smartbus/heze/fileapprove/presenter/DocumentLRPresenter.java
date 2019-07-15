package com.smartbus.heze.fileapprove.presenter;

import android.content.Context;

import com.smartbus.heze.fileapprove.bean.LZLR;
import com.smartbus.heze.fileapprove.module.DocumentLRContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;
import com.smartbus.heze.oaflow.bean.CheckType;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class DocumentLRPresenter implements DocumentLRContract.presenter {

    private Context context;
    private DocumentLRContract.View view;

    public DocumentLRPresenter(Context context, DocumentLRContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getDocumentLR(Map<String, String> map) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getdocumentlr(map).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<LZLR>(context, MainUtil.upData) {
                    @Override
                    protected void onSuccees(LZLR s) throws Exception {
                        if (s.isSuccess()){
                            view.setDocumentLR(s);
                        }else {
                            view.setDocumentLRMessage("");
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setDocumentLRMessage("失败了----->" + e.getMessage());
                    }
                });
    }

    @Override
    public void getCheckTypeLR(String runId,String vocationId,String destName,String mycomments,String nibanyj
            ,String ldyj,String chengbanjg) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getCheckTypelz(runId,vocationId, destName
                , mycomments, nibanyj, ldyj, chengbanjg).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<CheckType>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(CheckType s) throws Exception {
                        view.setCheckTypeLR(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setCheckTypeLRMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
