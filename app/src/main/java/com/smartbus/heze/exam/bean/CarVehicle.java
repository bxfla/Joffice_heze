package com.smartbus.heze.exam.bean;

/**
 * Created by Administrator on 2019/7/3.
 */

import java.io.Serializable;
import java.util.List;

/**
 * 车辆违规
 */
public class CarVehicle implements Serializable{

    /**
     * success : true
     * totalCounts : 96
     * result : [{"vnId":490,"busCode":"1167","vnDate":"2018-01-08","vnTime":"10:14:16","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG1167","driverName":"张朝振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":506,"busCode":"2146","vnDate":"2018-01-08","vnTime":"13:18:27","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2146","driverName":"袁根明","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":553,"busCode":"7753","vnDate":"2018-01-12","vnTime":"11:20:13","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RG7753","driverName":"尚善强","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":554,"busCode":"7805","vnDate":"2018-02-09","vnTime":"11:00:32","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RG7805","driverName":"吴振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":555,"busCode":"7813","vnDate":"2018-02-14","vnTime":"11:17:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RG7813","driverName":"尚善强","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":558,"busCode":"7553","vnDate":"2018-02-13","vnTime":"11:20:04","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7553","driverName":"程相生","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":559,"busCode":"7553","vnDate":"2018-01-31","vnTime":"16:53:00","vnPlace":"","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7553","driverName":"程相生","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":562,"busCode":"7637","vnDate":"2018-02-21","vnTime":"12:17:00","vnPlace":"长江荷兰","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7637","driverName":"张丽01","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":563,"busCode":"7671","vnDate":"2018-03-01","vnTime":"09:01:00","vnPlace":"长城牡丹","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7671","driverName":"桑圣军","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":565,"busCode":"7703","vnDate":"2018-02-14","vnTime":"17:19:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7703","driverName":"昝秀环","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":566,"busCode":"7720","vnDate":"2018-02-13","vnTime":"11:55:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7720","driverName":"张青霞","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":567,"busCode":"7720","vnDate":"2018-01-31","vnTime":"11:40:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7720","driverName":"张青霞","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":568,"busCode":"7725","vnDate":"2018-01-10","vnTime":"12:09:00","vnPlace":"长江荷兰","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7725","driverName":"李志明","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":569,"busCode":"7735","vnDate":"2018-01-28","vnTime":"13:28:00","vnPlace":"长江荷兰","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7735","driverName":"李志明","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":572,"busCode":"7762","vnDate":"2018-03-31","vnTime":"15:22:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7762","driverName":"朱世彬","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":573,"busCode":"7827","vnDate":"2018-02-14","vnTime":"11:44:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7827","driverName":"杜振涛","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":575,"busCode":"7501","vnDate":"2018-01-03","vnTime":"06:37:00","vnPlace":"中华解放","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"17","driverDirection":"","penaltyResult":"","carNo":"鲁RG7501","driverName":"魏玉东","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":578,"busCode":"7532","vnDate":"2018-01-21","vnTime":"08:28:10","vnPlace":"曹州青年","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RG7532","driverName":"吕彦玲","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":581,"busCode":"7823","vnDate":"2018-01-30","vnTime":"16:58:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RG7823","driverName":"赵丽","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":584,"busCode":"7663","vnDate":"2018-04-17","vnTime":"07:55:00","vnPlace":"中华重庆","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"17","driverDirection":"","penaltyResult":"","carNo":"鲁RG7663","driverName":"张广建","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":590,"busCode":"9152","vnDate":"2018-05-24","vnTime":"09:46:00","vnPlace":"长城桂陵","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"32","driverDirection":"","penaltyResult":"","carNo":"鲁RG9152","driverName":"林祖华","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":601,"busCode":"322","vnDate":"2018-01-31","vnTime":"11:29:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"22","driverDirection":"","penaltyResult":"","carNo":"鲁RG0322","driverName":"李应振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":603,"busCode":"313","vnDate":"2018-01-24","vnTime":"11:55:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"22","driverDirection":"","penaltyResult":"","carNo":"鲁RG0313","driverName":"刘景亮","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":604,"busCode":"322","vnDate":"2018-01-30","vnTime":"11:29:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"22","driverDirection":"","penaltyResult":"","carNo":"鲁RG0322","driverName":"刘玉阔","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":606,"busCode":"315","vnDate":"2018-02-05","vnTime":"17:26:00","vnPlace":"西安中和","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"22","driverDirection":"","penaltyResult":"","carNo":"鲁RG0315","driverName":"朱向广","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":609,"busCode":"795","vnDate":"2018-02-02","vnTime":"12:18:00","vnPlace":"八一青年","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"5","driverDirection":"","penaltyResult":"","carNo":"鲁RG0795","driverName":"宋东臣","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":621,"busCode":"303","vnDate":"2018-05-24","vnTime":"10:45:55","vnPlace":"人民中华","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"27","driverDirection":"","penaltyResult":"","carNo":"鲁RG0303","driverName":"桑重厚","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":651,"busCode":"232","vnDate":"2018-02-12","vnTime":"10:26:00","vnPlace":"长江牡丹","vnFine":200,"vnMark":"3","vnProject":"13450-违反禁止标线","lineCode":"12","driverDirection":"","penaltyResult":"","carNo":"鲁RG0232","driverName":"孙海振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":653,"busCode":"537","vnDate":"2018-01-30","vnTime":"15:08:00","vnPlace":"长江牡丹","vnFine":200,"vnMark":"3","vnProject":"13450-违反禁止标线","lineCode":"27","driverDirection":"","penaltyResult":"","carNo":"鲁RG0537","driverName":"张玉生","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":657,"busCode":"1167","vnDate":"2018-01-08","vnTime":"10:14:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG1167","driverName":"张朝振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":664,"busCode":"2146","vnDate":"2018-01-08","vnTime":"13:18:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2146","driverName":"袁根明","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":714,"busCode":"3160","vnDate":"2018-03-05","vnTime":"11:52:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG3160","driverName":"郭丙红","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":716,"busCode":"1563","vnDate":"2018-02-03","vnTime":"12:39:00","vnPlace":"和平中华","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG1563","driverName":"刘胜利","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":720,"busCode":"561","vnDate":"2018-01-29","vnTime":"16:05:00","vnPlace":"和平中华","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG0561","driverName":"许力","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":738,"busCode":"263","vnDate":"2018-02-26","vnTime":"09:47:00","vnPlace":"胜利康庄","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"12","driverDirection":"","penaltyResult":"","carNo":"鲁RG0263","driverName":"薛运刚","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":739,"busCode":"3560","vnDate":"2018-01-06","vnTime":"17:52:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG3560","driverName":"王成武","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":746,"busCode":"763","vnDate":"2018-01-08","vnTime":"13:31:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0763","driverName":"高志英","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":755,"busCode":"700","vnDate":"2018-01-03","vnTime":"09:07:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0700","driverName":"姜海存","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":767,"busCode":"722","vnDate":"2018-01-11","vnTime":"14:35:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0722","driverName":"刘明奇","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":774,"busCode":"184","vnDate":"2018-01-03","vnTime":"14:45:00","vnPlace":"中华西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"23","driverDirection":"","penaltyResult":"","carNo":"鲁RG0184","driverName":"马建涛","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":784,"busCode":"730","vnDate":"2018-01-09","vnTime":"07:22:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0730","driverName":"王明坤","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":792,"busCode":"751","vnDate":"2018-01-12","vnTime":"06:31:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0751","driverName":"邢亚伟","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":793,"busCode":"310","vnDate":"2018-01-06","vnTime":"08:32:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"23","driverDirection":"","penaltyResult":"","carNo":"鲁RG0310","driverName":"徐庆雷","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":815,"busCode":"2150","vnDate":"2018-01-16","vnTime":"20:02:00","vnPlace":"长城新牡丹","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2150","driverName":"王德帅","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":819,"busCode":"5160","vnDate":"2018-02-11","vnTime":"22:02:00","vnPlace":"西安中华","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG5160","driverName":"赵忠涛","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":821,"busCode":"8151","vnDate":"2018-08-17","vnTime":"18:15:00","vnPlace":"长江成阳","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"6","driverDirection":"","penaltyResult":"","carNo":"鲁RG8151","driverName":"赵济生","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":824,"busCode":"7160","vnDate":"2018-05-27","vnTime":"10:23:09","vnPlace":"西安东方红","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"88888","driverDirection":"","penaltyResult":"","carNo":"鲁RG7160","driverName":"蔡中杰","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":838,"busCode":"2157","vnDate":"2018-01-08","vnTime":"07:41:00","vnPlace":"青年大学","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2157","driverName":"李兆存","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":839,"busCode":"320","vnDate":"2018-02-11","vnTime":"17:52:00","vnPlace":"中山人民","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"22","driverDirection":"","penaltyResult":"","carNo":"鲁RG0320","driverName":"童迎春","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":840,"busCode":"1511","vnDate":"2018-01-12","vnTime":"11:46:00","vnPlace":"中华和平","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG1511","driverName":"朱爱青","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":845,"busCode":"791","vnDate":"2018-02-24","vnTime":"17:33:00","vnPlace":"中山人民","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"5","driverDirection":"","penaltyResult":"","carNo":"鲁RG0791","driverName":"孙俊山","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":853,"busCode":"520","vnDate":"2018-03-02","vnTime":"11:56:00","vnPlace":"长江济南","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"26","driverDirection":"","penaltyResult":"","carNo":"鲁RG0520","driverName":"张振","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":854,"busCode":"630","vnDate":"2018-01-08","vnTime":"15:59:00","vnPlace":"长江荷兰","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"37","driverDirection":"","penaltyResult":"","carNo":"鲁RG0630","driverName":"赵弟全","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":858,"busCode":"700","vnDate":"2018-01-21","vnTime":"10:52:00","vnPlace":"昆明至220国道","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0700","driverName":"姜海存","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":859,"busCode":"712","vnDate":"2018-01-07","vnTime":"13:26:00","vnPlace":"曹州重庆","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0712","driverName":"李朝云","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":861,"busCode":"761","vnDate":"2018-03-02","vnTime":"08:57:00","vnPlace":"黄河南京","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0761","driverName":"李作要","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":887,"busCode":"525","vnDate":"2018-02-22","vnTime":"12:54:00","vnPlace":"和平中华","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"26","driverDirection":"","penaltyResult":"","carNo":"鲁RG0525","driverName":"马宏军","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":898,"busCode":"1757","vnDate":"2018-01-07","vnTime":"06:36:00","vnPlace":"牡丹双河","vnFine":100,"vnMark":"0","vnProject":"10180-机动车不在机动车道内行驶","lineCode":"88","driverDirection":"","penaltyResult":"","carNo":"鲁RG1757","driverName":"宋玉芳","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":899,"busCode":"1755","vnDate":"2018-01-07","vnTime":"18:48:00","vnPlace":"牡丹双河","vnFine":100,"vnMark":"0","vnProject":"10180-机动车不在机动车道内行驶","lineCode":"88","driverDirection":"","penaltyResult":"","carNo":"鲁RG1755","driverName":"王文印","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":901,"busCode":"212","vnDate":"2018-08-01","vnTime":"05:00:00","vnPlace":"中山人民","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"50","driverDirection":"","penaltyResult":"","carNo":"鲁RG0212","driverName":"林福良","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":902,"busCode":"2157","vnDate":"2018-06-23","vnTime":"15:57:42","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2157","driverName":"李兆存","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":903,"busCode":"7832","vnDate":"2018-05-13","vnTime":"09:04:00","vnPlace":"黄河","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"15","driverDirection":"","penaltyResult":"","carNo":"鲁RG7832","driverName":"孙传友","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":907,"busCode":"7910","vnDate":"2018-06-02","vnTime":"11:19:00","vnPlace":"点将八一","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"48","driverDirection":"","penaltyResult":"","carNo":"鲁RG7910","driverName":"张智慧","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":908,"busCode":"260","vnDate":"2018-08-03","vnTime":"13:27:00","vnPlace":"青年康庄","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"12","driverDirection":"","penaltyResult":"","carNo":"鲁RG0260","driverName":"郭效林","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":910,"busCode":"507","vnDate":"2018-04-16","vnTime":"09:54:00","vnPlace":"中山和平","vnFine":200,"vnMark":"3","vnProject":"13450-违反禁止标线","lineCode":"26","driverDirection":"","penaltyResult":"","carNo":"鲁RG0507","driverName":"张敬涛","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":912,"busCode":"7027","vnDate":"2018-05-18","vnTime":"12:51:00","vnPlace":"中山人民","vnFine":200,"vnMark":"3","vnProject":"13010-逆向行驶","lineCode":"14","driverDirection":"","penaltyResult":"","carNo":"鲁RG7027","driverName":"葛志立","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":913,"busCode":"7103","vnDate":"2018-05-12","vnTime":"12:43:00","vnPlace":"中山人民","vnFine":200,"vnMark":"3","vnProject":"13010-逆向行驶","lineCode":"14","driverDirection":"","penaltyResult":"","carNo":"鲁RG7103","driverName":"李付亮","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":914,"busCode":"7200","vnDate":"2018-07-16","vnTime":"11:15:00","vnPlace":"人民八一","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"10","driverDirection":"","penaltyResult":"","carNo":"鲁RG7200","driverName":"邢永军","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":915,"busCode":"58731","vnDate":"2018-03-18","vnTime":"10:43:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"37","driverDirection":"","penaltyResult":"","carNo":"鲁RN8731","driverName":"马百海","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":916,"busCode":"7010","vnDate":"2018-08-15","vnTime":"15:37:00","vnPlace":"华英丹阳","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"105","driverDirection":"","penaltyResult":"","carNo":"鲁RG7010","driverName":"宋岩红","violationResp":"","vnOper":"","vnOperDate":"","orgName":"二公司"},{"vnId":918,"busCode":"700","vnDate":"2018-01-03","vnTime":"09:07:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0700","driverName":"姜海存","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":924,"busCode":"705","vnDate":"2018-06-11","vnTime":"10:27:00","vnPlace":"黄河光明","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0705","driverName":"刘胜利","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":936,"busCode":"722","vnDate":"2018-01-11","vnTime":"14:35:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0722","driverName":"刘明奇","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":946,"busCode":"751","vnDate":"2018-08-14","vnTime":"10:03:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0751","driverName":"邢亚伟","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":947,"busCode":"751","vnDate":"2018-01-12","vnTime":"06:31:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG0751","driverName":"邢亚伟","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":955,"busCode":"7532","vnDate":"2018-01-02","vnTime":"08:28:00","vnPlace":"曹州青年","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"17","driverDirection":"","penaltyResult":"","carNo":"鲁RG7532","driverName":"吕彦玲","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":957,"busCode":"7713","vnDate":"2018-06-29","vnTime":"13:38:00","vnPlace":"青年大学","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"9","driverDirection":"","penaltyResult":"","carNo":"鲁RG7713","driverName":"昝秀环","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":960,"busCode":"7783","vnDate":"2018-07-18","vnTime":"09:30:00","vnPlace":"西安康庄","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"18","driverDirection":"","penaltyResult":"","carNo":"鲁RG7783","driverName":"李广超","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":962,"busCode":"50720","vnDate":"2018-07-18","vnTime":"11:24:00","vnPlace":"青年康庄","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"101","driverDirection":"","penaltyResult":"","carNo":"鲁RN0720","driverName":"郭战民","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":963,"busCode":"51907","vnDate":"2018-08-05","vnTime":"11:48:00","vnPlace":"八一青年","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"4","driverDirection":"","penaltyResult":"","carNo":"鲁RN1907","driverName":"王海林","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":964,"busCode":"3560","vnDate":"2018-01-06","vnTime":"17:52:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"1","driverDirection":"","penaltyResult":"","carNo":"鲁RG3560","driverName":"王成武","violationResp":"","vnOper":"","vnOperDate":"","orgName":"三公司"},{"vnId":965,"busCode":"2132","vnDate":"2018-04-20","vnTime":"16:21:00","vnPlace":"长江牡丹","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"27","driverDirection":"","penaltyResult":"","carNo":"鲁RG0132","driverName":"都方胜","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":966,"busCode":"553","vnDate":"2018-06-14","vnTime":"13:47:00","vnPlace":"牡丹中山","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"27","driverDirection":"","penaltyResult":"","carNo":"鲁RG0553","driverName":"田玉合","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":967,"busCode":"6773","vnDate":"2018-04-20","vnTime":"13:50:00","vnPlace":"丹阳华英","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"16","driverDirection":"","penaltyResult":"","carNo":"鲁RG6773","driverName":"宋博","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":969,"busCode":"58163","vnDate":"2018-07-18","vnTime":"19:20:00","vnPlace":"点将东方红","vnFine":200,"vnMark":"3","vnProject":"13010-逆向行驶","lineCode":"21","driverDirection":"","penaltyResult":"","carNo":"鲁RN8163","driverName":"任福珍","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":976,"busCode":"212","vnDate":"2018-08-01","vnTime":"05:00:00","vnPlace":"中山人民","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"50","driverDirection":"","penaltyResult":"","carNo":"鲁RG0212","driverName":"林福良","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":977,"busCode":"","vnDate":"2018-06-23","vnTime":"13:57:00","vnPlace":"青年大学口","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"2","driverDirection":"","penaltyResult":"","carNo":"鲁RG2157","driverName":"李兆存","violationResp":"","vnOper":"","vnOperDate":""},{"vnId":978,"busCode":"2756","vnDate":"2018-08-01","vnTime":"15:06:00","vnPlace":"中山人民","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"88","driverDirection":"","penaltyResult":"","carNo":"鲁RG2756","driverName":"杨亚波","violationResp":"","vnOper":"","vnOperDate":"","orgName":"定制公交公司"},{"vnId":979,"busCode":"","vnDate":"2018-05-22","vnTime":"14:16:53","vnPlace":"牡丹解放","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"88","driverDirection":"","penaltyResult":"","carNo":"鲁RG2756","driverName":"吴延河","violationResp":"","vnOper":"","vnOperDate":""},{"vnId":984,"busCode":"7397","vnDate":"2018-07-22","vnTime":"09:23:00","vnPlace":"点将东方红","vnFine":200,"vnMark":"3","vnProject":"13010-逆向行驶","lineCode":"48","driverDirection":"","penaltyResult":"","carNo":"鲁RG7397","driverName":"于际敏","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":985,"busCode":"","vnDate":"2018-01-04","vnTime":"19:48:00","vnPlace":"中华重庆","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"56","driverDirection":"","penaltyResult":"","carNo":"鲁RG7515","driverName":"吴建华","violationResp":"","vnOper":"","vnOperDate":""},{"vnId":991,"busCode":"7591","vnDate":"2018-01-03","vnTime":"10:51:00","vnPlace":"曹州西安","vnFine":50,"vnMark":"3","vnProject":"13570-未礼让行人","lineCode":"7","driverDirection":"","penaltyResult":"","carNo":"鲁RG7591","driverName":"王春见","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":996,"busCode":"7625","vnDate":"2018-08-01","vnTime":"14:57:40","vnPlace":"西安曹州","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"7","driverDirection":"","penaltyResult":"","carNo":"鲁RG7625","driverName":"李建玉","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"},{"vnId":997,"busCode":"","vnDate":"2018-08-01","vnTime":"14:57:00","vnPlace":"西安曹州","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"7","driverDirection":"","penaltyResult":"","carNo":"鲁RG7625","driverName":"杨惠敏","violationResp":"","vnOper":"","vnOperDate":""},{"vnId":999,"busCode":"","vnDate":"2018-03-29","vnTime":"07:11:00","vnPlace":"八一昆明","vnFine":100,"vnMark":"2","vnProject":"12080-不按行进方向行驶","lineCode":"7","driverDirection":"","penaltyResult":"","carNo":"鲁RG7635","driverName":"胡教兰","violationResp":"","vnOper":"","vnOperDate":""},{"vnId":1001,"busCode":"7832","vnDate":"2018-05-13","vnTime":"09:05:00","vnPlace":"黄河路","vnFine":200,"vnMark":"6","vnProject":"16250-违反信号行驶","lineCode":"15","driverDirection":"","penaltyResult":"","carNo":"鲁RG7832","driverName":"孙传友","violationResp":"","vnOper":"","vnOperDate":"","orgName":"一公司"}]
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
         * vnId : 490
         * busCode : 1167
         * vnDate : 2018-01-08
         * vnTime : 10:14:16
         * vnPlace : 青年大学
         * vnFine : 50.0
         * vnMark : 3
         * vnProject : 13570-未礼让行人
         * lineCode : 2
         * driverDirection :
         * penaltyResult :
         * carNo : 鲁RG1167
         * driverName : 张朝振
         * violationResp :
         * vnOper :
         * vnOperDate :
         * orgName : 一公司
         */

        private int vnId;
        private String busCode;
        private String vnDate;
        private String vnTime;
        private String vnPlace;
        private double vnFine;
        private String vnMark;
        private String vnProject;
        private String lineCode;
        private String driverDirection;
        private String penaltyResult;
        private String carNo;
        private String driverName;
        private String violationResp;
        private String vnOper;
        private String vnOperDate;
        private String orgName;

        public int getVnId() {
            return vnId;
        }

        public void setVnId(int vnId) {
            this.vnId = vnId;
        }

        public String getBusCode() {
            return busCode;
        }

        public void setBusCode(String busCode) {
            this.busCode = busCode;
        }

        public String getVnDate() {
            return vnDate;
        }

        public void setVnDate(String vnDate) {
            this.vnDate = vnDate;
        }

        public String getVnTime() {
            return vnTime;
        }

        public void setVnTime(String vnTime) {
            this.vnTime = vnTime;
        }

        public String getVnPlace() {
            return vnPlace;
        }

        public void setVnPlace(String vnPlace) {
            this.vnPlace = vnPlace;
        }

        public double getVnFine() {
            return vnFine;
        }

        public void setVnFine(double vnFine) {
            this.vnFine = vnFine;
        }

        public String getVnMark() {
            return vnMark;
        }

        public void setVnMark(String vnMark) {
            this.vnMark = vnMark;
        }

        public String getVnProject() {
            return vnProject;
        }

        public void setVnProject(String vnProject) {
            this.vnProject = vnProject;
        }

        public String getLineCode() {
            return lineCode;
        }

        public void setLineCode(String lineCode) {
            this.lineCode = lineCode;
        }

        public String getDriverDirection() {
            return driverDirection;
        }

        public void setDriverDirection(String driverDirection) {
            this.driverDirection = driverDirection;
        }

        public String getPenaltyResult() {
            return penaltyResult;
        }

        public void setPenaltyResult(String penaltyResult) {
            this.penaltyResult = penaltyResult;
        }

        public String getCarNo() {
            return carNo;
        }

        public void setCarNo(String carNo) {
            this.carNo = carNo;
        }

        public String getDriverName() {
            return driverName;
        }

        public void setDriverName(String driverName) {
            this.driverName = driverName;
        }

        public String getViolationResp() {
            return violationResp;
        }

        public void setViolationResp(String violationResp) {
            this.violationResp = violationResp;
        }

        public String getVnOper() {
            return vnOper;
        }

        public void setVnOper(String vnOper) {
            this.vnOper = vnOper;
        }

        public String getVnOperDate() {
            return vnOperDate;
        }

        public void setVnOperDate(String vnOperDate) {
            this.vnOperDate = vnOperDate;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }
    }
}
