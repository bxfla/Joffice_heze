package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/9.
 */

public class NoHandlerPerson implements Serializable {

    /**
     * success : true
     * isSubFlow : false
     */

    private boolean success;
    private boolean isSubFlow;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isIsSubFlow() {
        return isSubFlow;
    }

    public void setIsSubFlow(boolean isSubFlow) {
        this.isSubFlow = isSubFlow;
    }
}
