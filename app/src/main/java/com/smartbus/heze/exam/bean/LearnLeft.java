package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/27.
 */

public class LearnLeft implements Serializable {

    /**
     * success : true
     * totalCounts : 13
     * result : [{"version":null,"orgId":null,"orgPath":null,"proTypeId":4428,"typeName":"安全管理","path":"0.1026.1028.4428.","depth":3,"parentId":1028,"nodeKey":"anquanguanli","catKey":"ATTACHFILE_TYPE","sn":1,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4430,"typeName":"服务管理","path":"0.1026.1028.4430.","depth":3,"parentId":1028,"nodeKey":"fuwuguanli","catKey":"ATTACHFILE_TYPE","sn":2,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4435,"typeName":"技术设备管理","path":"0.1026.1028.4435.","depth":3,"parentId":1028,"nodeKey":"jishushebeiguanli,jizhushebeiguanli","catKey":"ATTACHFILE_TYPE","sn":3,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4436,"typeName":"后勤管理制度","path":"0.1026.1028.4436.","depth":3,"parentId":1028,"nodeKey":"houqinguanlizhidu,houqinguanlizhiduo","catKey":"ATTACHFILE_TYPE","sn":4,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4439,"typeName":"文明礼仪","path":"0.1026.1028.4439.","depth":3,"parentId":1028,"nodeKey":"wenmingliyi","catKey":"ATTACHFILE_TYPE","sn":6,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4440,"typeName":"公司基本情况","path":"0.1026.1028.4440.","depth":3,"parentId":1028,"nodeKey":"gongsijibenqingkuang","catKey":"ATTACHFILE_TYPE","sn":7,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4441,"typeName":"驾驶员学习资料","path":"0.1026.1028.4441.","depth":3,"parentId":1028,"nodeKey":"jiashiyunxuexiziliao,jiashiyuanxuexiziliao","catKey":"ATTACHFILE_TYPE","sn":8,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4444,"typeName":"机务人员学习","path":"0.1026.1028.4444.","depth":3,"parentId":1028,"nodeKey":"jiwurenyunxuexi,jiwurenyuanxuexi","catKey":"ATTACHFILE_TYPE","sn":10,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4647,"typeName":"质量管理","path":"0.1026.1028.4647.","depth":3,"parentId":1028,"nodeKey":"zhiliangguanli","catKey":"ATTACHFILE_TYPE","sn":11,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4445,"typeName":"机务人员综合培训","path":"0.1026.1028.4445.","depth":3,"parentId":1028,"nodeKey":"jiwurenyuanpeixun,jiwurenyunpeixun","catKey":"ATTACHFILE_TYPE","sn":11,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4518,"typeName":"驾驶员综合培训","path":"0.1026.1028.4518.","depth":3,"parentId":1028,"nodeKey":"jiashiyunzenggepeixun,jiashiyunzenghepeixun,jiashiyuanzonggepeixun,jiashiyuanzonghepeixun,jiashiyuanzenghepeixun,jiashiyuanzenggepeixun,jiashiyunzonghepeixun,jiashiyunzonggepeixun","catKey":"ATTACHFILE_TYPE","sn":11,"userId":7443,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4648,"typeName":"相关政策文件","path":"0.1026.1028.4648.","depth":3,"parentId":1028,"nodeKey":"xiangguanzhengcewenjian","catKey":"ATTACHFILE_TYPE","sn":12,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1},{"version":null,"orgId":null,"orgPath":null,"proTypeId":4854,"typeName":"优服文档","path":"0.1026.1028.4854.","depth":3,"parentId":1028,"nodeKey":"youfuwendang","catKey":"ATTACHFILE_TYPE","sn":13,"userId":1,"code":null,"useTime":null,"usePrice":null,"wxfl":1}]
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

    public static class ResultBean implements Serializable{
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * proTypeId : 4428
         * typeName : 安全管理
         * path : 0.1026.1028.4428.
         * depth : 3
         * parentId : 1028
         * nodeKey : anquanguanli
         * catKey : ATTACHFILE_TYPE
         * sn : 1
         * userId : 1
         * code : null
         * useTime : null
         * usePrice : null
         * wxfl : 1
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int proTypeId;
        private String typeName;
        private String path;
        private int depth;
        private int parentId;
        private String nodeKey;
        private String catKey;
        private int sn;
        private int userId;
        private Object code;
        private Object useTime;
        private Object usePrice;
        private int wxfl;

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

        public int getProTypeId() {
            return proTypeId;
        }

        public void setProTypeId(int proTypeId) {
            this.proTypeId = proTypeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getNodeKey() {
            return nodeKey;
        }

        public void setNodeKey(String nodeKey) {
            this.nodeKey = nodeKey;
        }

        public String getCatKey() {
            return catKey;
        }

        public void setCatKey(String catKey) {
            this.catKey = catKey;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public Object getUseTime() {
            return useTime;
        }

        public void setUseTime(Object useTime) {
            this.useTime = useTime;
        }

        public Object getUsePrice() {
            return usePrice;
        }

        public void setUsePrice(Object usePrice) {
            this.usePrice = usePrice;
        }

        public int getWxfl() {
            return wxfl;
        }

        public void setWxfl(int wxfl) {
            this.wxfl = wxfl;
        }
    }
}
