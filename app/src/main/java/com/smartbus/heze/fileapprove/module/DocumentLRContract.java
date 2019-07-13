package com.smartbus.heze.fileapprove.module;

import com.smartbus.heze.fileapprove.bean.LZLR;
import com.smartbus.heze.http.base.BaseDSixView;
import com.smartbus.heze.http.base.BasePresenter;
import com.smartbus.heze.oaflow.bean.CheckType;

import java.util.Map;

/**
 * Created by Administrator on 2019/4/11.
 */

public interface DocumentLRContract {
    interface View extends BaseDSixView<presenter> {
        void setDocumentLR(LZLR s);
        void setDocumentLRMessage(String s);

        void setCheckTypeLR(CheckType s);
        void setCheckTypeLRMessage(String s);
    }

    interface presenter extends BasePresenter {
        void getDocumentLR(Map<String, String> map);

        void getCheckTypeLR(String runId,String vocationId);
    }
}
