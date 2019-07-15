package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/15.
 */

public class DocumentLZList implements Serializable {

    /**
     * success : true
     * totalCounts : 9
     * result : [{"version":null,"orgId":null,"orgPath":null,"lvid":47,"lvDate":"2019-07-13","lvDepId":"428","lvDepName":"一公司","lvCode":"123456","lvTitle":"123456","lvnumber":123456,"lvUndertake":"123456","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):同意; 艾测试(总经理):同意; 测试201901(分管领导):同意; ","lvProposedopinions":"","lvInstructions":"","lvResult":"","fileIds":"","shzt":1,"runId":37138},{"version":null,"orgId":null,"orgPath":null,"lvid":49,"lvDate":"2019-07-13","lvDepId":"429","lvDepName":"二公司","lvCode":"65788","lvTitle":"65788","lvnumber":65788,"lvUndertake":"65788","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):同意; ","lvProposedopinions":"","lvInstructions":"","lvResult":"","fileIds":"","shzt":1,"runId":37140},{"version":null,"orgId":null,"orgPath":null,"lvid":50,"lvDate":"2019-07-13","lvDepId":"430","lvDepName":"三公司","lvCode":"98989","lvTitle":"98989","lvnumber":98989,"lvUndertake":"98989","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):同意; 艾测试(总经理):同意; ","lvProposedopinions":"","lvInstructions":"","lvResult":"","fileIds":"","shzt":1,"runId":37142},{"version":null,"orgId":null,"orgPath":null,"lvid":51,"lvDate":"2019-07-13","lvDepId":"431","lvDepName":"定制公交公司","lvCode":"编号什么","lvTitle":"标题什么","lvnumber":5,"lvUndertake":"发文什么","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):; 艾测试(总经理):; 测试201901(分管领导):; ","lvProposedopinions":"niban","lvInstructions":"pishi","lvResult":"jieguo","fileIds":"16650","shzt":1,"runId":37144},{"version":null,"orgId":null,"orgPath":null,"lvid":52,"lvDate":"2019-07-13","lvDepId":"416","lvDepName":"保洁","lvCode":"3","lvTitle":"文件标题","lvnumber":4,"lvUndertake":"保卫科","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; ","lvProposedopinions":"","lvInstructions":"","lvResult":"","fileIds":"16655","shzt":1,"runId":37145},{"version":null,"orgId":null,"orgPath":null,"lvid":53,"lvDate":"2019-07-13","lvDepId":"428","lvDepName":"一公司","lvCode":"编号3","lvTitle":"标题3","lvnumber":33,"lvUndertake":"机关3","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):; 艾测试(总经理):; 测试201901(分管领导):; ","lvProposedopinions":"3","lvInstructions":"33","lvResult":"333","fileIds":"","shzt":1,"runId":37147},{"version":null,"orgId":null,"orgPath":null,"lvid":54,"lvDate":"2019-07-13","lvDepId":"410","lvDepName":"营运管理科","lvCode":"编号4","lvTitle":"标题4","lvnumber":4,"lvUndertake":"机关4","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; 测试1212(办公室):; 艾测试(总经理):; 测试1212(办公室):; 艾测试(总经理):; 测试1212(办公室):; 艾测试(总经理):; 测试201901(分管领导):; ","lvProposedopinions":null,"lvInstructions":null,"lvResult":null,"fileIds":"16650","shzt":1,"runId":37149},{"version":null,"orgId":null,"orgPath":null,"lvid":55,"lvDate":"2019-07-13","lvDepId":"430","lvDepName":"三公司","lvCode":"1","lvTitle":"1","lvnumber":1,"lvUndertake":"1","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; ","lvProposedopinions":null,"lvInstructions":null,"lvResult":null,"fileIds":"","shzt":1,"runId":37151},{"version":null,"orgId":null,"orgPath":null,"lvid":56,"lvDate":"2019-07-15","lvDepId":"419","lvDepName":"安全科","lvCode":"编号","lvTitle":"标题","lvnumber":2,"lvUndertake":"安顺出租车公司","lvInclusionNumber":null,"lvMemo":"超级管理员(开始):; ","lvProposedopinions":null,"lvInstructions":null,"lvResult":null,"fileIds":"16664","shzt":1,"runId":37204}]
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
         * version : null
         * orgId : null
         * orgPath : null
         * lvid : 47
         * lvDate : 2019-07-13
         * lvDepId : 428
         * lvDepName : 一公司
         * lvCode : 123456
         * lvTitle : 123456
         * lvnumber : 123456
         * lvUndertake : 123456
         * lvInclusionNumber : null
         * lvMemo : 超级管理员(开始):; 测试1212(办公室):同意; 艾测试(总经理):同意; 测试201901(分管领导):同意;
         * lvProposedopinions :
         * lvInstructions :
         * lvResult :
         * fileIds :
         * shzt : 1
         * runId : 37138
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int lvid;
        private String lvDate;
        private String lvDepId;
        private String lvDepName;
        private String lvCode;
        private String lvTitle;
        private int lvnumber;
        private String lvUndertake;
        private Object lvInclusionNumber;
        private String lvMemo;
        private String lvProposedopinions;
        private String lvInstructions;
        private String lvResult;
        private String fileIds;
        private int shzt;
        private int runId;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getLvid() {
            return lvid;
        }

        public void setLvid(int lvid) {
            this.lvid = lvid;
        }

        public String getLvDate() {
            return lvDate;
        }

        public void setLvDate(String lvDate) {
            this.lvDate = lvDate;
        }

        public String getLvDepId() {
            return lvDepId;
        }

        public void setLvDepId(String lvDepId) {
            this.lvDepId = lvDepId;
        }

        public String getLvDepName() {
            return lvDepName;
        }

        public void setLvDepName(String lvDepName) {
            this.lvDepName = lvDepName;
        }

        public String getLvCode() {
            return lvCode;
        }

        public void setLvCode(String lvCode) {
            this.lvCode = lvCode;
        }

        public String getLvTitle() {
            return lvTitle;
        }

        public void setLvTitle(String lvTitle) {
            this.lvTitle = lvTitle;
        }

        public int getLvnumber() {
            return lvnumber;
        }

        public void setLvnumber(int lvnumber) {
            this.lvnumber = lvnumber;
        }

        public String getLvUndertake() {
            return lvUndertake;
        }

        public void setLvUndertake(String lvUndertake) {
            this.lvUndertake = lvUndertake;
        }

        public Object getLvInclusionNumber() {
            return lvInclusionNumber;
        }

        public void setLvInclusionNumber(Object lvInclusionNumber) {
            this.lvInclusionNumber = lvInclusionNumber;
        }

        public String getLvMemo() {
            return lvMemo;
        }

        public void setLvMemo(String lvMemo) {
            this.lvMemo = lvMemo;
        }

        public String getLvProposedopinions() {
            return lvProposedopinions;
        }

        public void setLvProposedopinions(String lvProposedopinions) {
            this.lvProposedopinions = lvProposedopinions;
        }

        public String getLvInstructions() {
            return lvInstructions;
        }

        public void setLvInstructions(String lvInstructions) {
            this.lvInstructions = lvInstructions;
        }

        public String getLvResult() {
            return lvResult;
        }

        public void setLvResult(String lvResult) {
            this.lvResult = lvResult;
        }

        public String getFileIds() {
            return fileIds;
        }

        public void setFileIds(String fileIds) {
            this.fileIds = fileIds;
        }

        public int getShzt() {
            return shzt;
        }

        public void setShzt(int shzt) {
            this.shzt = shzt;
        }

        public int getRunId() {
            return runId;
        }

        public void setRunId(int runId) {
            this.runId = runId;
        }
    }
}
