package com.smartbus.heze;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/5/11.
 */

public class TestBean implements Serializable {
    public String Text;
    public String num;
    public String type;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
