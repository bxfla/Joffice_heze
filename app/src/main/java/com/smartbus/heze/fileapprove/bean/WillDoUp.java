package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/9.
 */

public class WillDoUp implements Serializable {

    /**
     * success : true
     * runId : 51695
     */

    private boolean success;
    private int runId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }
}
