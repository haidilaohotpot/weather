package cn.edu.mju.weather.service.serviceImpl;

import cn.edu.mju.weather.constant.RedisConstant;
import cn.edu.mju.weather.constant.WeatherConstant;
import cn.edu.mju.weather.entity.Weather;
import cn.edu.mju.weather.entity.WeatherResponse;
import cn.edu.mju.weather.service.WeatherDataService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.config.ClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public WeatherResponse getDataByCityKey(String cityKey) throws RuntimeException {

        String uri = WeatherConstant.WEATHER_URL_CITY_KEY + cityKey;

        //获取天气信息
        try{
            return doGetWeather (uri);
        }catch (Exception e){
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public WeatherResponse getDataByCityName(String cityName) throws RuntimeException {

        String uri = WeatherConstant.WEATHER_URL_CITY_NAME + cityName;

        //获取天气信息
        try{
            return doGetWeather (uri);
        }catch (Exception e){
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

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


    /**
     * 根据uri发起一个http请求 获取天气数据
     *
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) throws RuntimeException {


        //先从Redis缓存中查询

        String key = uri;

        String value = "";

        if (stringRedisTemplate.hasKey(key)) {
            //redis中有数据
            log.info("从缓冲redis中获取天气信息");
            value = stringRedisTemplate.opsForValue().get(key);

        }else{
            value = restTemplate.getForObject(uri, String.class);
            //将数据写入缓存
            log.info("调用第三方接口获取天气数据，将数据写入缓存!");
            stringRedisTemplate.opsForValue().set(key,value,RedisConstant.TIME_OUT,TimeUnit.SECONDS);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // TODO: 2019/9/14 处理字符编码问题
//            return objectMapper.readValue(value, WeatherResponse.class);
            return new WeatherResponse();

        } catch (Exception e) {
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
