package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/24.
 */

public class SaferHistory implements Serializable {

    /**
     * success : true
     * totalCounts : 974
     * result : [{"id":2,"kaoheDate":"2017-12-16","driverId":"103111","driverName":"武华勤","carNo":"鲁RG0760","busCode":"760","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":3,"kaoheDate":"2017-12-16","driverId":"102142","driverName":"刘付启","carNo":"鲁RG0713","busCode":"713","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":4,"kaoheDate":"2017-12-16","driverId":"101909","driverName":"张玉柱","carNo":"鲁RG0715","busCode":"715","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":5,"kaoheDate":"2017-12-16","driverId":"102255","driverName":"王成武","carNo":"鲁RG0720","busCode":"720","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":6,"kaoheDate":"2017-12-16","driverId":"101264","driverName":"王建国02","carNo":"鲁RG0753","busCode":"753","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":7,"kaoheDate":"2017-12-16","driverId":"100277","driverName":"庞洪顺","carNo":"鲁RG0761","busCode":"761","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":8,"kaoheDate":"2017-12-16","driverId":"102305","driverName":"马红波","carNo":"鲁RG0762","busCode":"762","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":9,"kaoheDate":"2017-12-16","driverId":"103094","driverName":"靳永斌","carNo":"鲁RG7592","busCode":"7592","depId":"430","depName":"三公司","lineCode":"17","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":94},{"id":10,"kaoheDate":"2017-12-16","driverId":"101831","driverName":"高志英","carNo":"鲁RG0763","busCode":"763","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":11,"kaoheDate":"2017-12-16","driverId":"102709","driverName":"马远征","carNo":"鲁RG7761","busCode":"7761","depId":"430","depName":"三公司","lineCode":"18","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":13,"kaoheDate":"2017-12-16","driverId":"103370","driverName":"马海涛","carNo":"鲁RG7802","busCode":"7802","depId":"430","depName":"三公司","lineCode":"18","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":14,"kaoheDate":"2017-12-16","driverId":"102408","driverName":"吴保华","carNo":"鲁RG7752","busCode":"7752","depId":"430","depName":"三公司","lineCode":"18","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-17","shzt":"1","score":99},{"id":15,"kaoheDate":"2017-12-16","driverId":"102139","driverName":"王新宪","carNo":"鲁RA0140","busCode":"140","depId":"431","depName":"定制公交公司","lineCode":"27","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":16,"kaoheDate":"2017-12-16","driverId":"102322","driverName":"曹绪宝","carNo":"鲁RG7663","busCode":"7663","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":17,"kaoheDate":"2017-12-16","driverId":"102479","driverName":"武文山","carNo":"鲁RG7620","busCode":"7620","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":18,"kaoheDate":"2017-12-16","driverId":"102409","driverName":"吴振","carNo":"鲁RG7580","busCode":"7580","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":19,"kaoheDate":"2017-12-16","driverId":"102649","driverName":"田亭","carNo":"鲁RG7827","busCode":"7827","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":20,"kaoheDate":"2017-12-16","driverId":"102157","driverName":"侯保才","carNo":"鲁RG7693","busCode":"7693","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":21,"kaoheDate":"2017-12-16","driverId":"103325","driverName":"尚善强","carNo":"鲁RG7803","busCode":"7803","depId":"430","depName":"三公司","lineCode":"4","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":22,"kaoheDate":"2017-12-16","driverId":"102133","driverName":"刘胜利","carNo":"鲁RG0705","busCode":"705","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":23,"kaoheDate":"2017-12-16","driverId":"101281","driverName":"李朝云","carNo":"鲁RG0712","busCode":"712","depId":"430","depName":"三公司","lineCode":"1","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":24,"kaoheDate":"2017-12-16","driverId":"100208","driverName":"马远景","carNo":"鲁RG0670","busCode":"670","depId":"430","depName":"三公司","lineCode":"101","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":25,"kaoheDate":"2017-12-16","driverId":"100202","driverName":"袁涛","carNo":"鲁RG0672","busCode":"672","depId":"430","depName":"三公司","lineCode":"101","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":26,"kaoheDate":"2017-12-16","driverId":"100199","driverName":"马永林","carNo":"鲁RG0675","busCode":"675","depId":"430","depName":"三公司","lineCode":"101","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99},{"id":27,"kaoheDate":"2017-12-16","driverId":"102842","driverName":"石庆录","carNo":"鲁RG0154","busCode":"154","depId":"430","depName":"三公司","lineCode":"101","examiner":"栗小洲","shry":"栗小洲","shsj":"2017-12-18","shzt":"1","score":99}]
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
         * id : 2
         * kaoheDate : 2017-12-16
         * driverId : 103111
         * driverName : 武华勤
         * carNo : 鲁RG0760
         * busCode : 760
         * depId : 430
         * depName : 三公司
         * lineCode : 1
         * examiner : 栗小洲
         * shry : 栗小洲
         * shsj : 2017-12-17
         * shzt : 1
         * score : 99
         */

        private int id;
        private String kaoheDate;
        private String driverId;
        private String driverName;
        private String carNo;
        private String busCode;
        private String depId;
        private String depName;
        private String lineCode;
        private String examiner;
        private String shry;
        private String shsj;
        private String shzt;
        private int score;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKaoheDate() {
            return kaoheDate;
        }

        public void setKaoheDate(String kaoheDate) {
            this.kaoheDate = kaoheDate;
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

        public String getExaminer() {
            return examiner;
        }

        public void setExaminer(String examiner) {
            this.examiner = examiner;
        }

        public String getShry() {
            return shry;
        }

        public void setShry(String shry) {
            this.shry = shry;
        }

        public String getShsj() {
            return shsj;
        }

        public void setShsj(String shsj) {
            this.shsj = shsj;
        }

        public String getShzt() {
            return shzt;
        }

        public void setShzt(String shzt) {
            this.shzt = shzt;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }
}
