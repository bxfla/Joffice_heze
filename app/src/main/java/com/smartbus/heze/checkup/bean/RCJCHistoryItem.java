package com.smartbus.heze.checkup.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/5/22.
 */

public class RCJCHistoryItem implements Serializable {


    /**
     * success : true
     * totalCounts : 46
     * result : [{"projectId":"320","projectName":"不闯红灯，按导向车道使","state":1,"fkje":"-200"},{"projectId":"321","projectName":"运营过程中发生到站不停、拒载、甩客等","state":1,"fkje":"-500"},{"projectId":"323","projectName":"运营中不闲谈、不吸烟、不吃零食等","state":1,"fkje":"-50"},{"projectId":"324","projectName":"运营中不戴耳机、不听音乐等","state":1,"fkje":"-50"},{"projectId":"325","projectName":"行驶中不接打电话(车载电话除外)","state":1,"fkje":"-200"},{"projectId":"326","projectName":"严禁驾驶员座位左侧放置手机、收音机","state":1,"fkje":"-50"},{"projectId":"327","projectName":"严禁驾驶员座位左侧放置平板电脑","state":1,"fkje":"-50"},{"projectId":"328","projectName":"行驶中不玩微信、不发短信","state":1,"fkje":"-200"},{"projectId":"329","projectName":"驾驶台无杂物","state":1,"fkje":"-20"},{"projectId":"330","projectName":"车体内外、座位、扶手无明显灰尘、污垢","state":0,"fkje":"-20"},{"projectId":"331","projectName":"着工装上岗，不光脚不穿拖鞋驾驶","state":1,"fkje":"-20"},{"projectId":"332","projectName":"保持车内灭火器、安全锤齐全有效","state":1,"fkje":"-50"},{"projectId":"333","projectName":"及时制止乘客不文明行为","state":1,"fkje":"0"},{"projectId":"334","projectName":"及时制止乘客携带\u201c三品\u201d乘车","state":1,"fkje":"-200"},{"projectId":"335","projectName":"不无故挤靠其他车辆","state":1,"fkje":"-200"},{"projectId":"336","projectName":"不开英雄车、野蛮车等","state":1,"fkje":"-500"},{"projectId":"337","projectName":"车辆驶入场、站时应有序，不准超车驶入","state":1,"fkje":"-50"},{"projectId":"338","projectName":"车停稳后开门，关好门后起步","state":1,"fkje":"0"},{"projectId":"339","projectName":"行驶中关好车门","state":1,"fkje":"-100"},{"projectId":"340","projectName":"不得擅自改变运营线路","state":1,"fkje":"-200"},{"projectId":"341","projectName":"不得擅自将车辆交他人驾驶","state":1,"fkje":"-500"},{"projectId":"342","projectName":"驾驶员间不得私自调班、换班等","state":1,"fkje":"-200"},{"projectId":"343","projectName":"发动机电瓶等部位长期有明显油污不清理","state":1,"fkje":"0"},{"projectId":"344","projectName":"不擅自关闭车载监控设备、头尾牌显示屏","state":1,"fkje":"0"},{"projectId":"345","projectName":"不擅自关闭车载伺服器等","state":1,"fkje":"-200"},{"projectId":"346","projectName":"严禁私吞票款","state":1,"fkje":"0"},{"projectId":"347","projectName":"严禁车厢内放置铁丝、磁铁等无关物品","state":1,"fkje":"-100"},{"projectId":"348","projectName":"有效监督乘客出示证件、刷卡、投币","state":1,"fkje":"-50"},{"projectId":"349","projectName":"本公司职工严禁将本人IC卡转借他人使","state":1,"fkje":"-500"},{"projectId":"350","projectName":"检查项目不达标、点检表填写不规范","state":1,"fkje":"-50"},{"projectId":"457","projectName":"车内吸烟","state":1,"fkje":-100},{"projectId":"458","projectName":"不按规定站点上下乘客","state":1,"fkje":-200},{"projectId":"460","projectName":"收车后未按规定锁好门窗","state":1,"fkje":-50},{"projectId":"461","projectName":"未佩戴安检员袖标","state":1,"fkje":-20},{"projectId":"462","projectName":"车辆异常停留3分钟","state":1,"fkje":-100},{"projectId":"463","projectName":"岗前酒精测试含量超标","state":1,"fkje":-200},{"projectId":"464","projectName":"一线检查驾驶员拒签","state":1,"fkje":-200},{"projectId":"465","projectName":"未开展温馨服务","state":1,"fkje":-50},{"projectId":"466","projectName":"班前未点检","state":1,"fkje":-50},{"projectId":"467","projectName":"运营期间带孩子上班","state":1,"fkje":-100},{"projectId":"481","projectName":"终点未关闭空调","state":1,"fkje":-200},{"projectId":"482","projectName":"做与运营无关的事","state":1,"fkje":-50},{"projectId":"498","projectName":"运营中佩戴口罩、阴雨天气戴墨镜","state":1,"fkje":20},{"projectId":"499","projectName":"进站不按照(安全操作规范)正确使用灯","state":1,"fkje":50},{"projectId":"500","projectName":"站牌(站亭)不按照操作规范依次进站","state":1,"fkje":100},{"projectId":"501","projectName":"停车不按照操作规范拉手刹、挂空挡","state":1,"fkje":100}]
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
         * projectId : 320
         * projectName : 不闯红灯，按导向车道使
         * state : 1
         * fkje : -200
         */

        private String projectId;
        private String projectName;
        private int state;
        private String fkje;

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getFkje() {
            return fkje;
        }

        public void setFkje(String fkje) {
            this.fkje = fkje;
        }
    }
}
