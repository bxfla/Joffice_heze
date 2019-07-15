package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.DocumentLZList;
import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DocumentLRListContract {
    interface View extends BaseDSixView<presenter> {
        //预算单
        void setDocumentLRList(DocumentLZList s);
        void setDocumentLRListMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDocumentLRList(String startTime,String endTime);
    }
}
