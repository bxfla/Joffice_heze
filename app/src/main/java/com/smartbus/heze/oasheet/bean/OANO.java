package com.smartbus.heze.oasheet.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/22.
 */

public class OANO implements Serializable {


    /**
     * success : true
     * number : GZCD2019052300034
     */

    private boolean success;
    private String number;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
