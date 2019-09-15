package cn.edu.mju.microweatherdataserver.entity;

import lombok.Data;

import java.io.Serializable;


/**
 *
 * 天气数据的响应对象
 *
 */
@Data
public class WeatherResponse implements Serializable {

    private Weather data;

    private Integer status;

    private String desc;



}
