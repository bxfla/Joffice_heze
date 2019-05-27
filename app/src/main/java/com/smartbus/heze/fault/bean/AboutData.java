package com.smartbus.heze.fault.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/25.
 */

public class AboutData implements Serializable {

    /**
     * success : true
     * data : {"xlbh":"609","ch":"16817","jsy":"103939","carNo":"鲁R06817D","carType":"大型普通客车","bus_maker":"中通客车控股股份有限公司","bus_supplier":"","lc":24351.07}
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
         * xlbh : 609
         * ch : 16817
         * jsy : 103939
         * carNo : 鲁R06817D
         * carType : 大型普通客车
         * bus_maker : 中通客车控股股份有限公司
         * bus_supplier :
         * lc : 24351.07
         */

        private String xlbh;
        private String ch;
        private String jsy;
        private String carNo;
        private String carType;
        private String bus_maker;
        private String bus_supplier;
        private double lc;

        public String getXlbh() {
            return xlbh;
        }

        public void setXlbh(String xlbh) {
            this.xlbh = xlbh;
        }

        public String getCh() {
            return ch;
        }

        public void setCh(String ch) {
            this.ch = ch;
        }

        public String getJsy() {
            return jsy;
        }

        public void setJsy(String jsy) {
            this.jsy = jsy;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getBus_maker() {
            return bus_maker;
        }

        public void setBus_maker(String bus_maker) {
            this.bus_maker = bus_maker;
        }

        public String getBus_supplier() {
            return bus_supplier;
        }

        public void setBus_supplier(String bus_supplier) {
            this.bus_supplier = bus_supplier;
        }

        public double getLc() {
            return lc;
        }

        public void setLc(double lc) {
            this.lc = lc;
        }
    }
}
