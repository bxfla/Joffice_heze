package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/8.
 */

public class DepartBudgetWill implements Serializable {


    /**
     * success : true
     * taskId : 8980041
     * pkValue : 54
     * formRights : {}
     * mainform : [{"bmDid":null,"hdsl5":null,"hdsl6":null,"hdsl7":null,"xm5":"","xm6":null,"xm8":null,"hddj4":null,"xm4":"","xm3":"","hddj5":null,"hddj2":null,"xm2":"测试1","hddj3":null,"xm1":"测试","hddj6":null,"dj6":null,"dj7":null,"hddj7":null,"project":null,"dw2":"只","dw1":"个","dj5":"","dj4":"","dj3":"","zjly":null,"pfDate":null,"zhibiao":"137","dj2":"2","hddj1":null,"dj1":"1","depName":"安全科","zwcl":null,"runId":32328,"cwk":null,"sl5":"","hdje4":null,"je4":"","sl6":null,"je3":"","hdje3":null,"je6":null,"hdje6":null,"sl7":null,"je5":"","hdje5":null,"bzly":"测试事由","sl1":"1","sl2":"2","je7":null,"hdje2":null,"sl3":"","mainId":54,"sl4":"","hdje1":null,"createDate":"2019-05-13","je2":"4.0","je1":"1.0","hdsl3":null,"hjje2":"","jlyj":null,"hdsl4":null,"hjje1":"5.0","fgyj":null,"hdsl1":null,"hdsl2":null,"$type$":"WF_budgetDetail","hdje7":null,"dw7":null,"dw4":"","dw3":"","nums":null,"hjsl1":"3","dw6":null,"hjsl2":"","dw5":"","keshifuzer":null}]
     * formDefId : 37
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"财务科","name":"to 财务科","source":"分管领导"}]
     * runId : 32328
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
         * bmDid : null
         * hdsl5 : null
         * hdsl6 : null
         * hdsl7 : null
         * xm5 :
         * xm6 : null
         * xm8 : null
         * hddj4 : null
         * xm4 :
         * xm3 :
         * hddj5 : null
         * hddj2 : null
         * xm2 : 测试1
         * hddj3 : null
         * xm1 : 测试
         * hddj6 : null
         * dj6 : null
         * dj7 : null
         * hddj7 : null
         * project : null
         * dw2 : 只
         * dw1 : 个
         * dj5 :
         * dj4 :
         * dj3 :
         * zjly : null
         * pfDate : null
         * zhibiao : 137
         * dj2 : 2
         * hddj1 : null
         * dj1 : 1
         * depName : 安全科
         * zwcl : null
         * runId : 32328
         * cwk : null
         * sl5 :
         * hdje4 : null
         * je4 :
         * sl6 : null
         * je3 :
         * hdje3 : null
         * je6 : null
         * hdje6 : null
         * sl7 : null
         * je5 :
         * hdje5 : null
         * bzly : 测试事由
         * sl1 : 1
         * sl2 : 2
         * je7 : null
         * hdje2 : null
         * sl3 :
         * mainId : 54
         * sl4 :
         * hdje1 : null
         * createDate : 2019-05-13
         * je2 : 4.0
         * je1 : 1.0
         * hdsl3 : null
         * hjje2 :
         * jlyj : null
         * hdsl4 : null
         * hjje1 : 5.0
         * fgyj : null
         * hdsl1 : null
         * hdsl2 : null
         * $type$ : WF_budgetDetail
         * hdje7 : null
         * dw7 : null
         * dw4 :
         * dw3 :
         * nums : null
         * hjsl1 : 3
         * dw6 : null
         * hjsl2 :
         * dw5 :
         * keshifuzer : null
         */

        private String bmDid;
        private String hdsl5;
        private String hdsl6;
        private String hdsl7;
        private String xm5;
        private String xm6;
        private String xm8;
        private String hddj4;
        private String xm4;
        private String xm3;
        private String hddj5;
        private String hddj2;
        private String xm2;
        private String hddj3;
        private String xm1;
        private String hddj6;
        private String dj6;
        private String dj7;
        private String hddj7;
        private String project;
        private String dw2;
        private String dw1;
        private String dj5;
        private String dj4;
        private String dj3;
        private String zjly;
        private String pfDate;
        private String zhibiao;
        private String dj2;
        private String hddj1;
        private String dj1;
        private String depName;
        private String zwcl;
        private int runId;
        private String cwk;
        private String sl5;
        private String hdje4;
        private String je4;
        private String sl6;
        private String je3;
        private String hdje3;
        private String je6;
        private String hdje6;
        private String sl7;
        private String je5;
        private String hdje5;
        private String bzly;
        private String sl1;
        private String sl2;
        private String je7;
        private String hdje2;
        private String sl3;
        private String mainId;
        private String sl4;
        private String hdje1;
        private String createDate;
        private String je2;
        private String je1;
        private String hdsl3;
        private String hjje2;
        private String jlyj;
        private String hdsl4;
        private String hjje1;
        private String fgyj;
        private String hdsl1;
        private String hdsl2;
        private String $type$;
        private String hdje7;
        private String dw7;
        private String dw4;
        private String dw3;
        private String nums;
        private String hjsl1;
        private String dw6;
        private String hjsl2;
        private String dw5;
        private String keshifuzer;

        public String getBmDid() {
            return bmDid;
        }

        public void setBmDid(String bmDid) {
            this.bmDid = bmDid;
        }

        public String getHdsl5() {
            return hdsl5;
        }

        public void setHdsl5(String hdsl5) {
            this.hdsl5 = hdsl5;
        }

        public String getHdsl6() {
            return hdsl6;
        }

        public void setHdsl6(String hdsl6) {
            this.hdsl6 = hdsl6;
        }

        public String getHdsl7() {
            return hdsl7;
        }

        public void setHdsl7(String hdsl7) {
            this.hdsl7 = hdsl7;
        }

        public String getXm5() {
            return xm5;
        }

        public void setXm5(String xm5) {
            this.xm5 = xm5;
        }

        public String getXm6() {
            return xm6;
        }

        public void setXm6(String xm6) {
            this.xm6 = xm6;
        }

        public String getXm8() {
            return xm8;
        }

        public void setXm8(String xm8) {
            this.xm8 = xm8;
        }

        public String getHddj4() {
            return hddj4;
        }

        public void setHddj4(String hddj4) {
            this.hddj4 = hddj4;
        }

        public String getXm4() {
            return xm4;
        }

        public void setXm4(String xm4) {
            this.xm4 = xm4;
        }

        public String getXm3() {
            return xm3;
        }

        public void setXm3(String xm3) {
            this.xm3 = xm3;
        }

        public String getHddj5() {
            return hddj5;
        }

        public void setHddj5(String hddj5) {
            this.hddj5 = hddj5;
        }

        public String getHddj2() {
            return hddj2;
        }

        public void setHddj2(String hddj2) {
            this.hddj2 = hddj2;
        }

        public String getXm2() {
            return xm2;
        }

        public void setXm2(String xm2) {
            this.xm2 = xm2;
        }

        public String getHddj3() {
            return hddj3;
        }

        public void setHddj3(String hddj3) {
            this.hddj3 = hddj3;
        }

        public String getXm1() {
            return xm1;
        }

        public void setXm1(String xm1) {
            this.xm1 = xm1;
        }

        public String getHddj6() {
            return hddj6;
        }

        public void setHddj6(String hddj6) {
            this.hddj6 = hddj6;
        }

        public String getDj6() {
            return dj6;
        }

        public void setDj6(String dj6) {
            this.dj6 = dj6;
        }

        public String getDj7() {
            return dj7;
        }

        public void setDj7(String dj7) {
            this.dj7 = dj7;
        }

        public String getHddj7() {
            return hddj7;
        }

        public void setHddj7(String hddj7) {
            this.hddj7 = hddj7;
        }

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }

        public String getDw2() {
            return dw2;
        }

        public void setDw2(String dw2) {
            this.dw2 = dw2;
        }

        public String getDw1() {
            return dw1;
        }

        public void setDw1(String dw1) {
            this.dw1 = dw1;
        }

        public String getDj5() {
            return dj5;
        }

        public void setDj5(String dj5) {
            this.dj5 = dj5;
        }

        public String getDj4() {
            return dj4;
        }

        public void setDj4(String dj4) {
            this.dj4 = dj4;
        }

        public String getDj3() {
            return dj3;
        }

        public void setDj3(String dj3) {
            this.dj3 = dj3;
        }

        public String getZjly() {
            return zjly;
        }

        public void setZjly(String zjly) {
            this.zjly = zjly;
        }

        public String getPfDate() {
            return pfDate;
        }

        public void setPfDate(String pfDate) {
            this.pfDate = pfDate;
        }

        public String getZhibiao() {
            return zhibiao;
        }

        public void setZhibiao(String zhibiao) {
            this.zhibiao = zhibiao;
        }

        public String getDj2() {
            return dj2;
        }

        public void setDj2(String dj2) {
            this.dj2 = dj2;
        }

        public String getHddj1() {
            return hddj1;
        }

        public void setHddj1(String hddj1) {
            this.hddj1 = hddj1;
        }

        public String getDj1() {
            return dj1;
        }

        public void setDj1(String dj1) {
            this.dj1 = dj1;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getZwcl() {
            return zwcl;
        }

        public void setZwcl(String zwcl) {
            this.zwcl = zwcl;
        }

        public int getRunId() {
            return runId;
        }

        public void setRunId(int runId) {
            this.runId = runId;
        }

        public String getCwk() {
            return cwk;
        }

        public void setCwk(String cwk) {
            this.cwk = cwk;
        }

        public String getSl5() {
            return sl5;
        }

        public void setSl5(String sl5) {
            this.sl5 = sl5;
        }

        public String getHdje4() {
            return hdje4;
        }

        public void setHdje4(String hdje4) {
            this.hdje4 = hdje4;
        }

        public String getJe4() {
            return je4;
        }

        public void setJe4(String je4) {
            this.je4 = je4;
        }

        public String getSl6() {
            return sl6;
        }

        public void setSl6(String sl6) {
            this.sl6 = sl6;
        }

        public String getJe3() {
            return je3;
        }

        public void setJe3(String je3) {
            this.je3 = je3;
        }

        public String getHdje3() {
            return hdje3;
        }

        public void setHdje3(String hdje3) {
            this.hdje3 = hdje3;
        }

        public String getJe6() {
            return je6;
        }

        public void setJe6(String je6) {
            this.je6 = je6;
        }

        public String getHdje6() {
            return hdje6;
        }

        public void setHdje6(String hdje6) {
            this.hdje6 = hdje6;
        }

        public String getSl7() {
            return sl7;
        }

        public void setSl7(String sl7) {
            this.sl7 = sl7;
        }

        public String getJe5() {
            return je5;
        }

        public void setJe5(String je5) {
            this.je5 = je5;
        }

        public String getHdje5() {
            return hdje5;
        }

        public void setHdje5(String hdje5) {
            this.hdje5 = hdje5;
        }

        public String getBzly() {
            return bzly;
        }

        public void setBzly(String bzly) {
            this.bzly = bzly;
        }

        public String getSl1() {
            return sl1;
        }

        public void setSl1(String sl1) {
            this.sl1 = sl1;
        }

        public String getSl2() {
            return sl2;
        }

        public void setSl2(String sl2) {
            this.sl2 = sl2;
        }

        public String getJe7() {
            return je7;
        }

        public void setJe7(String je7) {
            this.je7 = je7;
        }

        public String getHdje2() {
            return hdje2;
        }

        public void setHdje2(String hdje2) {
            this.hdje2 = hdje2;
        }

        public String getSl3() {
            return sl3;
        }

        public void setSl3(String sl3) {
            this.sl3 = sl3;
        }

        public String getMainId() {
            return mainId;
        }

        public void setMainId(String mainId) {
            this.mainId = mainId;
        }

        public String getSl4() {
            return sl4;
        }

        public void setSl4(String sl4) {
            this.sl4 = sl4;
        }

        public String getHdje1() {
            return hdje1;
        }

        public void setHdje1(String hdje1) {
            this.hdje1 = hdje1;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getJe2() {
            return je2;
        }

        public void setJe2(String je2) {
            this.je2 = je2;
        }

        public String getJe1() {
            return je1;
        }

        public void setJe1(String je1) {
            this.je1 = je1;
        }

        public String getHdsl3() {
            return hdsl3;
        }

        public void setHdsl3(String hdsl3) {
            this.hdsl3 = hdsl3;
        }

        public String getHjje2() {
            return hjje2;
        }

        public void setHjje2(String hjje2) {
            this.hjje2 = hjje2;
        }

        public String getJlyj() {
            return jlyj;
        }

        public void setJlyj(String jlyj) {
            this.jlyj = jlyj;
        }

        public String getHdsl4() {
            return hdsl4;
        }

        public void setHdsl4(String hdsl4) {
            this.hdsl4 = hdsl4;
        }

        public String getHjje1() {
            return hjje1;
        }

        public void setHjje1(String hjje1) {
            this.hjje1 = hjje1;
        }

        public String getFgyj() {
            return fgyj;
        }

        public void setFgyj(String fgyj) {
            this.fgyj = fgyj;
        }

        public String getHdsl1() {
            return hdsl1;
        }

        public void setHdsl1(String hdsl1) {
            this.hdsl1 = hdsl1;
        }

        public String getHdsl2() {
            return hdsl2;
        }

        public void setHdsl2(String hdsl2) {
            this.hdsl2 = hdsl2;
        }

        public String get$type$() {
            return $type$;
        }

        public void set$type$(String $type$) {
            this.$type$ = $type$;
        }

        public String getHdje7() {
            return hdje7;
        }

        public void setHdje7(String hdje7) {
            this.hdje7 = hdje7;
        }

        public String getDw7() {
            return dw7;
        }

        public void setDw7(String dw7) {
            this.dw7 = dw7;
        }

        public String getDw4() {
            return dw4;
        }

        public void setDw4(String dw4) {
            this.dw4 = dw4;
        }

        public String getDw3() {
            return dw3;
        }

        public void setDw3(String dw3) {
            this.dw3 = dw3;
        }

        public String getNums() {
            return nums;
        }

        public void setNums(String nums) {
            this.nums = nums;
        }

        public String getHjsl1() {
            return hjsl1;
        }

        public void setHjsl1(String hjsl1) {
            this.hjsl1 = hjsl1;
        }

        public String getDw6() {
            return dw6;
        }

        public void setDw6(String dw6) {
            this.dw6 = dw6;
        }

        public String getHjsl2() {
            return hjsl2;
        }

        public void setHjsl2(String hjsl2) {
            this.hjsl2 = hjsl2;
        }

        public String getDw5() {
            return dw5;
        }

        public void setDw5(String dw5) {
            this.dw5 = dw5;
        }

        public String getKeshifuzer() {
            return keshifuzer;
        }

        public void setKeshifuzer(String keshifuzer) {
            this.keshifuzer = keshifuzer;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 财务科
         * name : to 财务科
         * source : 分管领导
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
