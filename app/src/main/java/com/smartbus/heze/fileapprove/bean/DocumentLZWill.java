package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 公文流转
 * Created by Administrator on 2019/5/8.
 */

public class DocumentLZWill implements Serializable {


    /**
     * success : true
     * taskId : 9020139
     * pkValue : 5
     * formRights : {'nibanyj':'2','wenjianNo':'1','fawenjig':'1','title':'1','shouwenRq':'1','chengbanjg':'1','ldyj':'1','fawennum':'1'}
     * mainform : [{"chengbanjg":"","title":"标题","ldyj":"","fawenjig":"安全科","wenjianNo":"编号","nibanyj":"","mainId":5,"runId":32374,"$type$":"WF_documentCirculation","shouwenRq":"2019-05-13","fawennum":"分数"}]
     * formDefId : 35
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"总经理","name":"to 总经理","source":"办公室"}]
     * runId : 32374
     */

    private boolean success;
    private String taskId;
    private String pkValue;
    private String formRights;
    private String formDefId;
    private String preTaskName;
    private boolean isSignTask;
    private int runId;
    private List<MainformBean> mainform;
    private List<TransBean> trans;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPkValue() {
        return pkValue;
    }

    public void setPkValue(String pkValue) {
        this.pkValue = pkValue;
    }

    public String getFormRights() {
        return formRights;
    }

    public void setFormRights(String formRights) {
        this.formRights = formRights;
    }

    public String getFormDefId() {
        return formDefId;
    }

    public void setFormDefId(String formDefId) {
        this.formDefId = formDefId;
    }

    public String getPreTaskName() {
        return preTaskName;
    }

    public void setPreTaskName(String preTaskName) {
        this.preTaskName = preTaskName;
    }

    public boolean isIsSignTask() {
        return isSignTask;
    }

    public void setIsSignTask(boolean isSignTask) {
        this.isSignTask = isSignTask;
    }

    public int getRunId() {
        return runId;
    }

    public void setRunId(int runId) {
        this.runId = runId;
    }

    public List<MainformBean> getMainform() {
        return mainform;
    }

    public void setMainform(List<MainformBean> mainform) {
        this.mainform = mainform;
    }

    public List<TransBean> getTrans() {
        return trans;
    }

    public void setTrans(List<TransBean> trans) {
        this.trans = trans;
    }

    public static class MainformBean {
        /**
         * chengbanjg :
         * title : 标题
         * ldyj :
         * fawenjig : 安全科
         * wenjianNo : 编号
         * nibanyj :
         * mainId : 5
         * runId : 32374
         * $type$ : WF_documentCirculation
         * shouwenRq : 2019-05-13
         * fawennum : 分数
         */

        private String chengbanjg;
        private String title;
        private String ldyj;
        private String fawenjig;
        private String wenjianNo;
        private String nibanyj;
        private int mainId;
        private int runId;
        private String $type$;
        private String shouwenRq;
        private String fawennum;

        public String getChengbanjg() {
            return chengbanjg;
        }

        public void setChengbanjg(String chengbanjg) {
            this.chengbanjg = chengbanjg;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLdyj() {
            return ldyj;
        }

        public void setLdyj(String ldyj) {
            this.ldyj = ldyj;
        }

        public String getFawenjig() {
            return fawenjig;
        }

        public void setFawenjig(String fawenjig) {
            this.fawenjig = fawenjig;
        }

        public String getWenjianNo() {
            return wenjianNo;
        }

        public void setWenjianNo(String wenjianNo) {
            this.wenjianNo = wenjianNo;
        }

        public String getNibanyj() {
            return nibanyj;
        }

        public void setNibanyj(String nibanyj) {
            this.nibanyj = nibanyj;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public int getRunId() {
            return runId;
        }

        public void setRunId(int runId) {
            this.runId = runId;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getShouwenRq() {
            return shouwenRq;
        }

        public void setShouwenRq(String shouwenRq) {
            this.shouwenRq = shouwenRq;
        }

        public String getFawennum() {
            return fawennum;
        }

        public void setFawennum(String fawennum) {
            this.fawennum = fawennum;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 总经理
         * name : to 总经理
         * source : 办公室
         */

        private String destType;
        private String destination;
        private String name;
        private String source;

        public String getDestType() {
            return destType;
        }

        public void setDestType(String destType) {
            this.destType = destType;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}
