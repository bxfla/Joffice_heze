package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */

public class HealthItem implements Serializable {

    /**
     * success : true
     * totalCounts : 26
     * result : [{"projectId":351,"projectName":"外箱体","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCSWGWXT"},{"projectId":352,"projectName":"车窗玻璃","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCSWGCCBL"},{"projectId":353,"projectName":"前后挡玻璃","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCSWGQHDBL"},{"projectId":354,"projectName":"前后车门","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCSWGQHCM"},{"projectId":355,"projectName":"轮胎","scoreNums":4,"state":1,"score":4,"projectKey":"WGJCJFCSWGLT"},{"projectId":356,"projectName":"轮毂","scoreNums":4,"state":1,"score":4,"projectKey":"WGJCJFCSWGLZ"},{"projectId":357,"projectName":"内厢板","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSNXB"},{"projectId":358,"projectName":"地板","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSDB"},{"projectId":359,"projectName":"车内顶","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSCND"},{"projectId":360,"projectName":"仪表台周围","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSYBTZW"},{"projectId":361,"projectName":"驾驶员周围","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSJSYZW"},{"projectId":362,"projectName":"天窗","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSTC"},{"projectId":363,"projectName":"空调滤网","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSKDLW"},{"projectId":364,"projectName":"空调散热器","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSKDSRQ"},{"projectId":365,"projectName":"广告展板","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSGGZB"},{"projectId":366,"projectName":"拉手","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSLS"},{"projectId":367,"projectName":"扶手横杆","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSFSHG"},{"projectId":368,"projectName":"刷卡机","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSSKJ"},{"projectId":369,"projectName":"投币箱","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSTBX"},{"projectId":370,"projectName":"伺服器","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSSFQ"},{"projectId":371,"projectName":"垃圾桶周围","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSLJTZW"},{"projectId":372,"projectName":"座位周围","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSZWZW"},{"projectId":373,"projectName":"后尾屏","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSHWP"},{"projectId":374,"projectName":"前后门周围","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFCNWSQHMZW"},{"projectId":375,"projectName":"灭火器","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSMHQ"},{"projectId":376,"projectName":"安全锤","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFCNWSAQC"}]
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
         * projectId : 351
         * projectName : 外箱体
         * scoreNums : 5.0
         * state : 1
         * score : 5.0
         * projectKey : WGJCJFCSWGWXT
         */

        private int projectId;
        private String projectName;
        private double scoreNums;
        private int state;
        private double score;
        private String projectKey;

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

        public double getScoreNums() {
            return scoreNums;
        }

        public void setScoreNums(double scoreNums) {
            this.scoreNums = scoreNums;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public String getProjectKey() {
            return projectKey;
        }

        public void setProjectKey(String projectKey) {
            this.projectKey = projectKey;
        }
    }
}
