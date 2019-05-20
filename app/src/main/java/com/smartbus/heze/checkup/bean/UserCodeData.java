package com.smartbus.heze.checkup.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/20.
 */

public class UserCodeData extends DataSupport implements Serializable {

    /**
     * sex : 男
     * idCard : 37290119590812063X
     * userCode : 0257
     * positionDate : 1987-02-01
     * vehicleClass :
     * eCard : 102743
     * depName : 充电中心
     * mnemonicCard : ASL
     * depId : 470
     * nowWorkDate : {"date":1,"day":0,"hours":0,"minutes":0,"month":1,"nanos":0,"seconds":0,"time":539107200000,"timezoneOffset":-480,"year":87}
     * fullname : 安守亮
     */

    private String sex;
    private String idCard;
    private String userCode;
    private String positionDate;
    private String vehicleClass;
    private String eCard;
    private String depName;
    private String mnemonicCard;
    private int depId;
    private NowWorkDateBean nowWorkDate;
    private String fullname;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public NowWorkDateBean getNowWorkDate() {
        return nowWorkDate;
    }

    public void setNowWorkDate(NowWorkDateBean nowWorkDate) {
        this.nowWorkDate = nowWorkDate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public static class NowWorkDateBean {
        /**
         * date : 1
         * day : 0
         * hours : 0
         * minutes : 0
         * month : 1
         * nanos : 0
         * seconds : 0
         * time : 539107200000
         * timezoneOffset : -480
         * year : 87
         */

        private int date;
        private int day;
        private int hours;
        private int minutes;
        private int month;
        private int nanos;
        private int seconds;
        private long time;
        private int timezoneOffset;
        private int year;

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getNanos() {
            return nanos;
        }

        public void setNanos(int nanos) {
            this.nanos = nanos;
        }

        public int getSeconds() {
            return seconds;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

        public void setTimezoneOffset(int timezoneOffset) {
            this.timezoneOffset = timezoneOffset;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}
