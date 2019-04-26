package com.smartbus.heze.http.base;

/**
 * Created by dell on 2017/4/25.
 */

public interface AlertDialogCallBack {
    int getData(int s);
    void confirm();
    void cancel();
}
