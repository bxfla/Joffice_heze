package com.smartbus.heze.exam.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/7/1.
 */

public class RewardPenalties implements Serializable {

    /**
     * success : true
     * totalCounts : 12
     * result : [{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4411,"openTime":"2019-05-25 00:00:00","lineId":55145,"lineCode":"101","lineName":"101专线","carId":51385,"carNum":"鲁RN1385","driverId":100202,"driverName":"袁涛","type":"奖励","moneys":20,"reason":"5月份卫生标兵","createMan":"李亚娟","createTime":"2019-05-29 15:42:13"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4410,"openTime":"2019-05-25 00:00:00","lineId":55134,"lineCode":"9","lineName":"9路","carId":7731,"carNum":"鲁RG7731","driverId":101939,"driverName":"朱世彬","type":"奖励","moneys":20,"reason":"5月份卫生标兵","createMan":"李亚娟","createTime":"2019-05-29 15:41:32"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4433,"openTime":"2019-05-26 00:00:00","lineId":55139,"lineCode":"15","lineName":"15路","carId":19391,"carNum":"鲁R09391D","driverId":101817,"driverName":"姚福燕","type":"罚款","moneys":-200,"reason":"班前酒测超标31mg/ml\n","createMan":"马玉华","createTime":"2019-06-18 15:47:33"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4365,"openTime":"2019-05-29 00:00:00","lineId":55310,"lineCode":"29","lineName":"29路","carId":6521,"carNum":"鲁RG6521","driverId":102668,"driverName":"梁安","type":"罚款","moneys":-50,"reason":"未开展温馨服务","createMan":"游国红","createTime":"2019-05-13 17:52:07"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4435,"openTime":"2019-06-01 00:00:00","lineId":55278,"lineCode":"19","lineName":"19路","carId":6311,"carNum":"鲁RG6311","driverId":103315,"driverName":"谷春梅","type":"罚款","moneys":-190,"reason":"观察不周造成左侧车体受损\n自行承担维修费","createMan":"马玉华","createTime":"2019-06-18 15:51:45"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4430,"openTime":"2019-06-05 00:00:00","lineId":null,"lineCode":"31","lineName":"31路","carId":7265,"carNum":"鲁RG7265","driverId":103564,"driverName":"刘寸丽","type":"罚款","moneys":-20,"reason":"开会没穿工装裤","createMan":"李会","createTime":"2019-06-07 11:10:04"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4429,"openTime":"2019-06-06 00:00:00","lineId":null,"lineCode":"14","lineName":"14路","carId":13550,"carNum":"鲁R03550D","driverId":103145,"driverName":"翟金刚","type":"罚款","moneys":-20,"reason":"没带安检标","createMan":"李会","createTime":"2019-06-07 11:10:04"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4428,"openTime":"2019-06-06 00:00:00","lineId":null,"lineCode":"20","lineName":"20路","carId":7230,"carNum":"鲁RG7230","driverId":103439,"driverName":"魏金虎","type":"罚款","moneys":-50,"reason":"开安全会，手机响","createMan":"李会","createTime":"2019-06-07 11:10:04"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4436,"openTime":"2019-06-08 00:00:00","lineId":55127,"lineCode":"2","lineName":"2路","carId":9155,"carNum":"鲁RG9155","driverId":101933,"driverName":"马美霞","type":"罚款","moneys":-50,"reason":"未开展温馨服务","createMan":"马玉华","createTime":"2019-06-18 15:53:07"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4434,"openTime":"2019-06-12 00:00:00","lineId":55159,"lineCode":"66","lineName":"66路","carId":610,"carNum":"鲁RG0610","driverId":103110,"driverName":"丁宗平","type":"罚款","moneys":-50,"reason":"抢点","createMan":"马玉华","createTime":"2019-06-18 15:49:56"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4437,"openTime":"2019-06-17 00:00:00","lineId":55157,"lineCode":"88","lineName":"88路","carId":1165,"carNum":"鲁RG1165","driverId":103907,"driverName":"李金锋","type":"罚款","moneys":-200,"reason":"酒测超标，追加安全保证金培训费","createMan":"游国红","createTime":"2019-06-28 17:04:59"},{"version":null,"orgId":null,"orgPath":null,"lineSanctionId":4438,"openTime":"2019-06-19 00:00:00","lineId":55331,"lineCode":"38","lineName":"38路","carId":6583,"carNum":"鲁RG6583","driverId":103362,"driverName":"庞孟孟","type":"罚款","moneys":-200,"reason":"岗前酒测超标，追加保证金","createMan":"游国红","createTime":"2019-06-29 14:44:16"}]
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
         * lineSanctionId : 4411
         * openTime : 2019-05-25 00:00:00
         * lineId : 55145
         * lineCode : 101
         * lineName : 101专线
         * carId : 51385
         * carNum : 鲁RN1385
         * driverId : 100202
         * driverName : 袁涛
         * type : 奖励
         * moneys : 20.0
         * reason : 5月份卫生标兵
         * createMan : 李亚娟
         * createTime : 2019-05-29 15:42:13
         */

        private Object version;
        private Object orgId;
        private Object orgPath;
        private int lineSanctionId;
        private String openTime;
        private int lineId;
        private String lineCode;
        private String lineName;
        private int carId;
        private String carNum;
        private int driverId;
        private String driverName;
        private String type;
        private double moneys;
        private String reason;
        private String createMan;
        private String createTime;

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

        public int getLineSanctionId() {
            return lineSanctionId;
        }

        public void setLineSanctionId(int lineSanctionId) {
            this.lineSanctionId = lineSanctionId;
        }

        public String getOpenTime() {
            return openTime;
        }

        public void setOpenTime(String openTime) {
            this.openTime = openTime;
        }

        public int getLineId() {
            return lineId;
        }

        public void setLineId(int lineId) {
            this.lineId = lineId;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }

        public int getCarId() {
            return carId;
        }

        public void setCarId(int carId) {
            this.carId = carId;
        }

        public String getCarNum() {
            return carNum;
        }

        public void setCarNum(String carNum) {
            this.carNum = carNum;
        }

        public int getDriverId() {
            return driverId;
        }

        public void setDriverId(int driverId) {
            this.driverId = driverId;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getMoneys() {
            return moneys;
        }

        public void setMoneys(double moneys) {
            this.moneys = moneys;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getCreateMan() {
            return createMan;
        }

        public void setCreateMan(String createMan) {
            this.createMan = createMan;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }
    }
}
