package com.smartbus.heze;

/**
 * @author: Allen.
 * @date: 2018/3/8
 * @description: 所有接口地址集
 */

public class ApiAddress {

    public final static String mainApi = "http://192.168.2.132:8080/joffice21/" ;
//    public final static String mainApi = "http://120.192.74.58:8080/joffice/" ;

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

}
