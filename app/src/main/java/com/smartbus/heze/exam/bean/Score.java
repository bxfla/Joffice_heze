package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/30.
 */

public class Score implements Serializable {

    /**
     * success : true
     * totalCounts : 4
     * result : [{"examinationId":"102","examinationName":"创城知识竞赛","userCode":"admin","userName":"超级管理员","score":"8.00","ksdate":""},{"examinationId":"45","examinationName":"十九大学习考试","userCode":"admin","userName":"超级管理员","score":"1.00","ksdate":"2019-05-29 18:26:07"},{"examinationId":"45","examinationName":"十九大学习考试","userCode":"admin","userName":"超级管理员","score":"0.00","ksdate":"2019-05-29 18:56:25"},{"examinationId":"45","examinationName":"十九大学习考试","userCode":"admin","userName":"超级管理员","score":"0.00","ksdate":"2019-05-29 19:01:51"}]
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
         * examinationId : 102
         * examinationName : 创城知识竞赛
         * userCode : admin
         * userName : 超级管理员
         * score : 8.00
         * ksdate :
         */

        private String examinationId;
        private String examinationName;
        private String userCode;
        private String userName;
        private String score;
        private String ksdate;

        public String getExaminationId() {
            return examinationId;
        }

        public void setExaminationId(String examinationId) {
            this.examinationId = examinationId;
        }

        public String getExaminationName() {
            return examinationName;
        }

        public void setExaminationName(String examinationName) {
            this.examinationName = examinationName;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getKsdate() {
            return ksdate;
        }

        public void setKsdate(String ksdate) {
            this.ksdate = ksdate;
        }
    }
}
