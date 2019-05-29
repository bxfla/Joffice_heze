package com.smartbus.heze.other.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/29.
 */

public class IcAboutLine implements Serializable {

    /**
     * success : true
     * data : {"driverName":"卞学占","driverCode":"103138","lineCode":"48"}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * driverName : 卞学占
         * driverCode : 103138
         * lineCode : 48
         */

        private String driverName;
        private String driverCode;
        private String lineCode;

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getDriverCode() {
            return driverCode;
        }

        public void setDriverCode(String driverCode) {
            this.driverCode = driverCode;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }
    }
}
