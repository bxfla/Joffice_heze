package com.smartbus.heze.fileapprove.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/29.
 */

public class Department extends DataSupport implements Serializable {

    /**
     * success : true
     * data : [{"depId":"479","depName":"小车班"},{"depId":"410","depName":"营运管理科"},{"depId":"417","depName":"广告营销科"},{"depId":"420","depName":"客服中心"},{"depId":"457","depName":"售卡中心"},{"depId":"467","depName":"财务科"},{"depId":"470","depName":"充电中心"},{"depId":"428","depName":"一公司"},{"depId":"430","depName":"三公司"},{"depId":"494","depName":"培训课"},{"depId":"443","depName":"调度中心"},{"depId":"459","depName":"安全科"},{"depId":"461","depName":"理赔中心"},{"depId":"445","depName":"公司内养"},{"depId":"446","depName":"广告内养"},{"depId":"496","depName":"城乡公交公司"},{"depId":"497","depName":"城乡公交一车队"},{"depId":"453","depName":"成本统计科"},{"depId":"454","depName":"机务科"},{"depId":"456","depName":"修理厂"},{"depId":"481","depName":"市行政审批服务大厅"},{"depId":"482","depName":"牡丹区便民服务大厅"},{"depId":"483","depName":"菏泽学院"},{"depId":"484","depName":"中华路IC卡"},{"depId":"485","depName":"其他"},{"depId":"488","depName":"未在岗人员"},{"depId":"489","depName":"遗嘱"},{"depId":"490","depName":"保洁"},{"depId":"452","depName":"总务科"},{"depId":"378","depName":"菏泽市公共汽车公司"},{"depId":"411","depName":"信息中心"},{"depId":"460","depName":"稽查科"},{"depId":"478","depName":"领导班子"},{"depId":"413","depName":"创优办"},{"depId":"416","depName":"保卫科"},{"depId":"419","depName":"安顺出租车公司"},{"depId":"469","depName":"群工办"},{"depId":"427","depName":"清点中心"},{"depId":"429","depName":"二公司"},{"depId":"471","depName":"小车租赁公司"},{"depId":"487","depName":"解除合同"},{"depId":"412","depName":"企管办"},{"depId":"414","depName":"技术材料科"},{"depId":"468","depName":"政工科"},{"depId":"418","depName":"广告设施维护科"},{"depId":"431","depName":"定制公交公司"},{"depId":"455","depName":"材料供应科"},{"depId":"433","depName":"信息设备维修班"},{"depId":"464","depName":"办公室"},{"depId":"486","depName":"退休人员"}]
     */

    private boolean success;
    private List<DataBean> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * depId : 479
         * depName : 小车班
         */

        private String depId;
        private String depName;

        public String getDepId() {
            return depId;
        }

        public void setDepId(String depId) {
            this.depId = depId;
        }

        public String getDepName() {
            return depName;
        }

        public void setDepName(String depName) {
            this.depName = depName;
        }
    }
}
