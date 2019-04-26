package com.smartbus.heze.http.network;


import com.smartbus.heze.MyApplication;
import com.smartbus.heze.http.utils.SharePreferencesUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public class CookiesSaveInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            String header =originalResponse.header("Set-Cookie");
            SharePreferencesUtils.setString(MyApplication.myApp,"cookiess",header);
        }
        return originalResponse;
    }

}
