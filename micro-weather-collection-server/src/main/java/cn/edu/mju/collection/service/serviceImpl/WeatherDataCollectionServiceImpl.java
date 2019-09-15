package cn.edu.mju.collection.service.serviceImpl;

import cn.edu.mju.collection.constant.RedisConstant;
import cn.edu.mju.collection.constant.WeatherConstant;
import cn.edu.mju.collection.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
@Service
@Slf4j
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {

        String uri = WeatherConstant.WEATHER_URL_CITY_KEY + cityId;

        saveWeatherData(uri);

    }


    /**
     * 保存天气数据到redis中
     * @param uri
     */
    private void saveWeatherData(String uri){

        String key = uri;

        String value = "";

        value = restTemplate.getForObject(uri, String.class);
        //将数据写入缓存
        log.info("调用第三方接口获取天气数据，将数据写入缓存!");

        stringRedisTemplate.opsForValue()
                .set(key,value,RedisConstant.TIME_OUT,TimeUnit.SECONDS);

    }



}
