package com.smartbus.heze.http.network;


import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.main.bean.Banner;
import com.smartbus.heze.welcome.bean.Login;
import com.smartbus.heze.welcome.bean.Notice;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public interface AllApi {


    /**
     * 登录
     */
    @POST(ApiAddress.login)
    Observable<Login> getLogin(@Query("username")String username,@Query("password")String password);
    /**
     * 获取公告列表
     */
    @GET(ApiAddress.notice)
    Observable<Notice> getNoticeList();

    /**
     * 获取banner
     */
    @GET(ApiAddress.banner)
    Observable<Banner> getBanner();

//    /**
//     * 获取查询线路信息
//     */
//    @HTTP(method = "DELETE",path = ApiAddress.lineBean,hasBody = true)
//    Observable<LineBean> getLineBean(@Body Map<String, String> maps);

}
