package com.smartbus.heze.fileapprove.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */

public class TwoPerson implements Serializable {

    /**
     * success : true
     * data : [{"role":"部门负责人","userNames":"9354","userCodes":"欧阳晓林","route":"","type":""}]
     * isShow : true
     */

    private boolean success;
    private String isShow;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * role : 部门负责人
         * userNames : 9354
         * userCodes : 欧阳晓林
         * route :
         * type :
         */

        private String role;
        private String userNames;
        private String userCodes;
        private String route;
        private String type;

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
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

        public String getRoute() {
            return route;
        }

        public void setRoute(String route) {
            this.route = route;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
