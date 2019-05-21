package com.smartbus.heze.checkup.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/21.
 */

public class UpData implements Serializable {

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
