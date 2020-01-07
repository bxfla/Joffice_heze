package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */

public class CarCheckHistory implements Serializable {

    /**
     * success : true
     * totalCounts : 2
     * result : [{"version":null,"orgId":null,"orgPath":null,"id":4028,"driverId":"8689","driverName":"任新建","carNo":"鲁R06817D","busCode":"16817","depId":"497","depName":"城乡公交一车队","lineCode":"609","kaoheDate":"2019-12-13","kaoheTime":null,"examiner":"任新建","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":4033,"driverId":"1","driverName":"超级管理员","carNo":"鲁R06817D","busCode":"16817","depId":"497","depName":"城乡公交一车队","lineCode":"1","kaoheDate":"2019-12-13","kaoheTime":"09:02","examiner":"超级管理员","note":"测试","shry":null,"shsj":null,"shzt":"0"}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * id : 4028
         * driverId : 8689
         * driverName : 任新建
         * carNo : 鲁R06817D
         * busCode : 16817
         * depId : 497
         * depName : 城乡公交一车队
         * lineCode : 609
         * kaoheDate : 2019-12-13
         * kaoheTime : null
         * examiner : 任新建
         * note :
         * shry : null
         * shsj : null
         * shzt : 0
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int id;
        private String driverId;
        private String driverName;
        private String carNo;
        private String busCode;
        private String depId;
        private String depName;
        private String lineCode;
        private String kaoheDate;
        private String kaoheTime;
        private String examiner;
        private String note;
        private Object shry;
        private Object shsj;
        private String shzt;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getKaoheDate() {
            return kaoheDate;
        }

        public void setKaoheDate(String kaoheDate) {
            this.kaoheDate = kaoheDate;
        }

        public String getKaoheTime() {
            return kaoheTime;
        }

        public void setKaoheTime(String kaoheTime) {
            this.kaoheTime = kaoheTime;
        }

        public String getExaminer() {
            return examiner;
        }

        public void setExaminer(String examiner) {
            this.examiner = examiner;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public Object getShry() {
            return shry;
        }

        public void setShry(Object shry) {
            this.shry = shry;
        }

        public Object getShsj() {
            return shsj;
        }

        public void setShsj(Object shsj) {
            this.shsj = shsj;
        }

        public String getShzt() {
            return shzt;
        }

        public void setShzt(String shzt) {
            this.shzt = shzt;
        }
    }
}
