package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/5.
 */

public class BorrowAccidentLRData implements Serializable {

    private boolean success;
    private String accidentLoanId;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAccidentLoanId() {
        return accidentLoanId;
    }

    public void setAccidentLoanId(String versatileLoanId) {
        this.accidentLoanId = versatileLoanId;
    }
}
