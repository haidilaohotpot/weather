package cn.edu.mju.microweatherdataserver.service.serviceImpl;

import cn.edu.mju.microweatherdataserver.constant.WeatherConstant;
import cn.edu.mju.microweatherdataserver.entity.WeatherResponse;
import cn.edu.mju.microweatherdataserver.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {


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


    /**
     * 获取天气数据
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

            log.info("获取天气数据失败!");
            throw new RuntimeException("没有此天气数据");
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
