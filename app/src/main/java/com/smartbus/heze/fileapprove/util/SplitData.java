package com.smartbus.heze.fileapprove.util;

import com.smartbus.heze.MyApplication;
import com.smartbus.heze.SharedPreferencesHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    public String SplitUpData1(String s,String s1){
        String userId = new SharedPreferencesHelper(MyApplication.getContext(),"login")
                .getData(MyApplication.getContext(),"userId","");
        String userName = new SharedPreferencesHelper(MyApplication.getContext(),"login")
                .getData(MyApplication.getContext(),"userName1","");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String time = simpleDateFormat.format(date);

        JSONArray jsonArray = new JSONArray();
        String data = "";
        try {
            if (s1!=null&&!s1.equals("")){
                JSONArray jsonArray1 = new JSONArray(s1);
                for (int i = 0;i<jsonArray1.length();i++){
                    JSONObject jsonObject1 = jsonArray1.getJSONObject(i);
                    String sData = jsonObject1.getString("v");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("ui",userId);
                    jsonObject.put("un",userName);
                    jsonObject.put("c",time);
                    jsonObject.put("v",sData);
                    jsonArray.put(jsonObject);
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("ui",userId);
            jsonObject.put("un",userName);
            jsonObject.put("c",time);
            jsonObject.put("v",s);
            jsonArray.put(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        data = jsonArray.toString();
        return data;
    }

    public String getStringData(String data){
        try {
            JSONArray jsonArray = new JSONArray(data);
            JSONObject jsonObject = jsonArray.getJSONObject(jsonArray.length()-1);
            String sData = jsonObject.getString("v");
            return sData;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public List<String> stringSpiltList(String data){
        List<String> dataList = new ArrayList<>();
        String [] temp = null;
        temp = data.split(",");
        dataList = Arrays.asList(temp);
        return dataList;
    }

    public String stringSpilt(String data1){
        String id = data1.substring(0, data1.indexOf("|"));
        return id;
    }
}
