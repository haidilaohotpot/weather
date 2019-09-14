package cn.edu.mju.weather.service;

import cn.edu.mju.weather.entity.WeatherResponse;

/**
 *
 * @see cn.edu.mju.weather.service.serviceImpl.WeatherDataServiceImpl
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


    /**
     * 根据城市id同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);


}
