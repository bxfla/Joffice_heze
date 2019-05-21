package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/21.
 */

public class SafeItem implements Serializable {

    /**
     * success : true
     * totalCounts : 28
     * result : [{"projectId":287,"projectName":"工装","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSGZ"},{"projectId":288,"projectName":"工作牌","scoreNums":2,"state":1,"score":2,"projectKey":"WGJCJFAQSSGZP"},{"projectId":289,"projectName":"工作徽章","scoreNums":1,"state":1,"score":1,"projectKey":"WGJCJFAQSSGZHZ"},{"projectId":290,"projectName":"肩章","scoreNums":1,"state":1,"score":1,"projectKey":"WGJCJFAQSSJZ"},{"projectId":291,"projectName":"袖标","scoreNums":1,"state":1,"score":1,"projectKey":"WGJCJFAQSSXB"},{"projectId":292,"projectName":"录像机指示灯是否正常","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSLXJZSDSFZC"},{"projectId":293,"projectName":"刹车灯","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSSCD"},{"projectId":294,"projectName":"转向灯","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSZXD"},{"projectId":295,"projectName":"前档玻璃","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSQDBL"},{"projectId":296,"projectName":"发动机灭火弹是否完好","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSFDJMHDSFWH"},{"projectId":297,"projectName":"灭火器数量缺失","scoreNums":0,"state":1,"score":0,"projectKey":"WGJCJFAQSSMHQSLQS"},{"projectId":298,"projectName":"气压","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSQY"},{"projectId":299,"projectName":"保险销","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSBXX"},{"projectId":300,"projectName":"皮管","scoreNums":2,"state":1,"score":2,"projectKey":"WGJCJFAQSSPG"},{"projectId":301,"projectName":"固定座","scoreNums":2,"state":1,"score":2,"projectKey":"WGJCJFAQSSGDZ"},{"projectId":302,"projectName":"数量缺失","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSSLQS"},{"projectId":303,"projectName":"底座牢靠","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSDZLK"},{"projectId":304,"projectName":"钢丝回位","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSGSHW"},{"projectId":305,"projectName":"玻璃爆破器保险销","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSBLBPQBXX"},{"projectId":306,"projectName":"固定座","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSGDZ"},{"projectId":307,"projectName":"扳手","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSBS"},{"projectId":308,"projectName":"外盖闭合","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSWGBH"},{"projectId":309,"projectName":"内置手柄","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSNZSB"},{"projectId":310,"projectName":"正常开启","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSZCKQ"},{"projectId":311,"projectName":"安全标识","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSAQBS"},{"projectId":312,"projectName":"天窗通道畅通","scoreNums":5,"state":1,"score":5,"projectKey":"WGJCJFAQSSTCTDCT"},{"projectId":313,"projectName":"舱内无杂物","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSCNWZW"},{"projectId":314,"projectName":"高压舱门","scoreNums":3,"state":1,"score":3,"projectKey":"WGJCJFAQSSGYCM"}]
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
         * projectId : 287
         * projectName : 工装
         * scoreNums : 3.0
         * state : 1
         * score : 3.0
         * projectKey : WGJCJFAQSSGZ
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
