package com.smartbus.heze.fileapprove.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/29.
 */

public class DepartmentDataBean extends DataSupport implements Serializable{
    /**
     * depId : 479
     * depName : 小车班
     */

    private String depId;
    private String depName;
    private String letters;

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }
}
