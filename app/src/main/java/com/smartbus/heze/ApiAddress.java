package com.smartbus.heze;

/**
 * @description: 所有接口地址集
 */

public class ApiAddress {
    public final static String mainApi = "http://192.168.2.106:8080/joffice21/" ;
//    public final static String mainApi = "http://120.192.74.58:8080/joffice/" ;
//    public final static String mainApi = "http://192.168.2.117:8080/joffice21/" ;

    /***********************首页*******************************/
    //登录
    public final static String login = "mobile.do";
    //公告列表
    public final static String notice = "info/newAppNews.do";
    //banner
    public final static String banner = "LineServer/docManage/DocManage!jsonModule.action";
    //部门列表
    public final static String department = "system/getAppDepStoreOrganization.do";
    //一级审批人
    public final static String oneperson = "flow/startTransProcessActivity.do";
    //二级审批人
    public final static String twoperson = "flow/mobileUsersProcessActivity.do";
    //提交预算单
    public final static String upysd = "flow/saveProcessActivity.do";
    //获取内部员工
    public final static String workperson = "system/getAppAllUserAppUser.do";
    //获取内部人员  包含
    public final static String workoneperson = "hrm/profileListEmpProfile.do?iswork=1";
    //文件上传
    public final static String dataup = "flow/upLoadImageProcessActivity.do";
    //待办列表
    public final static String willdolist = "flow/listTask.do";
    //待办详情
    public final static String willdodetail = "htmobile/moblieGetTask.do";
    //正常一级审核人
    public final static String normalperson = "flow/mobileOuterTransProcessActivity.do";
    //没有end的一级审核人
    public final static String noendperson = "flow/mobileUsersProcessActivity.do";
    //处理完不让其他人处理的一级审核人
    public final static String nonextperson = "flow/checkTask.do";
    //待办数据提交
    public final static String willdoup = "flow/nextProcessActivity.do";
    //文件
    public static final String  filedata = "flow/getFileProcessActivity.do";
    //下载文件
    public static final String  downloadfile = mainApi+"attachFiles/";
    //流程录入
    public static final String  userdleave = "hrm/mobileSaveLeaveDays.do";
    //加班录入
    public static final String  addwork = "hrm/mobileSaveAddClassInfo.do";
    //修改发布状态
    public static final String  checktype = "hrm/updateLeaveDays.do";
    //修改加班发布状态
    public static final String  addworkchecktype = "hrm/updateAddClassInfo.do";
    //修改补勤发布状态
    public static final String  oldworkchecktype = "hrm/updateFillAttendance.do";
    //加班录入
    public static final String  oldwork = "hrm/mobileSaveFillAttendance.do";
    //值班录入
    public static final String  atwork = "hrm/mobileSaveFillOnDuty.do";
    //修改值班发布状态
    public static final String  atworkchecktype = "hrm/updateFillOnDuty.do";
    //值班录入
    public static final String  checkwork = "hrm/mobileSaveFillOff.do";
    //修改值班发布状态
    public static final String  checkworkchecktype = "hrm/updateFillOff.do";
    //稽查获取线路编号
    public static final String  linecode = "system/getLineStoreAllLineInfo.do?_dc=1558314543022";
    //稽查获取车辆编号
    public static final String  carcode = "admin/getBusBydepCar.do?_dc=1558323024913";
    //稽查获取人员编号
    public static final String  usercode = "hrm/profileByPosDepEmpProfile.do";
    //稽查获取检查人
    public static final String  checkperson = "hrm/profileDepListEmpProfile.do?_dc=1558332277819";
    //稽查获取检查项
    public static final String  checkitem = "starkh/getProjectRewardPunishmentSurfaceType.do?categoryCode=4485&&flag=1&_dc=1558335251824";
    //日常稽查数据提交
    public static final String  updatarcjc = "starkh/savePhoneJckrichangJc.do";
    //日常稽查记录
    public static final String  rcjchistory = "starkh/getListPhoneJckrichangJc.do";
    //稽查获取安全检查项
    public static final String  safeitem = "starkh/getProjectRewardPunishmentSurfaceType.do?categoryCode=4451&_dc=1558421560835";
    //车辆安全记录
    public static final String  saferhistory = "busmanager/getListByPhoneAnquansheshiJc.do";
    //安全稽查数据提交
    public static final String  updatasafe = "busmanager/savePhoneAnquansheshiJc.do";
    //车辆巡检检查项
    public static final String  carcheckitem = "starkh/getProjectRewardPunishmentSurfaceType.do?categoryCode=4476&&flag=1&_dc=1558487740645";
    //车辆巡检记录
    public static final String  carcheckhistory = "repair/getListByPhoneDiancherichangJc.do";
    //安全稽查数据提交
    public static final String  updatacarcheck = "repair/savePhoneDiancherichangJc.do";
    //车辆卫生检查项
    public static final String  healthitem = "starkh/getProjectRewardPunishmentSurfaceType.do?categoryCode=4468,4467&_dc=1558495007715";
    //车辆卫生记录
    public static final String  healthhistory = "starkh/getListPhoneVehicleCarJc.do";
    //安全稽查数据提交
    public static final String  updatagealth = "starkh/savePhoneVehicleCarJc.do";
    //oa获取单号
    public static final String  getoano = "system/genNumberPhoneSerialNumber.do";
    //oa单发布
    public static final String  oaup = "system/savePhoneWorkTransferSheet.do";
    //oa处理前图片上传
    public static final String  upimagebef = "system/uploadImageBeforeCLWorkTransferSheet.do";
    //oa处理后图片上传
    public static final String  upimageold = "system/uploadImageAfterCLWorkTransferSheet.do";
    //oa未审核列表
    public static final String  willlist = "system/getListPhoneWorkTransferSheet.do";
    //事故关联数据
    public final static String aboutdata = "admin/getBusLineAllNewCar.do";
    //事故数据提交
    public final static String faultupdata = "busmanager/savePhoneAccidentBasicInformation.do";
    //事故处理前图片上传
    public static final String  faultupimage = "busmanager/upLoadImageAccidentBasicInformation.do";


    //考试资料左侧
    public static final String  examdataleft = "system/treePhoneGlobalType.do";
    //考试资料右侧
    public static final String  examdataright = "system/listAllByPhoneFileAttach.do";
    //在线考试列表
    public static final String  onlinelist = "staffzone/listExaminationManagement.do";
    //在线考试试题
    public static final String  onlinedata = "staffzone/startPhoneExaminationManagement.do";
    //在线考试交卷
    public static final String  onlineup = "staffzone/endPhoneExaminationManagement.do";
    //获取考试成绩
    public static final String  getscore = "staffzone/ListPhonePerformanceManagement.do";

    //Ic卡没收根据司机关联线路
    public static final String  icaboutline = "starkh/getLineDriverLine.do";
    //Ic卡获取类别
    public static final String  cartype = "system/getIcTypeDictionary.do";
    //Ic卡没收提交
    public static final String  upcardata = "helpmgr/saveIcPhoneIcCardConfiscate.do";

    //安保图片上传
    public static final String  saferimageup = "helpmgr/upLoadImageSecurityMgr.do";
    //安保数据上传
    public static final String  saferup = "helpmgr/savePhoneSecurityMgr.do";

    //广告数据上传
    public static final String  adverup = "helpmgr/savePhoneAdvertiserMsg.do";

    //失物图片上传
    public static final String  lostimageup = "staffzone/upLoadImageLostArticle.do";
    //失物数据上传
    public static final String  lostup = "staffzone/saveNewLostArticle.do";


}
