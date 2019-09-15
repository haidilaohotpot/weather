package cn.edu.mju.microweatherdataserver.service;

import cn.edu.mju.microweatherdataserver.entity.WeatherResponse;


/**
 *
 * 获取天气服务
 *
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityKey
     * @return
     */
    WeatherResponse getDataByCityKey(String cityKey) throws RuntimeException;

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName) throws RuntimeException;



}
