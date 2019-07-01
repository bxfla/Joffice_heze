package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public class OilConsumption implements Serializable {

    /**
     * success : true
     * totalCounts : 251
     * result : [{"version":null,"orgId":null,"orgPath":null,"rankId":536,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0322","busCode":"322","driverCode1":"103162","driverZJM1":null,"driverName1":"李应振","driverCode2":"102046","driverZJM2":null,"driverName2":"刘玉阔","fuelType":"天然气/混合动力","baiglxh":21.85,"rankNum":"第一名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":537,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0320","busCode":"320","driverCode1":"101938","driverZJM1":null,"driverName1":"童迎春","driverCode2":"102046","driverZJM2":null,"driverName2":"刘玉阔","fuelType":"天然气/混合动力","baiglxh":23.37,"rankNum":"第二名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":538,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0311","busCode":"311","driverCode1":"101268","driverZJM1":null,"driverName1":"侯军川","driverCode2":"101882","driverZJM2":null,"driverName2":"何兆祥","fuelType":"天然气/混合动力","baiglxh":22.67,"rankNum":"第三名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":539,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0313","busCode":"313","driverCode1":"101416","driverZJM1":null,"driverName1":"高冠秀","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/混合动力","baiglxh":23.95,"rankNum":"后三名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":540,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0312","busCode":"312","driverCode1":"101291","driverZJM1":null,"driverName1":"曾庆勇","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/混合动力","baiglxh":24.15,"rankNum":"后二名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":541,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0315","busCode":"315","driverCode1":"103042","driverZJM1":null,"driverName1":"朱向广","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/混合动力","baiglxh":27.14,"rankNum":"后一名","lineCode":"22"},{"version":null,"orgId":null,"orgPath":null,"rankId":542,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG9355","busCode":"9355","driverCode1":"102068","driverZJM1":null,"driverName1":"王琼","driverCode2":"101468","driverZJM2":null,"driverName2":"李云法","fuelType":"天然气/混合动力","baiglxh":19.61,"rankNum":"第一名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":543,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG8057","busCode":"8057","driverCode1":"102593","driverZJM1":null,"driverName1":"王志","driverCode2":"101116","driverZJM2":null,"driverName2":"刘卫国","fuelType":"天然气/混合动力","baiglxh":20.17,"rankNum":"第二名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":544,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG6057","busCode":"6057","driverCode1":"102281","driverZJM1":null,"driverName1":"曹存旺","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/混合动力","baiglxh":20.36,"rankNum":"第三名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":545,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG9255","busCode":"9255","driverCode1":"101096","driverZJM1":null,"driverName1":"刘卫军","driverCode2":"101468","driverZJM2":null,"driverName2":"李云法","fuelType":"天然气/混合动力","baiglxh":23.49,"rankNum":"后三名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":546,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG9957","busCode":"9957","driverCode1":"101529","driverZJM1":null,"driverName1":"杨广强","driverCode2":"102303","driverZJM2":null,"driverName2":"刘雪英","fuelType":"天然气/混合动力","baiglxh":23.9,"rankNum":"后二名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":547,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG9057","busCode":"9057","driverCode1":"102250","driverZJM1":null,"driverName1":"曹济国","driverCode2":"102661","driverZJM2":null,"driverName2":"毕京葱","fuelType":"天然气/混合动力","baiglxh":24.21,"rankNum":"后一名","lineCode":"28"},{"version":null,"orgId":null,"orgPath":null,"rankId":548,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0502","busCode":"502","driverCode1":"102513","driverZJM1":null,"driverName1":"周广惠","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/电","baiglxh":17.63,"rankNum":"第一名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":549,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0214","busCode":"214","driverCode1":"101073","driverZJM1":null,"driverName1":"朱保国","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"天然气/混合动力","baiglxh":18.14,"rankNum":"第二名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":550,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0212","busCode":"212","driverCode1":"102474","driverZJM1":null,"driverName1":"林福良","driverCode2":"102315","driverZJM2":null,"driverName2":"姚辉民","fuelType":"混合动力","baiglxh":19.14,"rankNum":"第三名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":551,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0213","busCode":"213","driverCode1":"101072","driverZJM1":null,"driverName1":"崔庆伟","driverCode2":"100144","driverZJM2":null,"driverName2":"王根元","fuelType":"混合动力","baiglxh":22.92,"rankNum":"后三名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":552,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0215","busCode":"215","driverCode1":"100077","driverZJM1":null,"driverName1":"张永生","driverCode2":null,"driverZJM2":null,"driverName2":null,"fuelType":"混合动力","baiglxh":22.95,"rankNum":"后二名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":553,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0201","busCode":"201","driverCode1":"102145","driverZJM1":null,"driverName1":"赵玉平","driverCode2":"102691","driverZJM2":null,"driverName2":"李广涛","fuelType":"天然气/混合动力","baiglxh":23.09,"rankNum":"后一名","lineCode":"50"},{"version":null,"orgId":null,"orgPath":null,"rankId":554,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG6055","busCode":"6055","driverCode1":"102060","driverZJM1":null,"driverName1":"李佑民","driverCode2":"103110","driverZJM2":null,"driverName2":"丁宗平","fuelType":"天然气/混合动力","baiglxh":19.84,"rankNum":"第一名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":555,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0957","busCode":"957","driverCode1":"102058","driverZJM1":null,"driverName1":"李秀现","driverCode2":"102156","driverZJM2":null,"driverName2":"尹祥勇","fuelType":"天然气/混合动力","baiglxh":20.81,"rankNum":"第二名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":556,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG5957","busCode":"5957","driverCode1":"101898","driverZJM1":null,"driverName1":"孔永军","driverCode2":"103110","driverZJM2":null,"driverName2":"丁宗平","fuelType":"天然气/混合动力","baiglxh":22.12,"rankNum":"第三名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":557,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG1057","busCode":"1057","driverCode1":"101507","driverZJM1":null,"driverName1":"李洪国01","driverCode2":"102590","driverZJM2":null,"driverName2":"李华锋","fuelType":"天然气/混合动力","baiglxh":23.03,"rankNum":"后三名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":558,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG0956","busCode":"956","driverCode1":"101248","driverZJM1":null,"driverName1":"平永亮","driverCode2":"102156","driverZJM2":null,"driverName2":"尹祥勇","fuelType":"天然气/混合动力","baiglxh":23.36,"rankNum":"后二名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":559,"createDate":"2017-10-25","depId":428,"depName":"一公司","carNo":"鲁RG5357","busCode":"5357","driverCode1":"101819","driverZJM1":null,"driverName1":"李福来","driverCode2":"101886","driverZJM2":null,"driverName2":"黄献来","fuelType":"天然气/混合动力","baiglxh":25.02,"rankNum":"后一名","lineCode":"66"},{"version":null,"orgId":null,"orgPath":null,"rankId":560,"createDate":"2017-10-25","depId":429,"depName":"二公司","carNo":"鲁RG1256","busCode":"1256","driverCode1":"101324","driverZJM1":null,"driverName1":"李现涛","driverCode2":"100303","driverZJM2":null,"driverName2":"韩军伟","fuelType":"天然气/混合动力","baiglxh":20.36,"rankNum":"第一名","lineCode":"3"}]
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
         * rankId : 536
         * createDate : 2017-10-25
         * depId : 428
         * depName : 一公司
         * carNo : 鲁RG0322
         * busCode : 322
         * driverCode1 : 103162
         * driverZJM1 : null
         * driverName1 : 李应振
         * driverCode2 : 102046
         * driverZJM2 : null
         * driverName2 : 刘玉阔
         * fuelType : 天然气/混合动力
         * baiglxh : 21.85
         * rankNum : 第一名
         * lineCode : 22
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int rankId;
        private String createDate;
        private int depId;
        private String depName;
        private String carNo;
        private String busCode;
        private String driverCode1;
        private Object driverZJM1;
        private String driverName1;
        private String driverCode2;
        private Object driverZJM2;
        private String driverName2;
        private String fuelType;
        private double baiglxh;
        private String rankNum;
        private String lineCode;

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

        public int getRankId() {
            return rankId;
        }

        public void setRankId(int rankId) {
            this.rankId = rankId;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getDepId() {
            return depId;
        }

        public void setDepId(int depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getDriverCode1() {
            return driverCode1;
        }

        public void setDriverCode1(String driverCode1) {
            this.driverCode1 = driverCode1;
        }

        public Object getDriverZJM1() {
            return driverZJM1;
        }

        public void setDriverZJM1(Object driverZJM1) {
            this.driverZJM1 = driverZJM1;
        }

        public String getDriverName1() {
            return driverName1;
        }

        public void setDriverName1(String driverName1) {
            this.driverName1 = driverName1;
        }

        public String getDriverCode2() {
            return driverCode2;
        }

        public void setDriverCode2(String driverCode2) {
            this.driverCode2 = driverCode2;
        }

        public Object getDriverZJM2() {
            return driverZJM2;
        }

        public void setDriverZJM2(Object driverZJM2) {
            this.driverZJM2 = driverZJM2;
        }

        public String getDriverName2() {
            return driverName2;
        }

        public void setDriverName2(String driverName2) {
            this.driverName2 = driverName2;
        }

        public String getFuelType() {
            return fuelType;
        }

        public void setFuelType(String fuelType) {
            this.fuelType = fuelType;
        }

        public double getBaiglxh() {
            return baiglxh;
        }

        public void setBaiglxh(double baiglxh) {
            this.baiglxh = baiglxh;
        }

        public String getRankNum() {
            return rankNum;
        }

        public void setRankNum(String rankNum) {
            this.rankNum = rankNum;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }
    }
}
