package com.smartbus.heze.fileapprove.util;

import com.smartbus.heze.MyApplication;
import com.smartbus.heze.SharedPreferencesHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2019/5/6.
 */

public class SplitData {
    public String SplitUpData(String s){
        String userId = new SharedPreferencesHelper(MyApplication.getContext(),"login")
                .getData(MyApplication.getContext(),"userId","");
        String userName = new SharedPreferencesHelper(MyApplication.getContext(),"login")
                .getData(MyApplication.getContext(),"userName1","");
        JSONObject jsonObject = new JSONObject();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String time = simpleDateFormat.format(date);
        String data = "";
        try {
            jsonObject.put("ui",userId);
            jsonObject.put("un",userName);
            jsonObject.put("c",time);
            jsonObject.put("v",s);
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            data = jsonArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
