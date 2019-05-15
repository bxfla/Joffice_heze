package com.smartbus.heze.oaflow.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/15.
 */

public class CheckType implements Serializable {

    /**
     * success : true
     */

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
