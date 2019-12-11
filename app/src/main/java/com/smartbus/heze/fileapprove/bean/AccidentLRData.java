package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/5.
 */

public class AccidentLRData implements Serializable {

    private boolean success;
    private String versatileLoanId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getVersatileLoanId() {
        return versatileLoanId;
    }

    public void setVersatileLoanId(String versatileLoanId) {
        this.versatileLoanId = versatileLoanId;
    }
}
