package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/9.
 */

public class NormalPerson implements Serializable {

    /**
     * success : true
     * data : [{"route":"to 总经理","role":"总经理","type":"task","userNames":"1","userCodes":"超级管理员"}]
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

    public static class DataBean {
        /**
         * route : to 总经理
         * role : 总经理
         * type : task
         * userNames : 1
         * userCodes : 超级管理员
         */

        private String route;
        private String role;
        private String type;
        private String userNames;
        private String userCodes;

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUserNames() {
            return userNames;
        }

        public void setUserNames(String userNames) {
            this.userNames = userNames;
        }

        public String getUserCodes() {
            return userCodes;
        }

        public void setUserCodes(String userCodes) {
            this.userCodes = userCodes;
        }
    }
}
