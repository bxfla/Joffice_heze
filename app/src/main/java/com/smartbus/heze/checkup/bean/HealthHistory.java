package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */

public class HealthHistory implements Serializable {


    /**
     * success : true
     * totalCounts : 11
     * result : [{"version":null,"orgId":null,"orgPath":null,"id":48,"driverId":"103061","driverName":"高猛","carNo":"鲁RG6510","busCode":"6510","depId":"428","depName":"一公司","lineCode":"103","kaoheDate":"2018-12-11","examiner":"张世平","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":49,"driverId":"103554","driverName":"常峰源_2018-12-01_A3","carNo":"鲁RG7397","busCode":"7397","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":50,"driverId":"102045","driverName":"刘薇_2013-08-08_A3","carNo":"鲁RG7831","busCode":"7831","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":51,"driverId":"102102","driverName":"张本军_2015-04-09_A1","carNo":"鲁RG7837","busCode":"7837","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":52,"driverId":"101674","driverName":"张云东_2014-06-29_A1","carNo":"鲁RG7872","busCode":"7872","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":53,"driverId":"103587","driverName":"黄鲁会_2018-03-19_A1","carNo":"鲁RG7902","busCode":"7902","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":54,"driverId":"102159","driverName":"孙传友_2016-06-29_A1","carNo":"鲁RG7905","busCode":"7905","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":55,"driverId":"101594","driverName":"王建保_2013-05-18_A1","carNo":"鲁RG7907","busCode":"7907","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":56,"driverId":"101772","driverName":"曹瑞敏_2014-07-23_A3","carNo":"鲁RG7911","busCode":"7911","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":57,"driverId":"103448","driverName":"桑贤磊_2017-10-30_A3","carNo":"鲁RG7921","busCode":"7921","depId":"428","depName":"一公司","lineCode":"48","kaoheDate":"2019-01-20","examiner":"张世平,赵恒","note":"","shry":null,"shsj":null,"shzt":"0"},{"version":null,"orgId":null,"orgPath":null,"id":61,"driverId":null,"driverName":null,"carNo":null,"busCode":null,"depId":null,"depName":null,"lineCode":null,"kaoheDate":null,"examiner":null,"note":null,"shry":null,"shsj":null,"shzt":"0"}]
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
         * id : 48
         * driverId : 103061
         * driverName : 高猛
         * carNo : 鲁RG6510
         * busCode : 6510
         * depId : 428
         * depName : 一公司
         * lineCode : 103
         * kaoheDate : 2018-12-11
         * examiner : 张世平
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
