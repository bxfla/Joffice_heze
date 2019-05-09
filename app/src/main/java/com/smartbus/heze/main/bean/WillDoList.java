package com.smartbus.heze.main.bean;

import java.io.Serializable;
import java.util.List;

// FIXME generate failure  field _$Result28
/**
 * Created by Administrator on 2019/5/8.
 */

public class WillDoList implements Serializable {


    /**
     * success : true
     * totalCounts : 2
     * result : [{"taskName":"驾驶员入职流程表","activityName":"经办部门","assignee":"超级管理员","createTime":"2019-4-28 17:18:34","executionId":"JSYRZLCB4.8540061","isDue":0,"piId":"JSYRZLCB4.8540061","taskId":8580083,"formDefId":10117,"state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""},{"taskName":"驾驶员入职流程表","activityName":"经办部门","assignee":"超级管理员","createTime":"2019-4-28 17:17:58","executionId":"JSYRZLCB4.8540034","isDue":0,"piId":"JSYRZLCB4.8540034","taskId":8580079,"formDefId":10117,"state":"open","isMultipleTask":0,"candidateUsers":"","candidateRoles":""}]
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
         * taskName : 驾驶员入职流程表
         * activityName : 经办部门
         * assignee : 超级管理员
         * createTime : 2019-4-28 17:18:34
         * executionId : JSYRZLCB4.8540061
         * isDue : 0
         * piId : JSYRZLCB4.8540061
         * taskId : 8580083
         * formDefId : 10117
         * state : open
         * isMultipleTask : 0
         * candidateUsers :
         * candidateRoles :
         */

        private String taskName;
        private String activityName;
        private String assignee;
        private String createTime;
        private String executionId;
        private int isDue;
        private String piId;
        private String taskId;
        private String formDefId;
        private String state;
        private int isMultipleTask;
        private String candidateUsers;
        private String candidateRoles;

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public String getActivityName() {
            return activityName;
        }

        public void setActivityName(String activityName) {
            this.activityName = activityName;
        }

        public String getAssignee() {
            return assignee;
        }

        public void setAssignee(String assignee) {
            this.assignee = assignee;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getExecutionId() {
            return executionId;
        }

        public void setExecutionId(String executionId) {
            this.executionId = executionId;
        }

        public int getIsDue() {
            return isDue;
        }

        public void setIsDue(int isDue) {
            this.isDue = isDue;
        }

        public String getPiId() {
            return piId;
        }

        public void setPiId(String piId) {
            this.piId = piId;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getFormDefId() {
            return formDefId;
        }

        public void setFormDefId(String formDefId) {
            this.formDefId = formDefId;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getIsMultipleTask() {
            return isMultipleTask;
        }

        public void setIsMultipleTask(int isMultipleTask) {
            this.isMultipleTask = isMultipleTask;
        }

        public String getCandidateUsers() {
            return candidateUsers;
        }

        public void setCandidateUsers(String candidateUsers) {
            this.candidateUsers = candidateUsers;
        }

        public String getCandidateRoles() {
            return candidateRoles;
        }

        public void setCandidateRoles(String candidateRoles) {
            this.candidateRoles = candidateRoles;
        }
    }
}
