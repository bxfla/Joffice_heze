package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/28.
 */

public class OnLineList implements Serializable {

    /**
     * success : true
     * totalCounts : 36
     * result : [{"version":null,"orgId":null,"orgPath":null,"examinationId":45,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":43,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"十九大学习资料"},"examinationName":"十九大学习考试","beginDate":"2017-11-27 10:12:43","endDate":"2017-11-30 10:12:43","examinationFlag":0,"examinationSum":100,"examinationRadioSum":63,"examinationMultiselectSum":37,"examinationJudgeSum":0,"examinationTime":100,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"经理,书记,副经理,科长,副科长,科员,主任,副主任,车队长,机务维修队长,安全服务队长,营运调度队长,调度员,站务员,机务,门卫,充电员,调度员2班,统计员,管理员,车载设备维修,机务班长,车队内勤,点钞员,保洁员,负责人,管理员,一车队调度员,二车队调度员,三车队调度员,四车队调度员,内勤,工会,修理工","examinationRoleIds":"101,102,103,104,105,106,108,109,110,111,112,113,114,115,116,117,121,122,123,124,125,126,127,130,131,133,134,135,136,137,138,139,140,141"},{"version":null,"orgId":null,"orgPath":null,"examinationId":63,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":43,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"十九大学习资料"},"examinationName":"十九大知识竞赛","beginDate":"2018-04-11 15:53:24","endDate":"2018-04-11 15:53:24","examinationFlag":1,"examinationSum":50,"examinationRadioSum":50,"examinationMultiselectSum":0,"examinationJudgeSum":0,"examinationTime":60,"examinationType":1,"examinationRoleType":3,"examinationRoleName":"朱俊英,马立业,吴延泽,彭志,李翠,郑俊彦,牛晓娜,栗小洲,晁桂玉,赵春玲,范伟,韩晓洁,邵蕾","examinationRoleIds":"7481,7490,7544,7728,7575,7566,7569,7573,7456,7507,7685,7542,7689"},{"version":null,"orgId":null,"orgPath":null,"examinationId":69,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":50,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"质量管理"},"examinationName":"质量管理模拟考试","beginDate":"2018-05-10 10:20:29","endDate":"2018-05-14 10:20:29","examinationFlag":0,"examinationSum":199,"examinationRadioSum":136,"examinationMultiselectSum":63,"examinationJudgeSum":0,"examinationTime":120,"examinationType":1,"examinationRoleType":0,"examinationRoleName":"全体员工","examinationRoleIds":"001"},{"version":null,"orgId":null,"orgPath":null,"examinationId":70,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":50,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"质量管理"},"examinationName":"质量管理考试","beginDate":"2018-05-15 00:29:53","endDate":"2018-07-20 23:59:00","examinationFlag":1,"examinationSum":100,"examinationRadioSum":70,"examinationMultiselectSum":30,"examinationJudgeSum":0,"examinationTime":60,"examinationType":0,"examinationRoleType":0,"examinationRoleName":"全体员工","examinationRoleIds":"001"},{"version":null,"orgId":null,"orgPath":null,"examinationId":86,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":57,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"安全文明驾驶知识试题"},"examinationName":"2018.11","beginDate":"2018-07-11 10:21:26","endDate":"2018-07-14 10:21:26","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":20,"examinationJudgeSum":40,"examinationTime":60,"examinationType":0,"examinationRoleType":1,"examinationRoleName":"培训课","examinationRoleIds":"494"},{"version":null,"orgId":null,"orgPath":null,"examinationId":91,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":62,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年菏泽市公交驾驶员技能大赛练习试题"},"examinationName":"2018年菏泽市公交驾驶员技能大赛练习试题1","beginDate":"2018-08-25 10:56:08","endDate":"2018-08-25 10:56:08","examinationFlag":1,"examinationSum":150,"examinationRadioSum":50,"examinationMultiselectSum":50,"examinationJudgeSum":50,"examinationTime":50,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":92,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":63,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年菏泽市公交驾驶员技能大赛练习试题2"},"examinationName":"2018年菏泽市公交驾驶员技能大赛练习试题2","beginDate":"2018-08-25 11:10:17","endDate":"2018-08-25 11:10:17","examinationFlag":1,"examinationSum":150,"examinationRadioSum":50,"examinationMultiselectSum":50,"examinationJudgeSum":50,"examinationTime":50,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":97,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":53,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"季度考核"},"examinationName":"第三季度星级考核模拟练习题","beginDate":"2018-09-19 15:41:58","endDate":"2018-09-19 15:41:58","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":98,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":53,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"季度考核"},"examinationName":"第三季度星级考试","beginDate":"2018-09-30 09:33:57","endDate":"2018-10-09 23:59:59","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":100,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":69,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"创城知识竞赛"},"examinationName":"创城知识竞赛模拟","beginDate":"2018-09-20 14:07:24","endDate":"2018-09-20 14:07:24","examinationFlag":1,"examinationSum":100,"examinationRadioSum":70,"examinationMultiselectSum":20,"examinationJudgeSum":10,"examinationTime":60,"examinationType":1,"examinationRoleType":0,"examinationRoleName":"全体员工","examinationRoleIds":"001"},{"version":null,"orgId":null,"orgPath":null,"examinationId":101,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":70,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年山东省技能大赛题库"},"examinationName":"2018年山东省技能大赛模拟练习题","beginDate":"2018-09-26 10:45:18","endDate":"2018-09-26 10:45:18","examinationFlag":1,"examinationSum":90,"examinationRadioSum":30,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":3,"examinationRoleName":"杨友松,刘娟,马庆生","examinationRoleIds":"7790,7809,8942"},{"version":null,"orgId":null,"orgPath":null,"examinationId":102,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":69,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"创城知识竞赛"},"examinationName":"创城知识竞赛","beginDate":"2018-09-27 00:00:00","endDate":"2018-10-31 00:00:00","examinationFlag":1,"examinationSum":100,"examinationRadioSum":70,"examinationMultiselectSum":20,"examinationJudgeSum":10,"examinationTime":60,"examinationType":0,"examinationRoleType":0,"examinationRoleName":"全体员工","examinationRoleIds":"001"},{"version":null,"orgId":null,"orgPath":null,"examinationId":104,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":71,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年入职考试题库"},"examinationName":"2018年新聘驾驶员入职考试","beginDate":"2018-10-03 15:15:17","endDate":"2018-10-03 15:15:17","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":3,"examinationRoleName":"测试2,测试3,测试4,测试5,测试6,测试7,测试8,测试9,测试10,测试,测试12,测试13,测试14,测试15,测试16,测试17,测试18,测试19,测试20,测试21,测试22,测试23,测试24,测试","examinationRoleIds":"7751,7755,7756,7757,7758,7759,7760,7761,7762,7763,7764,7765,7766,7767,9348,9349,9350,9351,9352,9353,9354,9355,9356,7750"},{"version":null,"orgId":null,"orgPath":null,"examinationId":105,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":71,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年入职考试题库"},"examinationName":"2019年新聘驾驶员入职考试","beginDate":"2018-10-05 14:05:21","endDate":"2018-10-05 18:05:21","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":3,"examinationRoleName":"测试,测试2,测试3,测试4,测试5,测试6,测试7,测试8,测试9,测试10,测试12,测试13,测试14,测试15,测试16,测试17,测试18,测试19,测试20,测试21,测试22,测试23,测试24","examinationRoleIds":"9786,7751,7755,7756,7757,7758,7759,7760,7761,7762,7764,7765,7766,7767,9348,9349,9350,9351,9352,9353,9354,9355,9356"},{"version":null,"orgId":null,"orgPath":null,"examinationId":107,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":53,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"季度考核"},"examinationName":"第三季度（星级补考）","beginDate":"2018-10-24 14:00:43","endDate":"2018-10-25 23:59:43","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":108,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":53,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"季度考核"},"examinationName":"2018年第三季度星级考试（补考）","beginDate":"2018-10-15 00:19:41","endDate":"2018-10-17 23:59:41","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":109,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":71,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年入职考试题库"},"examinationName":"2018年第16期入职考试","beginDate":"2018-10-30 15:00:01","endDate":"2018-10-30 18:50:50","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":1,"examinationRoleName":"培训课","examinationRoleIds":"494"},{"version":null,"orgId":null,"orgPath":null,"examinationId":110,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":73,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"安全文明驾驶知识试题2018年10月份"},"examinationName":"安全文明驾驶试题","beginDate":"2018-11-02 09:19:13","endDate":"2018-11-02 09:19:13","examinationFlag":1,"examinationSum":100,"examinationRadioSum":50,"examinationMultiselectSum":20,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":111,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":74,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"道路交通信号试题2018年10月"},"examinationName":"道路交通信号试题","beginDate":"2018-11-02 09:24:34","endDate":"2018-11-02 09:24:34","examinationFlag":1,"examinationSum":100,"examinationRadioSum":35,"examinationMultiselectSum":20,"examinationJudgeSum":45,"examinationTime":60,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":112,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":75,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"危险源识别和防御性驾驶试题2018年10月"},"examinationName":"危险源识别和防御性驾驶试题","beginDate":"2018-11-02 09:34:22","endDate":"2018-11-02 09:34:22","examinationFlag":1,"examinationSum":100,"examinationRadioSum":50,"examinationMultiselectSum":25,"examinationJudgeSum":25,"examinationTime":60,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员","examinationRoleIds":"119"},{"version":null,"orgId":null,"orgPath":null,"examinationId":113,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":71,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年入职考试题库"},"examinationName":"2018年第17期岗前测试","beginDate":"2018-11-16 14:00:24","endDate":"2018-11-16 18:00:24","examinationFlag":1,"examinationSum":100,"examinationRadioSum":50,"examinationMultiselectSum":30,"examinationJudgeSum":20,"examinationTime":60,"examinationType":0,"examinationRoleType":1,"examinationRoleName":"培训课","examinationRoleIds":"494"},{"version":null,"orgId":null,"orgPath":null,"examinationId":115,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":71,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年入职考试题库"},"examinationName":"2018年第18期岗前测试","beginDate":"2018-12-07 15:28:38","endDate":"2018-12-07 18:28:38","examinationFlag":1,"examinationSum":100,"examinationRadioSum":50,"examinationMultiselectSum":30,"examinationJudgeSum":20,"examinationTime":60,"examinationType":0,"examinationRoleType":1,"examinationRoleName":"培训课","examinationRoleIds":"494"},{"version":null,"orgId":null,"orgPath":null,"examinationId":116,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":79,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年第四季度星级考试"},"examinationName":"2018年第四季度星级考试模拟练习","beginDate":"2019-01-10 16:05:41","endDate":"2019-01-10 16:05:41","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":1,"examinationRoleType":2,"examinationRoleName":"驾驶员,实习驾驶员","examinationRoleIds":"119,120"},{"version":null,"orgId":null,"orgPath":null,"examinationId":117,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":79,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年第四季度星级考试"},"examinationName":"2018年第四季度星级在线考试","beginDate":"2019-01-15 15:01:10","endDate":"2019-01-22 23:59:57","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"驾驶员,实习驾驶员","examinationRoleIds":"119,120"},{"version":null,"orgId":null,"orgPath":null,"examinationId":118,"questionsManagement":{"version":null,"orgId":null,"orgPath":null,"questionsId":79,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"2018年第四季度星级考试"},"examinationName":"2018年第四季度星级考试（补考）","beginDate":"2019-01-23 01:07:04","endDate":"2019-01-29 23:59:04","examinationFlag":1,"examinationSum":100,"examinationRadioSum":40,"examinationMultiselectSum":30,"examinationJudgeSum":30,"examinationTime":60,"examinationType":0,"examinationRoleType":2,"examinationRoleName":"驾驶员,实习驾驶员","examinationRoleIds":"119,120"}]
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

    public static class ResultBean {
        /**
         * version : null
         * orgId : null
         * orgPath : null
         * examinationId : 45
         * questionsManagement : {"version":null,"orgId":null,"orgPath":null,"questionsId":43,"examinationSubject":{"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"},"questionsName":"十九大学习资料"}
         * examinationName : 十九大学习考试
         * beginDate : 2017-11-27 10:12:43
         * endDate : 2017-11-30 10:12:43
         * examinationFlag : 0
         * examinationSum : 100
         * examinationRadioSum : 63
         * examinationMultiselectSum : 37
         * examinationJudgeSum : 0
         * examinationTime : 100
         * examinationType : 0
         * examinationRoleType : 2
         * examinationRoleName : 经理,书记,副经理,科长,副科长,科员,主任,副主任,车队长,机务维修队长,安全服务队长,营运调度队长,调度员,站务员,机务,门卫,充电员,调度员2班,统计员,管理员,车载设备维修,机务班长,车队内勤,点钞员,保洁员,负责人,管理员,一车队调度员,二车队调度员,三车队调度员,四车队调度员,内勤,工会,修理工
         * examinationRoleIds : 101,102,103,104,105,106,108,109,110,111,112,113,114,115,116,117,121,122,123,124,125,126,127,130,131,133,134,135,136,137,138,139,140,141
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int examinationId;
        private QuestionsManagementBean questionsManagement;
        private String examinationName;
        private String beginDate;
        private String endDate;
        private int examinationFlag;
        private int examinationSum;
        private int examinationRadioSum;
        private int examinationMultiselectSum;
        private int examinationJudgeSum;
        private int examinationTime;
        private int examinationType;
        private int examinationRoleType;
        private String examinationRoleName;
        private String examinationRoleIds;

        public Object getVersion() {
            return version;
        }

        public void setVersion(Object version) {
            this.version = version;
        }

        public Object getOrgId() {
            return orgId;
        }

        public void setOrgId(Object orgId) {
            this.orgId = orgId;
        }

        public Object getOrgPath() {
            return orgPath;
        }

        public void setOrgPath(Object orgPath) {
            this.orgPath = orgPath;
        }

        public int getExaminationId() {
            return examinationId;
        }

        public void setExaminationId(int examinationId) {
            this.examinationId = examinationId;
        }

        public QuestionsManagementBean getQuestionsManagement() {
            return questionsManagement;
        }

        public void setQuestionsManagement(QuestionsManagementBean questionsManagement) {
            this.questionsManagement = questionsManagement;
        }

        public String getExaminationName() {
            return examinationName;
        }

        public void setExaminationName(String examinationName) {
            this.examinationName = examinationName;
        }

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getExaminationFlag() {
            return examinationFlag;
        }

        public void setExaminationFlag(int examinationFlag) {
            this.examinationFlag = examinationFlag;
        }

        public int getExaminationSum() {
            return examinationSum;
        }

        public void setExaminationSum(int examinationSum) {
            this.examinationSum = examinationSum;
        }

        public int getExaminationRadioSum() {
            return examinationRadioSum;
        }

        public void setExaminationRadioSum(int examinationRadioSum) {
            this.examinationRadioSum = examinationRadioSum;
        }

        public int getExaminationMultiselectSum() {
            return examinationMultiselectSum;
        }

        public void setExaminationMultiselectSum(int examinationMultiselectSum) {
            this.examinationMultiselectSum = examinationMultiselectSum;
        }

        public int getExaminationJudgeSum() {
            return examinationJudgeSum;
        }

        public void setExaminationJudgeSum(int examinationJudgeSum) {
            this.examinationJudgeSum = examinationJudgeSum;
        }

        public int getExaminationTime() {
            return examinationTime;
        }

        public void setExaminationTime(int examinationTime) {
            this.examinationTime = examinationTime;
        }

        public int getExaminationType() {
            return examinationType;
        }

        public void setExaminationType(int examinationType) {
            this.examinationType = examinationType;
        }

        public int getExaminationRoleType() {
            return examinationRoleType;
        }

        public void setExaminationRoleType(int examinationRoleType) {
            this.examinationRoleType = examinationRoleType;
        }

        public String getExaminationRoleName() {
            return examinationRoleName;
        }

        public void setExaminationRoleName(String examinationRoleName) {
            this.examinationRoleName = examinationRoleName;
        }

        public String getExaminationRoleIds() {
            return examinationRoleIds;
        }

        public void setExaminationRoleIds(String examinationRoleIds) {
            this.examinationRoleIds = examinationRoleIds;
        }

        public static class QuestionsManagementBean {
            /**
             * version : null
             * orgId : null
             * orgPath : null
             * questionsId : 43
             * examinationSubject : {"version":null,"orgId":null,"orgPath":null,"subjectId":1,"subjectType":0,"subjectName":"运营小常识"}
             * questionsName : 十九大学习资料
             */

            private Object version;
            private Object orgId;
            private Object orgPath;
            private int questionsId;
            private ExaminationSubjectBean examinationSubject;
            private String questionsName;

            public Object getVersion() {
                return version;
            }

            public void setVersion(Object version) {
                this.version = version;
            }

            public Object getOrgId() {
                return orgId;
            }

            public void setOrgId(Object orgId) {
                this.orgId = orgId;
            }

            public Object getOrgPath() {
                return orgPath;
            }

            public void setOrgPath(Object orgPath) {
                this.orgPath = orgPath;
            }

            public int getQuestionsId() {
                return questionsId;
            }

            public void setQuestionsId(int questionsId) {
                this.questionsId = questionsId;
            }

            public ExaminationSubjectBean getExaminationSubject() {
                return examinationSubject;
            }

            public void setExaminationSubject(ExaminationSubjectBean examinationSubject) {
                this.examinationSubject = examinationSubject;
            }

            public String getQuestionsName() {
                return questionsName;
            }

            public void setQuestionsName(String questionsName) {
                this.questionsName = questionsName;
            }

            public static class ExaminationSubjectBean {
                /**
                 * version : null
                 * orgId : null
                 * orgPath : null
                 * subjectId : 1
                 * subjectType : 0
                 * subjectName : 运营小常识
                 */

                private Object version;
                private Object orgId;
                private Object orgPath;
                private int subjectId;
                private int subjectType;
                private String subjectName;

                public Object getVersion() {
                    return version;
                }

                public void setVersion(Object version) {
                    this.version = version;
                }

                public Object getOrgId() {
                    return orgId;
                }

                public void setOrgId(Object orgId) {
                    this.orgId = orgId;
                }

                public Object getOrgPath() {
                    return orgPath;
                }

                public void setOrgPath(Object orgPath) {
                    this.orgPath = orgPath;
                }

                public int getSubjectId() {
                    return subjectId;
                }

                public void setSubjectId(int subjectId) {
                    this.subjectId = subjectId;
                }

                public int getSubjectType() {
                    return subjectType;
                }

                public void setSubjectType(int subjectType) {
                    this.subjectType = subjectType;
                }

                public String getSubjectName() {
                    return subjectName;
                }

                public void setSubjectName(String subjectName) {
                    this.subjectName = subjectName;
                }
            }
        }
    }
}
