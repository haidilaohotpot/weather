package cn.edu.mju.weather.service;

import cn.edu.mju.weather.entity.City;

import java.util.List;

/**
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
public interface CityDataService {

    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;


}
