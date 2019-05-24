package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */

public class HealthHistoryItem implements Serializable {


    /**
     * success : true
     * totalCounts : 17
     * result : [{"projectId":"251","projectName":"车身油漆","state":1,"scoreNums":"3.00"},{"projectId":"252","projectName":"风挡车窗","state":1,"scoreNums":"5.00"},{"projectId":"253","projectName":"车灯","state":1,"scoreNums":"10.00"},{"projectId":"254","projectName":"后视镜完好","state":1,"scoreNums":"5.00"},{"projectId":"255","projectName":"低压蓄电池","state":1,"scoreNums":10},{"projectId":"256","projectName":"舱门开关正常","state":1,"scoreNums":"3.00"},{"projectId":"257","projectName":"轮胎外观","state":1,"scoreNums":"5.00"},{"projectId":"258","projectName":"轮胎半轴螺栓","state":1,"scoreNums":"5.00"},{"projectId":"259","projectName":"转向助力泵","state":1,"scoreNums":5},{"projectId":"260","projectName":"空气压缩机","state":1,"scoreNums":5},{"projectId":"261","projectName":"电机冷却水箱水位","state":1,"scoreNums":10},{"projectId":"262","projectName":"仪表盘","state":1,"scoreNums":13},{"projectId":"263","projectName":"刹车离合踏板","state":1,"scoreNums":"5.00"},{"projectId":"264","projectName":"转向系统","state":1,"scoreNums":"5.00"},{"projectId":"265","projectName":"刷卡机报站器","state":1,"scoreNums":"5.00"},{"projectId":"266","projectName":"空调暖风","state":1,"scoreNums":2},{"projectId":"267","projectName":"门铃","state":1,"scoreNums":"2.00"}]
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
         * projectId : 251
         * projectName : 车身油漆
         * state : 1
         * scoreNums : 3.00
         */

        private String projectId;
        private String projectName;
        private int state;
        private String scoreNums;

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getScoreNums() {
            return scoreNums;
        }

        public void setScoreNums(String scoreNums) {
            this.scoreNums = scoreNums;
        }
    }
}
