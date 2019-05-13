package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 通用借款单实体
 * Created by Administrator on 2019/5/8.
 */

public class FileCirculateWill implements Serializable {


    /**
     * success : true
     * taskId : 9020022
     * pkValue : 14
     * formRights : {'lrrq':'1','fileId':'1'}
     * mainform : [{"fileId":"15226|Screenshot_20190512_204914_com.tencent.mm.jpg","mainId":14,"runId":32360,"$type$":"WF_WenJianChuanYueBiaoDan","dataUrl_save":null,"lrrq":"2019-05-13 00:00:00"}]
     * formDefId : 34
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"end","destination":"结束1","name":"to 结束1","source":"文件传阅人"},{"destType":"task","destination":"文件发起人","name":"to 文件发起人","source":"文件传阅人"}]
     * runId : 32360
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
         * fileId : 15226|Screenshot_20190512_204914_com.tencent.mm.jpg
         * mainId : 14
         * runId : 32360
         * $type$ : WF_WenJianChuanYueBiaoDan
         * dataUrl_save : null
         * lrrq : 2019-05-13 00:00:00
         */

        private String fileId;
        private int mainId;
        private int runId;
        private String $type$;
        private Object dataUrl_save;
        private String lrrq;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
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

        public Object getDataUrl_save() {
            return dataUrl_save;
        }

        public void setDataUrl_save(Object dataUrl_save) {
            this.dataUrl_save = dataUrl_save;
        }

        public String getLrrq() {
            return lrrq;
        }

        public void setLrrq(String lrrq) {
            this.lrrq = lrrq;
        }
    }

    public static class TransBean {
        /**
         * destType : end
         * destination : 结束1
         * name : to 结束1
         * source : 文件传阅人
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
