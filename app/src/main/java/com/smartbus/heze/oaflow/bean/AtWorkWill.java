package com.smartbus.heze.oaflow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/16.
 */

public class AtWorkWill implements Serializable {

    /**
     * success : true
     * taskId : 9140548
     * pkValue : 1042
     * formRights : {'dayType':'1','fillDate':'1','createTime':'1','userName':'1','fenguanjingli':'1','FuJian':'1','bumenjingli':'2','memo':'1'}
     * mainform : [{"createTime":"2019-05-16","memo":"测试","bumenjingli":null,"fenguanjingli":null,"mainId":1042,"userName":"安守亮","runId":32675,"fillDate":"2019-05-16","FuJian":null,"dayType":"上午","$type$":"WF_YuanGongZhiBanDengJiShenPi","dataUrl_save":"/joffice21/hrm/updateLeaveDays.do?vocationId=1614"}]
     * formDefId : 28
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管经理审批","name":"to 分管经理审批","source":"部门领导审批"}]
     * runId : 32675
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
         * createTime : 2019-05-16
         * memo : 测试
         * bumenjingli : null
         * fenguanjingli : null
         * mainId : 1042
         * userName : 安守亮
         * runId : 32675
         * fillDate : 2019-05-16
         * FuJian : null
         * dayType : 上午
         * $type$ : WF_YuanGongZhiBanDengJiShenPi
         * dataUrl_save : /joffice21/hrm/updateLeaveDays.do?vocationId=1614
         */

        private String createTime;
        private String memo;
        private Object bumenjingli;
        private Object fenguanjingli;
        private int mainId;
        private String userName;
        private int runId;
        private String fillDate;
        private Object FuJian;
        private String dayType;
        private String $type$;
        private String dataUrl_save;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public Object getBumenjingli() {
            return bumenjingli;
        }

        public void setBumenjingli(Object bumenjingli) {
            this.bumenjingli = bumenjingli;
        }

        public Object getFenguanjingli() {
            return fenguanjingli;
        }

        public void setFenguanjingli(Object fenguanjingli) {
            this.fenguanjingli = fenguanjingli;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getRunId() {
            return runId;
        }

        public void setRunId(int runId) {
            this.runId = runId;
        }

        public String getFillDate() {
            return fillDate;
        }

        public void setFillDate(String fillDate) {
            this.fillDate = fillDate;
        }

        public Object getFuJian() {
            return FuJian;
        }

        public void setFuJian(Object FuJian) {
            this.FuJian = FuJian;
        }

        public String getDayType() {
            return dayType;
        }

        public void setDayType(String dayType) {
            this.dayType = dayType;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getDataUrl_save() {
            return dataUrl_save;
        }

        public void setDataUrl_save(String dataUrl_save) {
            this.dataUrl_save = dataUrl_save;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 分管经理审批
         * name : to 分管经理审批
         * source : 部门领导审批
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
