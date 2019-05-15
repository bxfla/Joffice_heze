package com.smartbus.heze.fileapprove.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/29.
 */

public class WorkOnePersonDataBean extends DataSupport implements Serializable{

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
    private String letters;

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

    public String geteCard() {
        return eCard;
    }

    public void seteCard(String eCard) {
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

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }
}
