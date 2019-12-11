package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/12/11.
 */

public class DJDepartment implements Serializable {

    /**
     * success : true
     * data : [{"version":null,"orgId":428,"orgPath":null,"demId":1,"orgName":"一公司","orgDesc":"","orgSupId":410,"path":"0.378.410.428.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2017-03-16 16:08:41","updateId":1,"updatetime":"2017-11-17 13:27:10","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":91,"dwbh":null},{"version":null,"orgId":429,"orgPath":null,"demId":1,"orgName":"二公司","orgDesc":"","orgSupId":410,"path":"0.378.410.429.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2017-03-16 16:09:04","updateId":1,"updatetime":"2017-11-17 13:27:16","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":92,"dwbh":null},{"version":null,"orgId":430,"orgPath":null,"demId":1,"orgName":"三公司","orgDesc":"","orgSupId":410,"path":"0.378.410.430.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2017-03-16 16:09:34","updateId":1,"updatetime":"2017-11-17 13:27:22","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":93,"dwbh":null},{"version":null,"orgId":431,"orgPath":null,"demId":1,"orgName":"定制公交公司","orgDesc":"","orgSupId":410,"path":"0.378.410.431.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2017-03-16 16:10:01","updateId":1,"updatetime":"2017-11-17 13:27:32","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":94,"dwbh":null},{"version":null,"orgId":443,"orgPath":null,"demId":1,"orgName":"调度中心","orgDesc":"","orgSupId":410,"path":"0.378.410.443.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2017-04-05 18:08:04","updateId":1,"updatetime":"2017-11-17 13:27:41","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":95,"dwbh":null},{"version":null,"orgId":497,"orgPath":null,"demId":1,"orgName":"城乡公交一车队","orgDesc":"","orgSupId":410,"path":"0.378.410.497.","depth":3,"orgType":2,"depType":1,"creatorId":1,"createtime":"2018-11-07 09:30:14","updateId":1,"updatetime":"2018-11-07 09:30:14","demension":{"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null},"sn":96,"dwbh":null}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * version : null
         * orgId : 428
         * orgPath : null
         * demId : 1
         * orgName : 一公司
         * orgDesc :
         * orgSupId : 410
         * path : 0.378.410.428.
         * depth : 3
         * orgType : 2
         * depType : 1
         * creatorId : 1
         * createtime : 2017-03-16 16:08:41
         * updateId : 1
         * updatetime : 2017-11-17 13:27:10
         * demension : {"version":0,"orgId":null,"orgPath":null,"demId":1,"demName":null,"demDesc":null,"demType":null}
         * sn : 91
         * dwbh : null
         */

        private Object version;
        private String orgId;
        private Object orgPath;
        private int demId;
        private String orgName;
        private String orgDesc;
        private int orgSupId;
        private String path;
        private int depth;
        private int orgType;
        private int depType;
        private int creatorId;
        private String createtime;
        private int updateId;
        private String updatetime;
        private DemensionBean demension;
        private int sn;
        private Object dwbh;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getDemId() {
            return demId;
        }

        public void setDemId(int demId) {
            this.demId = demId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getOrgDesc() {
            return orgDesc;
        }

        public void setOrgDesc(String orgDesc) {
            this.orgDesc = orgDesc;
        }

        public int getOrgSupId() {
            return orgSupId;
        }

        public void setOrgSupId(int orgSupId) {
            this.orgSupId = orgSupId;
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

        public int getOrgType() {
            return orgType;
        }

        public void setOrgType(int orgType) {
            this.orgType = orgType;
        }

        public int getDepType() {
            return depType;
        }

        public void setDepType(int depType) {
            this.depType = depType;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getUpdateId() {
            return updateId;
        }

        public void setUpdateId(int updateId) {
            this.updateId = updateId;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }

        public DemensionBean getDemension() {
            return demension;
        }

        public void setDemension(DemensionBean demension) {
            this.demension = demension;
        }

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public Object getDwbh() {
            return dwbh;
        }

        public void setDwbh(Object dwbh) {
            this.dwbh = dwbh;
        }

        public static class DemensionBean {
            /**
             * version : 0
             * orgId : null
             * orgPath : null
             * demId : 1
             * demName : null
             * demDesc : null
             * demType : null
             */

            private int version;
            private Object orgId;
            private Object orgPath;
            private int demId;
            private Object demName;
            private Object demDesc;
            private Object demType;

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
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

            public int getDemId() {
                return demId;
            }

            public void setDemId(int demId) {
                this.demId = demId;
            }

            public Object getDemName() {
                return demName;
            }

            public void setDemName(Object demName) {
                this.demName = demName;
            }

            public Object getDemDesc() {
                return demDesc;
            }

            public void setDemDesc(Object demDesc) {
                this.demDesc = demDesc;
            }

            public Object getDemType() {
                return demType;
            }

            public void setDemType(Object demType) {
                this.demType = demType;
            }
        }
    }
}
