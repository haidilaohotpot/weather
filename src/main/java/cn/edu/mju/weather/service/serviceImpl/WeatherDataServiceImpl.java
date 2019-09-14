package cn.edu.mju.weather.service.serviceImpl;

import cn.edu.mju.weather.constant.WeatherConstant;
import cn.edu.mju.weather.entity.Weather;
import cn.edu.mju.weather.entity.WeatherResponse;
import cn.edu.mju.weather.service.WeatherDataService;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.config.ClientConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {


    @Autowired
    private RestTemplate restTemplate;


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
     * 根据uri发起一个http请求 获取天气数据
     *
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) throws RuntimeException {

        String responseString = restTemplate.getForObject(uri, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            // TODO: 2019/9/14 处理字符编码问题
//            return objectMapper.readValue(responseString, WeatherResponse.class);
            return new WeatherResponse();

        } catch (Exception e) {
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

}
