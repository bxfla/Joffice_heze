package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class SafeMileage implements Serializable {

    /**
     * success : true
     * totalCounts : 455334
     * result : [{"id":3711090,"month":"20190701","driverName":"张文暖","driverCode":"102286","value":0,"memo":"离职清零","datetime":"2019-07-01 09:06:59","lineCode":"","busCode":"","updatetime":null},{"id":3311266,"month":"20190626","driverName":"靳伟娜","driverCode":"103069","value":0,"memo":"离职清零","datetime":"2019-06-26 15:57:45","lineCode":"","busCode":"","updatetime":null},{"id":3311267,"month":"20190626","driverName":"彭伟超","driverCode":"102739","value":0,"memo":"离职清零","datetime":"2019-06-26 15:57:50","lineCode":"","busCode":"","updatetime":null},{"id":3311268,"month":"20190626","driverName":"李马锁","driverCode":"102656","value":0,"memo":"离职清零","datetime":"2019-06-26 16:10:27","lineCode":"","busCode":"","updatetime":null},{"id":3311269,"month":"20190626","driverName":"杨亚波","driverCode":"103589","value":0,"memo":"离职清零","datetime":"2019-06-26 16:17:58","lineCode":"","busCode":"","updatetime":null},{"id":3311270,"month":"20190626","driverName":"桑洋","driverCode":"104002","value":0,"memo":"离职清零","datetime":"2019-06-26 16:57:02","lineCode":"","busCode":"","updatetime":null},{"id":3311262,"month":"20190625","driverName":"王洪刚","driverCode":"104033","value":0,"memo":"离职清零","datetime":"2019-06-25 14:18:04","lineCode":"","busCode":"","updatetime":null},{"id":3311263,"month":"20190625","driverName":"王胜旺","driverCode":"103170","value":0,"memo":"离职清零","datetime":"2019-06-25 14:18:09","lineCode":"","busCode":"","updatetime":null},{"id":3631420,"month":"20190625","driverName":"曹国峰","driverCode":"103981","value":0.09,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"603","busCode":"18152","updatetime":null},{"id":3631421,"month":"20190625","driverName":"曹国峰","driverCode":"103981","value":163.42,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"603","busCode":"3163","updatetime":null},{"id":3631990,"month":"20190625","driverName":"陈永胜01","driverCode":"101089","value":101.78,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"603","busCode":"18659","updatetime":null},{"id":3631991,"month":"20190625","driverName":"陈永胜01","driverCode":"101089","value":0.83,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"603","busCode":"3542","updatetime":null},{"id":3631992,"month":"20190625","driverName":"陈永胜01","driverCode":"101089","value":101.62,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"603","busCode":"17809","updatetime":null},{"id":3632217,"month":"20190625","driverName":"陈云海","driverCode":"103956","value":159.03,"memo":"新增数据","datetime":"2019-06-27 15:54:53","lineCode":"617","busCode":"59910","updatetime":null},{"id":3704222,"month":"20190625","driverName":"武海峰","driverCode":"103438","value":84.46,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"38","busCode":"7293","updatetime":null},{"id":3704223,"month":"20190625","driverName":"武海峰","driverCode":"103438","value":45.46,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"38","busCode":"6731","updatetime":null},{"id":3704224,"month":"20190625","driverName":"武海峰","driverCode":"103438","value":83.62,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"38","busCode":"7015","updatetime":null},{"id":3704249,"month":"20190625","driverName":"武华勤","driverCode":"103111","value":189.25,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"1","busCode":"760","updatetime":null},{"id":3704349,"month":"20190625","driverName":"武敏","driverCode":"102491","value":1.72,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"7","busCode":"7510","updatetime":null},{"id":3704377,"month":"20190625","driverName":"武亚林","driverCode":"100809","value":144.83,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"101","busCode":"53822","updatetime":null},{"id":3704439,"month":"20190625","driverName":"夏清祥","driverCode":"102328","value":76.98,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"17","busCode":"7793","updatetime":null},{"id":3704440,"month":"20190625","driverName":"夏清祥","driverCode":"102328","value":90.7,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"17","busCode":"7730","updatetime":null},{"id":3704441,"month":"20190625","driverName":"夏清祥","driverCode":"102328","value":0,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"17","busCode":"7803","updatetime":null},{"id":3704518,"month":"20190625","driverName":"肖海陆","driverCode":"103059","value":85.88,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"16","busCode":"7950","updatetime":null},{"id":3704519,"month":"20190625","driverName":"肖海陆","driverCode":"103059","value":58.11,"memo":"新增数据","datetime":"2019-06-27 16:51:10","lineCode":"16","busCode":"7991","updatetime":null}]
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

    public static class ResultBean {
        /**
         * id : 3711090
         * month : 20190701
         * driverName : 张文暖
         * driverCode : 102286
         * value : 0.0
         * memo : 离职清零
         * datetime : 2019-07-01 09:06:59
         * lineCode :
         * busCode :
         * updatetime : null
         */

        private int id;
        private String month;
        private String driverName;
        private String driverCode;
        private double value;
        private String memo;
        private String datetime;
        private String lineCode;
        private String busCode;
        private Object updatetime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

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

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public Object getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(Object updatetime) {
            this.updatetime = updatetime;
        }
    }
}
