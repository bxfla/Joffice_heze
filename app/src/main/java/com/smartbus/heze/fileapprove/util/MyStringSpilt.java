package com.smartbus.heze.fileapprove.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27.
 */

public class MyStringSpilt {
    public List<String> stringSpiltList(String data){
        List<String> dataList = new ArrayList<>();
        String[] temp = null;
        temp = data.split(",");
        dataList = Arrays.asList(temp);
        return dataList;
    }


    public String stringSpilt(String data1){
        String id = data1.substring(0, data1.indexOf("|"));
        return id;
    }
}
