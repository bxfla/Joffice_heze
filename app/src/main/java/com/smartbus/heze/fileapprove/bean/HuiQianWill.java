package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/8.
 */

public class HuiQianWill implements Serializable {

    /**
     * success : true
     * taskId : 8920028
     * pkValue : 6
     * formRights : {'themeWord':'1','draft':'1','title':'1','proofreading':'1','nuclear ':'1','secret':'1','hao2':'1','Issue':'1','content':'1','draftingDep':'1','copy':'1','hao1':'1','printing':'1','nums':'1','delivery':'1','file':'1','urgency':'1'}
     * mainform : [{"hao2":"啊","nuclear":null,"hao1":"哦","proofreading":"1次","printing":"1","runId":32024,"$type$":"WF_dispatch","themeWord":"侧","urgency":"嗯","sign":"[{\"ui\":\"1\",\"un\":\"1\",\"c\":\"2019-05-08 10:19\",\"v\":\"李\"}]","content":"内容","draft":"唐","Issue":"火","title":"标题","nums":"8","draftingDep":"办公室","file":"15072|IMG_20190605_114959.jpg","mainId":6,"secret":"嗯","delivery":"哦","copy":"汽"}]
     * formDefId : 33
     * preTaskName :
     * isSignTask : false
     * trans : [{"destType":"task","destination":"总经理","name":"to 总经理","source":"分管领导"}]
     * runId : 32024
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
         * hao2 : 啊
         * nuclear : null
         * hao1 : 哦
         * proofreading : 1次
         * printing : 1
         * runId : 32024
         * $type$ : WF_dispatch
         * themeWord : 侧
         * urgency : 嗯
         * sign : [{"ui":"1","un":"1","c":"2019-05-08 10:19","v":"李"}]
         * content : 内容
         * draft : 唐
         * Issue : 火
         * title : 标题
         * nums : 8
         * draftingDep : 办公室
         * file : 15072|IMG_20190605_114959.jpg
         * mainId : 6
         * secret : 嗯
         * delivery : 哦
         * copy : 汽
         */

        private String hao2;
        private String nuclear;
        private String hao1;
        private String proofreading;
        private String printing;
        private int runId;
        private String $type$;
        private String themeWord;
        private String urgency;
        private String sign;
        private String content;
        private String draft;
        private String Issue;
        private String title;
        private String nums;
        private String draftingDep;
        private String file;
        private int mainId;
        private String secret;
        private String delivery;
        private String copy;

        public String getHao2() {
            return hao2;
        }

        public void setHao2(String hao2) {
            this.hao2 = hao2;
        }

        public String getNuclear() {
            return nuclear;
        }

        public void setNuclear(String nuclear) {
            this.nuclear = nuclear;
        }

        public String getHao1() {
            return hao1;
        }

        public void setHao1(String hao1) {
            this.hao1 = hao1;
        }

        public String getProofreading() {
            return proofreading;
        }

        public void setProofreading(String proofreading) {
            this.proofreading = proofreading;
        }

        public String getPrinting() {
            return printing;
        }

        public void setPrinting(String printing) {
            this.printing = printing;
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

        public String getThemeWord() {
            return themeWord;
        }

        public void setThemeWord(String themeWord) {
            this.themeWord = themeWord;
        }

        public String getUrgency() {
            return urgency;
        }

        public void setUrgency(String urgency) {
            this.urgency = urgency;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDraft() {
            return draft;
        }

        public void setDraft(String draft) {
            this.draft = draft;
        }

        public String getIssue() {
            return Issue;
        }

        public void setIssue(String Issue) {
            this.Issue = Issue;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNums() {
            return nums;
        }

        public void setNums(String nums) {
            this.nums = nums;
        }

        public String getDraftingDep() {
            return draftingDep;
        }

        public void setDraftingDep(String draftingDep) {
            this.draftingDep = draftingDep;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getDelivery() {
            return delivery;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }

        public String getCopy() {
            return copy;
        }

        public void setCopy(String copy) {
            this.copy = copy;
        }
    }

    public static class TransBean {
        /**
         * destType : task
         * destination : 总经理
         * name : to 总经理
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
