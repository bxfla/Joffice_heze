package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/7/13.
 */

public class LZLR implements Serializable {

    /**
     * success : true
     * lvId : 1
     */

    private boolean success;
    private String lvId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getLvId() {
        return lvId;
    }

    public void setLvId(String lvId) {
        this.lvId = lvId;
    }
}
