package com.smartbus.heze.http.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.MyApplication;
import com.smartbus.heze.http.network.AllApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description: retrofit请求工具类
 */

public class RetrofitUtil {
    /**
     * 超时时间
     */
    private static volatile RetrofitUtil mInstance;
    private AllApi allApi;
    private static Gson gson;
    /**
     * 单例封装
     *
     * @return
     */
    public static RetrofitUtil getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtil();
                    gson = new GsonBuilder().setLenient().create();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化Retrofit(城市)
     */
    public AllApi initRetrofit() {
        if (allApi == null) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(MyApplication.initOKHttp())
                    // 设置请求的域名
                    .baseUrl(ApiAddress.api)
                    // 设置解析转换工厂，用自己定义的
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            allApi = mRetrofit.create(AllApi.class);
        }
        return allApi;
    }

    /**
     * 初始化Retrofit(其他)
     */
    public AllApi initRetrofitMain() {
        if (allApi == null) {
            Retrofit mRetrofit = new Retrofit.Builder()
                    .client(MyApplication.initOKHttp())
                    // 设置请求的域名
                    .baseUrl(ApiAddress.mainApi)
                    // 设置解析转换工厂，用自己定义的
                    .addConverterFactory(GsonConverterFactory.create())
//                    .addConverterFactory(LenientGsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
            allApi = mRetrofit.create(AllApi.class);
        }
        return allApi;
    }
}
