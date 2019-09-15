package cn.edu.mju.microweatherdataserver.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 */

@Data
public class Weather implements Serializable {

    /**
     * {"data":
     * {"yesterday":
     * {"date":"13日星期五","high":"高温 34℃","fx":"东风","low":"低温 25℃","fl":"<![CDATA[<3级]]>","type":"多云"},"city":"福州","forecast":[{"date":"14日星期六","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"东风","type":"多云"},{"date":"15日星期天","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"东风","type":"多云"},
     * {"date":"16日星期一","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"东风","type":"多云"},{"date":"17日星期二","high":"高温 33℃","fengli":"<![CDATA[<3级]]>","low":"低温 25℃","fengxiang":"东风","type":"多云"},{"date":"18日星期三","high":"高温 32℃","fengli":"<![CDATA[3-4级]]>","low":"低温 24℃","fengxiang":"东北风","type":"多云"}],"ganmao":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。","wendu":"32"},"status":1000,"desc":"OK"}
     */

    private String city;

    private String aqi;

    private String ganmao;

    private String wendu;

    private Yesterday yesterday;

    private List<Forecast> forecastList;







}
