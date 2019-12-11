package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 通用借款单实体
 * Created by Administrator on 2019/5/8.
 */

public class CurrencyAccidentWill implements Serializable {


    /**
     * success : true
     * taskId : 9010016
     * pkValue : 3
     * formRights : {'kezhang':'2','jiekuanDate':'1','jiekuanje':'1','ldps':'1','jiekuanren':'1','jiekuansy':'1','fenguanlingdao':'1','caiwujingli':'1'}
     * mainform : [{"jiekuansy":"借款事由","kezhang":null,"mainId":3,"ldps":null,"jiekuanje":"20","caiwujingli":null,"runId":32357,"$type$":"WF_loanBill","jiekuanren":"借款人","fenguanlingdao":null,"jiekuanDate":"2019-05-13"}]
     * formDefId : 31
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"分管经理","name":"to 分管经理","source":"科长"}]
     * runId : 32357
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
         * jiekuansy : 借款事由
         * kezhang : null
         * mainId : 3
         * ldps : null
         * jiekuanje : 20
         * caiwujingli : null
         * runId : 32357
         * $type$ : WF_loanBill
         * jiekuanren : 借款人
         * fenguanlingdao : null
         * jiekuanDate : 2019-05-13
         */

        private String jiekuansy;
        private String kezhang;
        private int mainId;
        private String ldps;
        private String jiekuanje;
        private String caiwujingli;
        private String runId;
        private String $type$;
        private String jiekuanren;
        private String fenguanlingdao;
        private String jiekuanDate;
        private String dataUrl_save;

        public String getDataUrl_save() {
            return dataUrl_save;
        }

        public void setDataUrl_save(String dataUrl_save) {
            this.dataUrl_save = dataUrl_save;
        }

        public String getJiekuansy() {
            return jiekuansy;
        }

        public void setJiekuansy(String jiekuansy) {
            this.jiekuansy = jiekuansy;
        }

        public String getKezhang() {
            return kezhang;
        }

        public void setKezhang(String kezhang) {
            this.kezhang = kezhang;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getLdps() {
            return ldps;
        }

        public void setLdps(String ldps) {
            this.ldps = ldps;
        }

        public String getJiekuanje() {
            return jiekuanje;
        }

        public void setJiekuanje(String jiekuanje) {
            this.jiekuanje = jiekuanje;
        }

        public String getCaiwujingli() {
            return caiwujingli;
        }

        public void setCaiwujingli(String caiwujingli) {
            this.caiwujingli = caiwujingli;
        }

        public String getRunId() {
            return runId;
        }

        public void setRunId(String runId) {
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

        public String getFenguanlingdao() {
            return fenguanlingdao;
        }

        public void setFenguanlingdao(String fenguanlingdao) {
            this.fenguanlingdao = fenguanlingdao;
        }

        public String getJiekuanDate() {
            return jiekuanDate;
        }

        public void setJiekuanDate(String jiekuanDate) {
            this.jiekuanDate = jiekuanDate;
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
