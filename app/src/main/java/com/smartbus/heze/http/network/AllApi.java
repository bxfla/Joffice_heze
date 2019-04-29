package com.smartbus.heze.http.network;


import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.fileapprove.bean.Department;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.main.bean.Banner;
import com.smartbus.heze.welcome.bean.Login;
import com.smartbus.heze.welcome.bean.Notice;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author: Allen.
 * @date: 2018/7/25
 * @description:
 */

public interface AllApi {


    /**
     * 登录
     */
    @FormUrlEncoded
    @POST(ApiAddress.login)
    Observable<Login> getLogin(@Field("username")String username, @Field("password")String password);
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

    /**
     * 获取部门列表
     */
    @GET(ApiAddress.department)
    Observable<Department> getDepartment();

    /**
     * 获取一级审批人
     */
    @GET(ApiAddress.oneperson)
    Observable<OnePerson> getOnePerson(@Query("defId") String defId);

    /**
     * 获取二级审批人
     */
    @GET(ApiAddress.twoperson)
    Observable<TwoPerson> getTwoPerson(@Query("defId") String defId,@Query("activityName") String activityName);

    /**
     * 提交预算单
     */
    @Multipart
    @POST(ApiAddress.upysd)
    Observable<String> getUpysd(@QueryMap Map<String,String> params);

//    /**
//     * 获取查询线路信息
//     */
//    @HTTP(method = "DELETE",path = ApiAddress.lineBean,hasBody = true)
//    Observable<LineBean> getLineBean(@Body Map<String, String> maps);

}
