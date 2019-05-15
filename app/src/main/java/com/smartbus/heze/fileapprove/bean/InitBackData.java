package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/5.
 */

public class InitBackData implements Serializable {

    private boolean success;
    private String vocationId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getVocationId() {
        return vocationId;
    }

    public void setVocationId(String vocationId) {
        this.vocationId = vocationId;
    }
}
