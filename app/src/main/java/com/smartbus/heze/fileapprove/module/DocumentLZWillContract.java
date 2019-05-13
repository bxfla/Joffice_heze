package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.DocumentLZWill;
import com.smartbus.heze.http.base.BaseDView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DocumentLZWillContract {
    interface View extends BaseDView<presenter> {
        //预算单
        void setDocumentLZWill(DocumentLZWill s);
        void setDocumentLZWillMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDocumentLZWill(String activityName, String taskId, String defId);
    }
}
