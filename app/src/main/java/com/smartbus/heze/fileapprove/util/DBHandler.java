package com.smartbus.heze.fileapprove.util;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    public String OAQingJiaMyDetail(String turl){
        HttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> nvs = new ArrayList<NameValuePair>();
        HttpPost httpRequst = new HttpPost(turl);
//        String Session = new SharedPreferencesHelper(MyApplication.getContext(),"login").getData(MyApplication.getContext(),"session","");
//        httpRequst.setHeader("Cookie", Session);
        try {
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(nvs, "utf-8");
            httpRequst.setEntity(uefEntity);
            HttpResponse res = httpClient.execute(httpRequst);
            HttpEntity entity = res.getEntity();
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
            StringBuffer sb = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            reader.close();
             Log.i("sb=" ,sb.toString());
            JSONObject json_ = new JSONObject(sb.toString());
            if (json_ != null) {
                String data = json_+"";
                String msg = json_.get("success").toString();
                if (msg.equals("true")) {
                    return data;
                }else {
                    return "";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return "获取数据失败";
    }


}
