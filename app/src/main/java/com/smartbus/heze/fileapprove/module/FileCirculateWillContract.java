package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.FileCirculateWill;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface FileCirculateWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setFileCirculateWill(FileCirculateWill s);
        void setFileCirculateWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getFileCirculateWill(String activityName, String taskId, String defId);
    }
}
