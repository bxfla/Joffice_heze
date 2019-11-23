package com.smartbus.heze.welcome.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/2/28.
 */

public class Version implements Serializable {


    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"id":2,"changeDate":"2019-08-27","versionNo":"1.0.3","createName":"超级管理员","substance":"增加自动更新","downurl":"flow/appVersion/201908/f4fbaf4620f24a89862b9d79adb2c412.apk","qrCode":"/attachFiles/apkqrcode/20190827100518.png","type":"0","appVersionFiles":[]}
     */

    private boolean success;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * id : 2
         * changeDate : 2019-08-27
         * versionNo : 1.0.3
         * createName : 超级管理员
         * substance : 增加自动更新
         * downurl : flow/appVersion/201908/f4fbaf4620f24a89862b9d79adb2c412.apk
         * qrCode : /attachFiles/apkqrcode/20190827100518.png
         * type : 0
         * appVersionFiles : []
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int id;
        private String changeDate;
        private String versionNo;
        private String createName;
        private String substance;
        private String downurl;
        private String qrCode;
        private String type;
        private List<?> appVersionFiles;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getChangeDate() {
            return changeDate;
        }

        public void setChangeDate(String changeDate) {
            this.changeDate = changeDate;
        }

        public String getVersionNo() {
            return versionNo;
        }

        public void setVersionNo(String versionNo) {
            this.versionNo = versionNo;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getSubstance() {
            return substance;
        }

        public void setSubstance(String substance) {
            this.substance = substance;
        }

        public String getDownurl() {
            return downurl;
        }

        public void setDownurl(String downurl) {
            this.downurl = downurl;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<?> getAppVersionFiles() {
            return appVersionFiles;
        }

        public void setAppVersionFiles(List<?> appVersionFiles) {
            this.appVersionFiles = appVersionFiles;
        }
    }
}
