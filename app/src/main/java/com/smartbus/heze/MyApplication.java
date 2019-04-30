package com.smartbus.heze;

import org.litepal.LitePalApplication;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description: application
 */

public class MyApplication extends LitePalApplication {
    public static MyApplication myApp;
    public static final int TIMEOUT = 60;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }


}
