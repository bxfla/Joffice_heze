package com.smartbus.heze.http.network;


import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.fileapprove.bean.BackData;
import com.smartbus.heze.fileapprove.bean.BorrowAccidentWill;
import com.smartbus.heze.fileapprove.bean.CurrencyAccidentWill;
import com.smartbus.heze.fileapprove.bean.DepartBudgetWill;
import com.smartbus.heze.fileapprove.bean.Department;
import com.smartbus.heze.fileapprove.bean.DocumentLZWill;
import com.smartbus.heze.fileapprove.bean.FileCirculateWill;
import com.smartbus.heze.fileapprove.bean.HuiQianWill;
import com.smartbus.heze.fileapprove.bean.InitBackData;
import com.smartbus.heze.fileapprove.bean.NoEndPerson;
import com.smartbus.heze.fileapprove.bean.NoHandlerPerson;
import com.smartbus.heze.fileapprove.bean.NormalPerson;
import com.smartbus.heze.fileapprove.bean.OnePerson;
import com.smartbus.heze.fileapprove.bean.TwoPerson;
import com.smartbus.heze.fileapprove.bean.WillDoUp;
import com.smartbus.heze.fileapprove.bean.WorkOnePerson;
import com.smartbus.heze.fileapprove.bean.WorkPerson;
import com.smartbus.heze.main.bean.Banner;
import com.smartbus.heze.main.bean.WillDoList;
import com.smartbus.heze.welcome.bean.Login;
import com.smartbus.heze.welcome.bean.Notice;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    Observable<TwoPerson> getTwoPerson(@Query("defId") String defId,
                                       @Query("activityName") String activityName);

    /**
     * 提交预算单
     */
    @POST(ApiAddress.upysd)
    Observable<BackData> getUpysd(@QueryMap Map<String,String> params);

    /**
     * 获取内部员工
     */
    @POST(ApiAddress.workperson)
    Observable<WorkPerson> getWorkPerson();

    /**
     * 获取内部人员  包含profileId
     */
    @POST(ApiAddress.workoneperson)
    Observable<WorkOnePerson> getWorkOnePerson();

    /**
     * 获取待办列表
     */
    @GET(ApiAddress.willdolist)
    Observable<WillDoList> getWillDoList();

    /**
     * 获取会签待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<HuiQianWill> getWillDoDetail(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取部门预算待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<DepartBudgetWill> getWillDepartBudget(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取事故借款单待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<BorrowAccidentWill> getWillBorrowAccident(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取公文流转待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<DocumentLZWill> getWillDocumentLZ(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取通用借款单待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<CurrencyAccidentWill> getWillCurrencyAccident(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取部门文件传阅待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<FileCirculateWill> getFileCirculate(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取正常一级审核人
     */
    @GET(ApiAddress.normalperson)
    Observable<NormalPerson> getNormalPerson(@Query("taskId")String taskId
            , @Query("activityName")String activityName, @Query("isParentFlow")String isParentFlow);

    /**
     * 不包含end一级审核人
     */
    @GET(ApiAddress.noendperson)
    Observable<NoEndPerson> getNoEndPerson(@Query("taskId")String taskId
            , @Query("activityName")String activityName, @Query("isParentFlow")String isParentFlow);

    /**
     * 不包含end一级审核人
     */
    @GET(ApiAddress.nonextperson)
    Observable<NoHandlerPerson> getNoHandlerPerson(@Query("taskId")String taskId);

    /**
     * 待办提交
     */
    @POST(ApiAddress.willdoup)
    Observable<WillDoUp> getWillDoUp(@QueryMap Map<String,String> params);

    /**
     * 提交流程录入
     */
    @POST(ApiAddress.userdleave)
    Observable<InitBackData> getUserdLeave(@QueryMap Map<String,String> params);

//    /**
//     * 获取查询线路信息
//     */
//    @HTTP(method = "DELETE",path = ApiAddress.lineBean,hasBody = true)
//    Observable<LineBean> getLineBean(@Body Map<String, String> maps);

}
