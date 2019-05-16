package com.smartbus.heze.oaflow.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/16.
 */

public class UserdLeaveWill implements Serializable {


    /**
     * success : true
     * taskId : 8972760
     * pkValue : 2809
     * formRights : {'jsdayType':'1','endDate':'1','bumenjingli':'1','beginDate':'1','XiaoJiaRiQi':'1','vocationType':'1','shiyou':'1','ksdayType':'1','FuBingLi':'1','fullname':'1','TianDanRiQi':'1','fenguanjingli':'1','zongjingli':'1','vocationDays':'1'}
     * mainform : [{"FuBingLi":"","ksdayType":"下午","bumenjingli":"","fenguanjingli":"","endDate":"2019-04-30","shiyou":"","runId":31802,"$type$":"WF_YuanGongQingJiaLiuCheng","beginDate":"2019-04-30","zongjingli":"","XiaoJiaRiQi":"2019-05-05","vocationType":"事假","jsdayType":"下午","TianDanRiQi":"2019-05-05","vocationDays":"0.50","mainId":2809,"dataUrl_save":"/joffice/hrm/updateLeaveDays.do?vocationId=2968","fullname":"郑传环"}]
     * formDefId : 13
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"end","destination":"结束1","name":"to 结束1","source":"通知发起人"}]
     * runId : 31802
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
         * FuBingLi :
         * ksdayType : 下午
         * bumenjingli :
         * fenguanjingli :
         * endDate : 2019-04-30
         * shiyou :
         * runId : 31802
         * $type$ : WF_YuanGongQingJiaLiuCheng
         * beginDate : 2019-04-30
         * zongjingli :
         * XiaoJiaRiQi : 2019-05-05
         * vocationType : 事假
         * jsdayType : 下午
         * TianDanRiQi : 2019-05-05
         * vocationDays : 0.50
         * mainId : 2809
         * dataUrl_save : /joffice/hrm/updateLeaveDays.do?vocationId=2968
         * fullname : 郑传环
         */

        private String FuBingLi;
        private String ksdayType;
        private String bumenjingli;
        private String fenguanjingli;
        private String endDate;
        private String shiyou;
        private int runId;
        private String $type$;
        private String beginDate;
        private String zongjingli;
        private String XiaoJiaRiQi;
        private String vocationType;
        private String jsdayType;
        private String TianDanRiQi;
        private String vocationDays;
        private int mainId;
        private String dataUrl_save;
        private String fullname;

        public String getFuBingLi() {
            return FuBingLi;
        }

        public void setFuBingLi(String FuBingLi) {
            this.FuBingLi = FuBingLi;
        }

        public String getKsdayType() {
            return ksdayType;
        }

        public void setKsdayType(String ksdayType) {
            this.ksdayType = ksdayType;
        }

        public String getBumenjingli() {
            return bumenjingli;
        }

        public void setBumenjingli(String bumenjingli) {
            this.bumenjingli = bumenjingli;
        }

        public String getFenguanjingli() {
            return fenguanjingli;
        }

        public void setFenguanjingli(String fenguanjingli) {
            this.fenguanjingli = fenguanjingli;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getShiyou() {
            return shiyou;
        }

        public void setShiyou(String shiyou) {
            this.shiyou = shiyou;
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

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getZongjingli() {
            return zongjingli;
        }

        public void setZongjingli(String zongjingli) {
            this.zongjingli = zongjingli;
        }

        public String getXiaoJiaRiQi() {
            return XiaoJiaRiQi;
        }

        public void setXiaoJiaRiQi(String XiaoJiaRiQi) {
            this.XiaoJiaRiQi = XiaoJiaRiQi;
        }

        public String getVocationType() {
            return vocationType;
        }

        public void setVocationType(String vocationType) {
            this.vocationType = vocationType;
        }

        public String getJsdayType() {
            return jsdayType;
        }

        public void setJsdayType(String jsdayType) {
            this.jsdayType = jsdayType;
        }

        public String getTianDanRiQi() {
            return TianDanRiQi;
        }

        public void setTianDanRiQi(String TianDanRiQi) {
            this.TianDanRiQi = TianDanRiQi;
        }

        public String getVocationDays() {
            return vocationDays;
        }

        public void setVocationDays(String vocationDays) {
            this.vocationDays = vocationDays;
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

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }
    }

    public static class TransBean {
        /**
         * destType : end
         * destination : 结束1
         * name : to 结束1
         * source : 通知发起人
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
