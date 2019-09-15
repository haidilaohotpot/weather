package cn.edu.mju.city.service;

import cn.edu.mju.city.entity.City;

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
