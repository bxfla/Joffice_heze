package com.smartbus.heze.http.network;


import com.smartbus.heze.ApiAddress;
import com.smartbus.heze.checkup.bean.CarCheckHistory;
import com.smartbus.heze.checkup.bean.CarCheckHistoryItem;
import com.smartbus.heze.checkup.bean.CarCheckItem;
import com.smartbus.heze.checkup.bean.CarCode;
import com.smartbus.heze.checkup.bean.CheckItem;
import com.smartbus.heze.checkup.bean.CheckPerson;
import com.smartbus.heze.checkup.bean.HealthHistory;
import com.smartbus.heze.checkup.bean.HealthHistoryItem;
import com.smartbus.heze.checkup.bean.HealthItem;
import com.smartbus.heze.checkup.bean.LineCode;
import com.smartbus.heze.checkup.bean.RCJCHistory;
import com.smartbus.heze.checkup.bean.RCJCHistoryItem;
import com.smartbus.heze.checkup.bean.SafeHistoryItem;
import com.smartbus.heze.checkup.bean.SaferHistory;
import com.smartbus.heze.checkup.bean.UpData;
import com.smartbus.heze.checkup.bean.UserCode;
import com.smartbus.heze.exam.bean.ClassMileage;
import com.smartbus.heze.exam.bean.ExaminationData;
import com.smartbus.heze.exam.bean.InComeRank;
import com.smartbus.heze.exam.bean.LearnLeft;
import com.smartbus.heze.exam.bean.LearnRight;
import com.smartbus.heze.exam.bean.OilConsumption;
import com.smartbus.heze.exam.bean.OnLineList;
import com.smartbus.heze.exam.bean.OnLineUp;
import com.smartbus.heze.exam.bean.RewardPenalties;
import com.smartbus.heze.exam.bean.Score;
import com.smartbus.heze.fault.bean.AboutData;
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
import com.smartbus.heze.main.bean.OaWillDo;
import com.smartbus.heze.main.bean.WillDoList;
import com.smartbus.heze.oaflow.bean.AddWorkWill;
import com.smartbus.heze.oaflow.bean.AtWorkWill;
import com.smartbus.heze.oaflow.bean.CheckType;
import com.smartbus.heze.oaflow.bean.OldWorkWill;
import com.smartbus.heze.oaflow.bean.UserdLeaveWill;
import com.smartbus.heze.oasheet.bean.OANO;
import com.smartbus.heze.other.bean.CarType;
import com.smartbus.heze.other.bean.IcAboutLine;
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
     * 提交请假预算单
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
     * 提交请假流程录入
     */
    @POST(ApiAddress.userdleave)
    Observable<InitBackData> getUserdLeave(@QueryMap Map<String,String> params);

    /**
     * 提交加班流程录入
     */
    @POST(ApiAddress.addwork)
    Observable<InitBackData> getAddWork(@QueryMap Map<String,String> params);

    /**
     * 提交补勤流程录入
     */
    @POST(ApiAddress.oldwork)
    Observable<InitBackData> getOldWork(@QueryMap Map<String,String> params);

    /**
     * 提交值班流程录入
     */
    @POST(ApiAddress.atwork)
    Observable<InitBackData> getAtWork(@QueryMap Map<String,String> params);

    /**
     * 提交调休流程录入
     */
    @POST(ApiAddress.checkwork)
    Observable<InitBackData> getCheckWork(@QueryMap Map<String,String> params);

    /**
     * 修改发布状态
     */
    @GET(ApiAddress.checktype)
    Observable<CheckType> getCheckType(@Query("runId")String runId, @Query("vocationId")String vocationId);

    /**
     * 修改加班发布状态
     */
    @GET(ApiAddress.addworkchecktype)
    Observable<CheckType> getAddCheckType(@Query("runId")String runId, @Query("addClassId")String vocationId);

    /**
     * 修改补勤发布状态
     */
    @GET(ApiAddress.atworkchecktype)
    Observable<CheckType> getAtCheckType(@Query("runId")String runId, @Query("id")String vocationId);

    /**
     * 修改调休发布状态
     */
    @GET(ApiAddress.checkworkchecktype)
    Observable<CheckType> getCheckCheckType(@Query("runId")String runId, @Query("id")String vocationId);

    /**
     * 修改补勤发布状态
     */
    @GET(ApiAddress.oldworkchecktype)
    Observable<CheckType> getOldCheckType(@Query("runId")String runId, @Query("id")String vocationId);


    /**
     * 获取请假待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<UserdLeaveWill> getWillUserdLeave(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取加班待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<AddWorkWill> getWillAddWork(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取补勤待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<OldWorkWill> getWillOldWork(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);

    /**
     * 获取值班待办详情
     */
    @GET(ApiAddress.willdodetail)
    Observable<AtWorkWill> getWillAtWork(@Query("activityName")String activityName
            , @Query("taskId")String taskId, @Query("defId")String defId);


    /**
     * 稽查获取线路编号
     */
    @GET(ApiAddress.linecode)
    Observable<LineCode> getLineCode();

    /**
     * 稽查获取车辆编号
     */
    @GET(ApiAddress.carcode)
    Observable<CarCode> getCarCode();

    /**
     * 稽查获取人员编号
     */
    @GET(ApiAddress.usercode)
    Observable<UserCode> getUserCode();

    /**
     * 稽查获取检查人
     */
    @GET(ApiAddress.checkperson)
    Observable<CheckPerson> getCheckPerson();

    /**
     * 稽查获取检查项
     */
    @GET(ApiAddress.checkitem)
    Observable<CheckItem> getCheckItem();

    /**
     * 日常稽查检查记录
     */
    @FormUrlEncoded
    @POST(ApiAddress.rcjchistory)
    Observable<RCJCHistory> getRCJCHistory(@Field("startDate") String startDate
            , @Field("endDate")String endDate
            , @Field("carNo")String carNo);

    /**
     * 车辆巡检检查记录检查项
     */
    @GET(ApiAddress.rcjchistory)
    Observable<RCJCHistoryItem> getRCJCHistoryItem(@Query("id")String id);

    /**
     * 日常稽查检查项提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.updatarcjc)
    Observable<UpData> getUpData(@Field("data")String data,@Field("scoreData")String scoreData
                                 ,@Field("jckrichangJc.kaoheDate")String kaoheDate
                                ,@Field("jckrichangJc.lineCode")String lineCode
            ,@Field("jckrichangJc.carNo")String carNo
            ,@Field("jckrichangJc.busCode")String busCode
            ,@Field("jckrichangJc.depId")String depId
            ,@Field("jckrichangJc.depName")String depName
            ,@Field("jckrichangJc.driverName")String driVerName
            ,@Field("jckrichangJc.driverId")String driverId
            ,@Field("jckrichangJc.examiner")String examiner
            ,@Field("jckrichangJc.note")String note
            ,@Field("jckrichangJc.vehicleClass")String vehicleClass
            ,@Field("jckrichangJc.positionDate")String positionDate);

    /**
     * 稽查获取安全检查项
     */
    @GET(ApiAddress.safeitem)
    Observable<SafeHistoryItem> getSafeItem();

    /**
     * 车辆巡检检查记录
     */
    @FormUrlEncoded
    @POST(ApiAddress.saferhistory)
    Observable<SaferHistory> getSaferHistory(@Field("startDate") String startDate
            , @Field("endDate")String endDate
            , @Field("carNo")String carNo);
    /**
     * 车辆巡检检查记录检查项
     */
    @GET(ApiAddress.saferhistory)
    Observable<CarCheckHistoryItem> getSaferHistoryItem(@Query("id")String id);

    /**
     * 安全稽查检查项提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.updatasafe)
    Observable<UpData> getUpData(@Field("data")String data,@Field("scoreData")String scoreData
            ,@Field("anquansheshiJc.kaoheDate")String kaoheDate
            ,@Field("anquansheshiJc.lineCode")String lineCode
            ,@Field("anquansheshiJc.carNo")String carNo
            ,@Field("anquansheshiJc.busCode")String busCode
            ,@Field("anquansheshiJc.depId")String depId
            ,@Field("anquansheshiJc.depName")String depName
            ,@Field("anquansheshiJc.driverName")String driVerName
            ,@Field("anquansheshiJc.driverId")String driverId
            ,@Field("anquansheshiJc.examiner")String examiner
            ,@Field("anquansheshiJc.note")String note);


    /**
     * 车辆巡检检查项
     */
    @GET(ApiAddress.carcheckitem)
    Observable<CarCheckItem> getCarCheckItem(@Query("categoryCode")String categoryCode,@Query("flag")String flag);
    /**
     * 车辆巡检检查记录
     */
    @FormUrlEncoded
    @POST(ApiAddress.carcheckhistory)
    Observable<CarCheckHistory> getCarCheckHistory(@Field("startDate") String startDate
            , @Field("endDate")String endDate
            , @Field("carNo")String carNo);
    /**
     * 车辆巡检检查记录检查项
     */
    @GET(ApiAddress.carcheckhistory)
    Observable<CarCheckHistoryItem> getCarCheckHistoryItem(@Query("id")String id);
    /**
     * 车辆巡检检查项提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.updatacarcheck)
    Observable<UpData> getUpCarCheckData(@Field("data")String data,@Field("scoreData")String scoreData
            ,@Field("diancherichangJc.kaoheDate")String kaoheDate
            ,@Field("diancherichangJc.lineCode")String lineCode
            ,@Field("diancherichangJc.carNo")String carNo
            ,@Field("diancherichangJc.busCode")String busCode
            ,@Field("diancherichangJc.depId")String depId
            ,@Field("diancherichangJc.depName")String depName
            ,@Field("diancherichangJc.driverName")String driVerName
            ,@Field("diancherichangJc.driverId")String driverId
            ,@Field("diancherichangJc.examiner")String examiner
            ,@Field("diancherichangJc.note")String note
            ,@Field("categoryCode")String categoryCode);

    /**
     * 稽查卫生检查项
     */
    @GET(ApiAddress.healthitem)
    Observable<HealthItem> getHealthItem();

    /**
     * 稽查卫生检查记录
     */
    @FormUrlEncoded
    @POST(ApiAddress.healthhistory)
    Observable<HealthHistory> getHealthHistory(@Field("startDate") String startDate
            , @Field("endDate")String endDate
            , @Field("carNo")String carNo);

    /**
     * 车辆巡检检查记录检查项
     */
    @GET(ApiAddress.healthhistory)
    Observable<HealthHistoryItem> getHealthHistoryItem(@Query("id")String id);
    /**
     * 稽查卫生检查项提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.updatagealth)
    Observable<UpData> getHealthUpData(@Field("data")String data,@Field("scoreData")String scoreData
            ,@Field("kaoheDate")String kaoheDate
            ,@Field("lineCode")String lineCode
            ,@Field("carNo")String carNo
            ,@Field("busCode")String busCode
            ,@Field("depId")String depId
            ,@Field("depName")String depName
            ,@Field("driverName")String driVerName
            ,@Field("driverId")String driverId
            ,@Field("examiner")String examiner
            ,@Field("note")String note
            ,@Field("positionDate")String positionDate);


    /**
     * 获取OA单号
     */
    @GET(ApiAddress.getoano)
    Observable<OANO> getOaNo(@Query("alias")String alias);

    /**
     * OA单发布
     */
    @FormUrlEncoded
    @POST(ApiAddress.oaup)
    Observable<UpData> getUpOa(@Field("flag") String flag,@Field("workCode")String no,@Field("clDep")String overDepName
            ,@Field("clDepId")String overDepId,@Field("csDep")String sendDepName,@Field("csDepId")String sendDepId
            ,@Field("clRen")String sendPerson,@Field("fqDate")String upDate,@Field("fqsj")String upTime
            ,@Field("jzDate")String endTime,@Field("title")String title,@Field("type")String type
            ,@Field("content")String content,@Field("jlPhoto")String fileName);

    /**
     * 获取OA未审核列表
     */
    @GET(ApiAddress.willlist)
    Observable<OaWillDo> getOaWillDo(@Query("userName")String userName
            ,@Query("status")String status
            ,@Query("shStatus")String shStatus
            ,@Query("start")int start,@Query("limit")int limit);

    /**
     * OA单解决提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.oaup)
    Observable<UpData> getUpOaDetail(@Field("flag") String flag,@Field("status")String status
            ,@Field("clResult")String clResult,@Field("clPhoto")String clPhoto
            ,@Field("workId")String workId,@Field("shStatus")String shStatus,@Field("shResult")String shResult);

    /**
     * 事故关联数据
     */
    @GET(ApiAddress.aboutdata)
    Observable<AboutData> getAboutData(@Query("busCode")String busCode
            , @Query("rq")String rq, @Query("sj")String sj);

    /**
     * 事故关联数据提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.faultupdata)
    Observable<UpData> getUpData(@Field("FormUrlEncoded")String FormUrlEncoded
            , @Field("atAtDate")String atAtDate
            , @Field("atTime")String atTime
            , @Field("busCode")String busCode
            , @Field("carNo")String carNo
            , @Field("lineCode")String lineCode
            , @Field("weather")String weather
            , @Field("acPlaceCategory")String acPlaceCategory
            , @Field("atType")String atType
            , @Field("atLiability")String atLiability
            , @Field("acNature")String acNature
            , @Field("atCategory")String atCategory
            , @Field("userCode")String userCode
            , @Field("injuredPeople")String injuredPeople
            , @Field("deathPeople")String deathPeople
            , @Field("atPlace")String atPlace
            , @Field("atReason")String atReason
            , @Field("depId")String depId
            , @Field("depName")String depName
            , @Field("atPhoto")String atPhoto
            , @Field("mileType")String mileType);



    /**
     * 学习资料左侧
     */
    @GET(ApiAddress.examdataleft)
    Observable<LearnLeft> getLearnLeft();

    /**
     * 学习资料右侧
     */
    @GET(ApiAddress.examdataright)
    Observable<LearnRight> getLearnRight(@Query("fileType")String fileType);

    /**
     * 获取在线考试列表
     */
    @GET(ApiAddress.onlinelist)
    Observable<OnLineList> getOnLineList(@Query("examinationType") String examinationType
                                ,@Query("startType") String startType
                                ,@Query("userName") String userName);

    /**
     * 获取在线考试试题
     */
    @GET(ApiAddress.onlinedata)
    Observable<ExaminationData> getExaminationData(@Query("id") String id
            , @Query("type") String type
            , @Query("userName") String userName);

    /**
     * 获取在线考试交卷数据
     */
    @FormUrlEncoded
    @POST(ApiAddress.onlineup)
    Observable<OnLineUp> getOnLineUp(@Field("userName") String userName
            , @Field("type") String type
            , @Field("data") String answer);


    /**
     * Ic卡没收根据司机关联线路
     */
    @GET(ApiAddress.icaboutline)
    Observable<IcAboutLine> getIcAboutLine(@Query("driverCode")String driverCode);

    /**
     * 获取在线考试成绩
     */
    @GET(ApiAddress.getscore)
    Observable<Score> getScore(@Query("userName") String userName);

    /**
     * 获取卡类别
     */
    @GET(ApiAddress.cartype)
    Observable<CarType> getCarType();

    /**
     * 提交没收卡数据
     */
    @FormUrlEncoded
    @POST(ApiAddress.upcardata)
    Observable<UpData> getUpData(@Field("useName")String userName,@Field("driverName") String driverName
            ,@Field("driverCode") String driverCode,@Field("lineCode") String lineCode
            ,@Field("cardId") String cardId,@Field("cardType") String cardType
            ,@Field("money") String money,@Field("reasons") String reasons
           ,@Field("date") String date,@Field("memo") String memo);

    /**
     * 安保数据提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.saferup)
    Observable<UpData> getSaferUpData(@Field("useName")String userName,@Field("apPlace") String apPlace
            ,@Field("apType") String apType,@Field("apDate") String apDate
            ,@Field("apReason") String apReason,@Field("apPhoto") String apPhoto);

    /**
     * 广告数据提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.adverup)
    Observable<UpData> getAdverUpData(@Field("company")String company,@Field("contacts") String contacts
            ,@Field("number") String number,@Field("address") String address
            ,@Field("memo") String memo);

    /**
     * 失物数据提交
     */
    @FormUrlEncoded
    @POST(ApiAddress.lostup)
    Observable<UpData> getLostUpData(@Field("userName")String userName, @Field("createDate")String createDate
            , @Field("createTime")String createTime, @Field("lineCode")String lineCode
            , @Field("driverName")String driverName, @Field("receiveDate")String receiveDate
            , @Field("receiveTime")String receiveTime, @Field("ownerName")String ownerName
            , @Field("ownerPhone")String ownerPhone, @Field("returnMode")String returnMode
            , @Field("ownerCertificates")String ownerCertificates, @Field("returnStatus")String returnStatus
            , @Field("situation")String situation, @Field("remarks")String remarks
            , @Field("photo")String photo);


    /**
     * 收入排名
     */
    @GET(ApiAddress.incomerank)
    Observable<InComeRank> getInComeRank(@Query("ksDate")String ksDate,@Query("jsDate")String jsDate);

    /**
     * 获取班次历程
     */
    @GET(ApiAddress.classmileage)
    Observable<ClassMileage> getclassmileage(@Query("ksDate")String ksDate, @Query("jsDate")String jsDate);

    /**
     * 获取奖罚情况
     */
    @GET(ApiAddress.rewardspenalties)
    Observable<RewardPenalties> getrewardspenalties(@Query("ksDate")String ksDate, @Query("jsDate")String jsDate);

    /**
     * 获取油耗情况
     */
    @GET(ApiAddress.oilconsumption)
    Observable<OilConsumption> getoilconsumption(@Query("Q_createDate_S_GE")String Q_createDate_S_GE, @Query("Q_createDate_S_LE")String Q_createDate_S_LE);
}
