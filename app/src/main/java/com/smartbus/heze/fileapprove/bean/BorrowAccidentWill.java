package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 事故借款单实体
 * Created by Administrator on 2019/5/8.
 */

public class BorrowAccidentWill implements Serializable {

    /**
     * success : true
     * taskId : 9000023
     * pkValue : 11
     * formRights : {'caiwujingli':'1','carNo':'1','driverName':'1','acDuty':'1','lineCode':'1','atDate':'1','acNumber':'1','atAfter':'1','kezhang':'2','depName':'1','pishi':'1','atje':'1','jiekuanren':'1','atPlace':'1','fenguanjingli':'1'}
     * mainform : [{"atje":"20","lineCode":"路别","acDuty":"责任","fenguanjingli":"","depName":"安全科","caiwujingli":"","runId":32350,"$type$":"WF_accidentLoanSlip","jiekuanren":"借款人","kezhang":"","carNo":"车牌号","atDate":"2019-05-13","pishi":"","mainId":11,"acNumber":"2","atAfter":"经过","driverName":"驾驶员","atPlace":"济南"}]
     * formDefId : 30
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管经理","name":"to 分管经理","source":"科长"}]
     * runId : 32350
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
         * atje : 20
         * lineCode : 路别
         * acDuty : 责任
         * fenguanjingli :
         * depName : 安全科
         * caiwujingli :
         * runId : 32350
         * $type$ : WF_accidentLoanSlip
         * jiekuanren : 借款人
         * kezhang :
         * carNo : 车牌号
         * atDate : 2019-05-13
         * pishi :
         * mainId : 11
         * acNumber : 2
         * atAfter : 经过
         * driverName : 驾驶员
         * atPlace : 济南
         */

        private String atje;
        private String lineCode;
        private String acDuty;
        private String fenguanjingli;
        private String depName;
        private String caiwujingli;
        private int runId;
        private String $type$;
        private String jiekuanren;
        private String kezhang;
        private String carNo;
        private String atDate;
        private String pishi;
        private int mainId;
        private String acNumber;
        private String atAfter;
        private String driverName;
        private String atPlace;

        public String getAtje() {
            return atje;
        }

        public void setAtje(String atje) {
            this.atje = atje;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getAcDuty() {
            return acDuty;
        }

        public void setAcDuty(String acDuty) {
            this.acDuty = acDuty;
        }

        public String getFenguanjingli() {
            return fenguanjingli;
        }

        public void setFenguanjingli(String fenguanjingli) {
            this.fenguanjingli = fenguanjingli;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getCaiwujingli() {
            return caiwujingli;
        }

        public void setCaiwujingli(String caiwujingli) {
            this.caiwujingli = caiwujingli;
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

        public String getJiekuanren() {
            return jiekuanren;
        }

        public void setJiekuanren(String jiekuanren) {
            this.jiekuanren = jiekuanren;
        }

        public String getKezhang() {
            return kezhang;
        }

        public void setKezhang(String kezhang) {
            this.kezhang = kezhang;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getAtDate() {
            return atDate;
        }

        public void setAtDate(String atDate) {
            this.atDate = atDate;
        }

        public String getPishi() {
            return pishi;
        }

        public void setPishi(String pishi) {
            this.pishi = pishi;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getAcNumber() {
            return acNumber;
        }

        public void setAcNumber(String acNumber) {
            this.acNumber = acNumber;
        }

        public String getAtAfter() {
            return atAfter;
        }

        public void setAtAfter(String atAfter) {
            this.atAfter = atAfter;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getAtPlace() {
            return atPlace;
        }

        public void setAtPlace(String atPlace) {
            this.atPlace = atPlace;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 分管经理
         * name : to 分管经理
         * source : 科长
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
