package com.smartbus.heze.http.network;


import com.smartbus.heze.MyApplication;
import com.smartbus.heze.http.utils.SharePreferencesUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author: Allen.
 * @date: 2018/7/27
 * @description: 读取cookie
 */

public class CookieReadInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Cookie", SharePreferencesUtils.getString(MyApplication.myApp, "cookiess", ""));
        return chain.proceed(builder.build());
    }
}
