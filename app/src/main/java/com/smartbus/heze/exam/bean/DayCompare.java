package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/8/2.
 */

public class DayCompare implements Serializable {
    /**
     * success : true
     * totalCounts : 17
     * result : [{"projectId":251,"projectName":"车身油漆","fkje":0,"state":1,"projectKey":"WGJCJFCDDCCSYQ"},{"projectId":252,"projectName":"风挡车窗","fkje":0,"state":1,"projectKey":"WGJCJFCDDCFDCC"},{"projectId":253,"projectName":"车灯","fkje":0,"state":1,"projectKey":"WGJCJFCDDCCD"},{"projectId":254,"projectName":"后视镜完好","fkje":0,"state":1,"projectKey":"WGJCJFCDDCHSJWH"},{"projectId":255,"projectName":"低压蓄电池","fkje":0,"state":1,"projectKey":"WGJCJFCDDCDYXDC"},{"projectId":256,"projectName":"舱门开关正常","fkje":0,"state":1,"projectKey":"WGJCJFCDDCCMKGZC"},{"projectId":257,"projectName":"轮胎外观","fkje":0,"state":1,"projectKey":"WGJCJFCDDCLTWG"},{"projectId":258,"projectName":"轮胎半轴螺栓","fkje":0,"state":1,"projectKey":"WGJCJFCDDCLTBZLS"},{"projectId":259,"projectName":"转向助力泵","fkje":0,"state":1,"projectKey":"WGJCJFCDDCZXZLB"},{"projectId":260,"projectName":"空气压缩机","fkje":0,"state":1,"projectKey":"WGJCJFCDDCKQYSJ"},{"projectId":261,"projectName":"电机冷却水箱水位","fkje":0,"state":1,"projectKey":"WGJCJFCDDCDJLQSXSW"},{"projectId":262,"projectName":"仪表盘","fkje":0,"state":1,"projectKey":"WGJCJFCDDCYBP"},{"projectId":263,"projectName":"刹车离合踏板","fkje":0,"state":1,"projectKey":"WGJCJFCDDCSCLHTB"},{"projectId":264,"projectName":"转向系统","fkje":0,"state":1,"projectKey":"WGJCJFCDDCZXXT"},{"projectId":265,"projectName":"刷卡机报站器","fkje":0,"state":1,"projectKey":"WGJCJFCDDCSKJBZQ"},{"projectId":266,"projectName":"空调暖风","fkje":0,"state":1,"projectKey":"WGJCJFCDDCKDNF"},{"projectId":267,"projectName":"门铃","fkje":0,"state":1,"projectKey":"WGJCJFCDDCML"}]
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
         * fkje : 0.0
         * state : 1
         * projectKey : WGJCJFCDDCCSYQ
         */

        private int projectId;
        private String projectName;
        private String fkje;
        private int state;
        private String projectKey;
        private String scoreNums;

        public String getScoreNums() {
            return scoreNums;
        }

        public void setScoreNums(String scoreNums) {
            this.scoreNums = scoreNums;
        }

        public int getProjectId() {
            return projectId;
        }

        public void setProjectId(int projectId) {
            this.projectId = projectId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getFkje() {
            return fkje;
        }

        public void setFkje(String fkje) {
            this.fkje = fkje;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getProjectKey() {
            return projectKey;
        }

        public void setProjectKey(String projectKey) {
            this.projectKey = projectKey;
        }
    }
}
