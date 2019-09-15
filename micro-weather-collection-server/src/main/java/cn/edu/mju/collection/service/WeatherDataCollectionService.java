package cn.edu.mju.collection.service;

/**
 * 数据采集服务接口
 *
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市id同步天气信息
     * @param cityId
     */
    void syncDataByCityId(String cityId);



}
