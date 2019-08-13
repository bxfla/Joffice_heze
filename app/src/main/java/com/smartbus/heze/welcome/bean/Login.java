package com.smartbus.heze.welcome.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/26.
 */

public class Login implements Serializable {

    /**
     * success : true
     * username : 施鹏
     * userId : 9371
     * userCode : 2100
     * depId : 500
     */

    private boolean success;
    private String username;
    private String userId;
    private String userCode;
    private String depId;
    private String positionStatus;

    public String getPositionStatus() {
        return positionStatus;
    }

    public void setPositionStatus(String positionStatus) {
        this.positionStatus = positionStatus;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }
}
