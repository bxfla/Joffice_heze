package com.smartbus.heze.oaflow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/16.
 */

public class AddWorkWill implements Serializable {

    /**
     * success : true
     * taskId : 9140424
     * pkValue : 3585
     * formRights : {'addClassCounts':'1','bumenjingli':'2','beginTime':'1','FuJian':'1','zongjingli':'1','fenguanjingli':'1','applyDate':'1','addClassContent':'1','endTime':'1','addClassPlace':'1','endClassDate':'1','applyName':'1','depName':'1','addClassDate':'1'}
     * mainform : [{"addClassPlace":"地点","bumenjingli":null,"fenguanjingli":null,"depName":"充电中心","beginTime":null,"runId":32661,"$type$":"WF_YuanGongJiaBanLiuCheng","FuJian":null,"endClassDate":"2019-05-16","endTime":null,"zongjingli":null,"addClassContent":"内容","applyDate":"2019-05-16","addClassDate":"2019-05-16","applyName":"安守亮","mainId":3585,"dataUrl_save":"/joffice21/hrm/updateLeaveDays.do?vocationId=4119","addClassCounts":"2"}]
     * formDefId : 19
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管经理审批","name":"to 分管经理审批","source":"部门经理审批"}]
     * runId : 32661
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
         * addClassPlace : 地点
         * bumenjingli : null
         * fenguanjingli : null
         * depName : 充电中心
         * beginTime : null
         * runId : 32661
         * $type$ : WF_YuanGongJiaBanLiuCheng
         * FuJian : null
         * endClassDate : 2019-05-16
         * endTime : null
         * zongjingli : null
         * addClassContent : 内容
         * applyDate : 2019-05-16
         * addClassDate : 2019-05-16
         * applyName : 安守亮
         * mainId : 3585
         * dataUrl_save : /joffice21/hrm/updateLeaveDays.do?vocationId=4119
         * addClassCounts : 2
         */

        private String addClassPlace;
        private Object bumenjingli;
        private Object fenguanjingli;
        private String depName;
        private Object beginTime;
        private int runId;
        private String $type$;
        private Object FuJian;
        private String endClassDate;
        private Object endTime;
        private Object zongjingli;
        private String addClassContent;
        private String applyDate;
        private String addClassDate;
        private String applyName;
        private int mainId;
        private String dataUrl_save;
        private String addClassCounts;

        public String getAddClassPlace() {
            return addClassPlace;
        }

        public void setAddClassPlace(String addClassPlace) {
            this.addClassPlace = addClassPlace;
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

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public Object getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(Object beginTime) {
            this.beginTime = beginTime;
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

        public Object getFuJian() {
            return FuJian;
        }

        public void setFuJian(Object FuJian) {
            this.FuJian = FuJian;
        }

        public String getEndClassDate() {
            return endClassDate;
        }

        public void setEndClassDate(String endClassDate) {
            this.endClassDate = endClassDate;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public Object getZongjingli() {
            return zongjingli;
        }

        public void setZongjingli(Object zongjingli) {
            this.zongjingli = zongjingli;
        }

        public String getAddClassContent() {
            return addClassContent;
        }

        public void setAddClassContent(String addClassContent) {
            this.addClassContent = addClassContent;
        }

        public String getApplyDate() {
            return applyDate;
        }

        public void setApplyDate(String applyDate) {
            this.applyDate = applyDate;
        }

        public String getAddClassDate() {
            return addClassDate;
        }

        public void setAddClassDate(String addClassDate) {
            this.addClassDate = addClassDate;
        }

        public String getApplyName() {
            return applyName;
        }

        public void setApplyName(String applyName) {
            this.applyName = applyName;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getDataUrl_save() {
            return dataUrl_save;
        }

        public void setDataUrl_save(String dataUrl_save) {
            this.dataUrl_save = dataUrl_save;
        }

        public String getAddClassCounts() {
            return addClassCounts;
        }

        public void setAddClassCounts(String addClassCounts) {
            this.addClassCounts = addClassCounts;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 分管经理审批
         * name : to 分管经理审批
         * source : 部门经理审批
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
