package com.smartbus.heze.checkup.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/20.
 */

public class CheckPersonData extends DataSupport implements Serializable {

    /**
     * position : 科员
     * userCode : 0410
     * positionDate : 2015-03-18
     * profileId : 20792
     * vehicleClass : c1
     * eCard : 102109
     * depName : 总务科
     * mnemonicCard : LQB
     * depId : 452
     * fullname : 刘钦邦
     */

    private String position;
    private String userCode;
    private String positionDate;
    private String profileId;
    private String vehicleClass;
    private String eCard;
    private String depName;
    private String mnemonicCard;
    private String depId;
    private String fullname;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(String positionDate) {
        this.positionDate = positionDate;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getECard() {
        return eCard;
    }

    public void setECard(String eCard) {
        this.eCard = eCard;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getMnemonicCard() {
        return mnemonicCard;
    }

    public void setMnemonicCard(String mnemonicCard) {
        this.mnemonicCard = mnemonicCard;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
