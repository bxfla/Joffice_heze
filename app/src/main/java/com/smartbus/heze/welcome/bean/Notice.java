package com.smartbus.heze.welcome.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/11.
 */

public class Notice extends DataSupport implements Serializable {

    /**
     * success : true
     * totalCounts : 3
     * result : [{"newsId":"42","subject":"测试","sectionId":"11","author":"警察局","createtime":"2019-04-25 00:00:00.0","replyCounts":"0","viewCounts":"3","issuer":"超级管理员","content":"\n\t菜市场收藏市场收藏收藏市场\n","status":"1","place":"ERP系统, 手机APP"},{"newsId":"35","subject":"关于2018年春节放假的通知","sectionId":"11","author":"办公室","createtime":"2018-02-09 00:00:00.0","replyCounts":"0","viewCounts":"1","issuer":"李德全","content":"\n\t关于2018年春节放假的通知\n\n\t \n\n\t各科室、各单位：\n\n\t根据市交通局2018年春节放假通知的要求，现将公司2018年春节放假的有关事宜通知如下：\n\n\t一、放假时间\n\n\t2018年2月15日(星期四)至2018年2月21日(星期三)放假，共7天，2018年2月11日(星期日)、2018年2月24日(星期六)正常上班。\n\n\t二、认真落实领导带班和值班人员24小时值班制度\n\n\t各科室、各单位要高度重视值班工作，安排好带班负责人和值班人员。值班人员要尽职尽责，坚守岗位，不得关闭或转接电话、擅离职守，确保值班岗位上有带班领导、值班人员、24小时通讯畅通。注意防火、防盗等安全问题，如遇突发事件请及时上报分管领导。\n\n\t三、切实加强信息报告工作\n\n\t各单位、各科室如遇有突发事件，要迅速妥善处置并及时上报，除重要情况要及时报告外，需向上级部门发送工作日报表的科室、单位，每天要按时向上级部门发送报表。\n\n\t预祝大家节日快乐！\n\n\t特此通知！\n\n\t \n\n\t菏泽市公共汽车公司\n\n\t2018年2月9日\n","status":"1","place":"ERP系统, 手机APP, 员工专区"},{"newsId":"36","subject":"关于2018年国庆假期放假通知各位准备好","sectionId":"11","author":"办公室","createtime":"2018-02-09 00:00:00.0","replyCounts":"0","viewCounts":"1","issuer":"李德全","content":"\n\t关于2018年春节放假的通知\n\n\t \n\n\t各科室、各单位：\n\n\t根据市交通局2018年春节放假通知的要求，现将公司2018年春节放假的有关事宜通知如下：\n\n\t一、放假时间\n\n\t2018年2月15日(星期四)至2018年2月21日(星期三)放假，共7天，2018年2月11日(星期日)、2018年2月24日(星期六)正常上班。\n\n\t二、认真落实领导带班和值班人员24小时值班制度\n\n\t各科室、各单位要高度重视值班工作，安排好带班负责人和值班人员。值班人员要尽职尽责，坚守岗位，不得关闭或转接电话、擅离职守，确保值班岗位上有带班领导、值班人员、24小时通讯畅通。注意防火、防盗等安全问题，如遇突发事件请及时上报分管领导。\n\n\t三、切实加强信息报告工作\n\n\t各单位、各科室如遇有突发事件，要迅速妥善处置并及时上报，除重要情况要及时报告外，需向上级部门发送工作日报表的科室、单位，每天要按时向上级部门发送报表。\n\n\t预祝大家节日快乐！\n\n\t特此通知！\n\n\t \n\n\t菏泽市公共汽车公司\n\n\t2018年2月9日\n","status":"1","place":"ERP系统, 手机APP, 员工专区"}]
     */

    private boolean success;
    private int totalCounts;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable{
        /**
         * newsId : 42
         * subject : 测试
         * sectionId : 11
         * author : 警察局
         * createtime : 2019-04-25 00:00:00.0
         * replyCounts : 0
         * viewCounts : 3
         * issuer : 超级管理员
         * content :
         菜市场收藏市场收藏收藏市场

         * status : 1
         * place : ERP系统, 手机APP
         */

        private String newsId;
        private String subject;
        private String sectionId;
        private String author;
        private String createtime;
        private String replyCounts;
        private String viewCounts;
        private String issuer;
        private String content;
        private String status;
        private String place;

        public String getNewsId() {
            return newsId;
        }

        public void setNewsId(String newsId) {
            this.newsId = newsId;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getSectionId() {
            return sectionId;
        }

        public void setSectionId(String sectionId) {
            this.sectionId = sectionId;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getReplyCounts() {
            return replyCounts;
        }

        public void setReplyCounts(String replyCounts) {
            this.replyCounts = replyCounts;
        }

        public String getViewCounts() {
            return viewCounts;
        }

        public void setViewCounts(String viewCounts) {
            this.viewCounts = viewCounts;
        }

        public String getIssuer() {
            return issuer;
        }

        public void setIssuer(String issuer) {
            this.issuer = issuer;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }
    }
}
