package com.smartbus.heze.exam.presenter;

import android.content.Context;

import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.exam.module.ExamationDataContract;
import com.smartbus.heze.http.base.BaseObserverNoEntry;
import com.smartbus.heze.http.utils.MainUtil;
import com.smartbus.heze.http.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * @description:
 */

public class ExamationDataPresenter implements ExamationDataContract.presenter {

    private Context context;
    private ExamationDataContract.View view;

    public ExamationDataPresenter(Context context, ExamationDataContract.View view) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void getExamationData(String id, String type, String userName) {
        RetrofitUtil.getInstance().initRetrofitSetSession().getExaminationData(id,type,userName).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserverNoEntry<ExaminationData>(context, MainUtil.getData) {
                    @Override
                    protected void onSuccees(ExaminationData s) throws Exception {
                        view.setExamationData(s);
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                        view.setExamationDataMessage("失败了----->" + e.getMessage());
                    }
                });
    }
}
