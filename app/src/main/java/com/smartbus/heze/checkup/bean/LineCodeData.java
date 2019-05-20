package com.smartbus.heze.checkup.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/20.
 */

public class LineCodeData extends DataSupport implements Serializable {

    /**
     * version : null
     * orgId : null
     * orgPath : null
     * lineInfoId : 55126
     * lineCode : 1
     * lineName : 1路
     * depId : null
     * department : {"version":null,"orgId":null,"orgPath":null,"depId":430,"depName":"三公司","depDesc":"","depLevel":3,"parentId":410,"path":"0.378.410.430.","orgType":2,"creatorId":1,"createtime":"2017-03-16 16:09:34","updateId":1,"updatetime":"2017-11-17 13:27:22","sn":93,"chargeIds":"10941,10888","chargeNames":"王春生,田建力","demension":{"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}}
     * ddNo : 1
     * lineMoney : 2
     * lineMile : 23
     * linexxMile : 23
     * yyCar : 30
     * memo :
     * lineType :
     * smz : 三捷新能源-百货大市场(西客站)
     */

    private Object version;
    private Object orgId;
    private Object orgPath;
    private int lineInfoId;
    private String lineCode;
    private String lineName;
    private Object depId;
    private DepartmentBean department;
    private String ddNo;
    private String lineMoney;
    private String lineMile;
    private String linexxMile;
    private String yyCar;
    private String memo;
    private String lineType;
    private String smz;

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

    public int getLineInfoId() {
        return lineInfoId;
    }

    public void setLineInfoId(int lineInfoId) {
        this.lineInfoId = lineInfoId;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Object getDepId() {
        return depId;
    }

    public void setDepId(Object depId) {
        this.depId = depId;
    }

    public DepartmentBean getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentBean department) {
        this.department = department;
    }

    public String getDdNo() {
        return ddNo;
    }

    public void setDdNo(String ddNo) {
        this.ddNo = ddNo;
    }

    public String getLineMoney() {
        return lineMoney;
    }

    public void setLineMoney(String lineMoney) {
        this.lineMoney = lineMoney;
    }

    public String getLineMile() {
        return lineMile;
    }

    public void setLineMile(String lineMile) {
        this.lineMile = lineMile;
    }

    public String getLinexxMile() {
        return linexxMile;
    }

    public void setLinexxMile(String linexxMile) {
        this.linexxMile = linexxMile;
    }

    public String getYyCar() {
        return yyCar;
    }

    public void setYyCar(String yyCar) {
        this.yyCar = yyCar;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public String getSmz() {
        return smz;
    }

    public void setSmz(String smz) {
        this.smz = smz;
    }



    public static class DepartmentBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * depId : 430
         * depName : 三公司
         * depDesc :
         * depLevel : 3
         * parentId : 410
         * path : 0.378.410.430.
         * orgType : 2
         * creatorId : 1
         * createtime : 2017-03-16 16:09:34
         * updateId : 1
         * updatetime : 2017-11-17 13:27:22
         * sn : 93
         * chargeIds : 10941,10888
         * chargeNames : 王春生,田建力
         * demension : {"version":null,"orgId":null,"orgPath":null,"demId":1,"demName":"行政维度","demDesc":"行政维度","demType":1}
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int depId;
        private String depName;
        private String depDesc;
        private int depLevel;
        private int parentId;
        private String path;
        private int orgType;
        private int creatorId;
        private String createtime;
        private int updateId;
        private String updatetime;
        private int sn;
        private String chargeIds;
        private String chargeNames;
        private DemensionBean demension;

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

        public String getDepDesc() {
            return depDesc;
        }

        public void setDepDesc(String depDesc) {
            this.depDesc = depDesc;
        }

        public int getDepLevel() {
            return depLevel;
        }

        public void setDepLevel(int depLevel) {
            this.depLevel = depLevel;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public int getOrgType() {
            return orgType;
        }

        public void setOrgType(int orgType) {
            this.orgType = orgType;
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

        public int getSn() {
            return sn;
        }

        public void setSn(int sn) {
            this.sn = sn;
        }

        public String getChargeIds() {
            return chargeIds;
        }

        public void setChargeIds(String chargeIds) {
            this.chargeIds = chargeIds;
        }

        public String getChargeNames() {
            return chargeNames;
        }

        public void setChargeNames(String chargeNames) {
            this.chargeNames = chargeNames;
        }

        public DemensionBean getDemension() {
            return demension;
        }

        public void setDemension(DemensionBean demension) {
            this.demension = demension;
        }

        public static class DemensionBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * demId : 1
             * demName : 行政维度
             * demDesc : 行政维度
             * demType : 1
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int demId;
            private String demName;
            private String demDesc;
            private int demType;

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

            public int getDemId() {
                return demId;
            }

            public void setDemId(int demId) {
                this.demId = demId;
            }

            public String getDemName() {
                return demName;
            }

            public void setDemName(String demName) {
                this.demName = demName;
            }

            public String getDemDesc() {
                return demDesc;
            }

            public void setDemDesc(String demDesc) {
                this.demDesc = demDesc;
            }

            public int getDemType() {
                return demType;
            }

            public void setDemType(int demType) {
                this.demType = demType;
            }
        }
    }
}
