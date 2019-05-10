package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/2/27.
 */

public class FileData implements Serializable {

    /**
     * success : true
     * data : {"version":null,"orgId":null,"orgPath":null,"fileId":7992,"fileName":"ERP各地区访问地址及密码.txt","filePath":"flow/201902/82c11bb26780432ea577b72352da410f.txt","createtime":"2019-02-27 15:57:46","ext":"txt","fileType":"flow","note":"455.0 bytes","creator":"刘望","creatorId":9417,"totalBytes":455,"delFlag":0,"globalType":null,"id":7992,"firstKeyColumnName":"fileId"}
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
         * fileId : 7992
         * fileName : ERP各地区访问地址及密码.txt
         * filePath : flow/201902/82c11bb26780432ea577b72352da410f.txt
         * createtime : 2019-02-27 15:57:46
         * ext : txt
         * fileType : flow
         * note : 455.0 bytes
         * creator : 刘望
         * creatorId : 9417
         * totalBytes : 455
         * delFlag : 0
         * globalType : null
         * id : 7992
         * firstKeyColumnName : fileId
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int fileId;
        private String fileName;
        private String filePath;
        private String createtime;
        private String ext;
        private String fileType;
        private String note;
        private String creator;
        private int creatorId;
        private int totalBytes;
        private int delFlag;
        private Object globalType;
        private int id;
        private String firstKeyColumnName;

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

        public int getFileId() {
            return fileId;
        }

        public void setFileId(int fileId) {
            this.fileId = fileId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getExt() {
            return ext;
        }

        public void setExt(String ext) {
            this.ext = ext;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public int getTotalBytes() {
            return totalBytes;
        }

        public void setTotalBytes(int totalBytes) {
            this.totalBytes = totalBytes;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public Object getGlobalType() {
            return globalType;
        }

        public void setGlobalType(Object globalType) {
            this.globalType = globalType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstKeyColumnName() {
            return firstKeyColumnName;
        }

        public void setFirstKeyColumnName(String firstKeyColumnName) {
            this.firstKeyColumnName = firstKeyColumnName;
        }
    }
}
