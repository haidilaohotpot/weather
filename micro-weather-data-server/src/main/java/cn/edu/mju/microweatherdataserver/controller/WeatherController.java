package cn.edu.mju.microweatherdataserver.controller;

import cn.edu.mju.microweatherdataserver.entity.WeatherResponse;
import cn.edu.mju.microweatherdataserver.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询天气信息
 */
@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherService;


    /**
     * 根据城市的键 获取城市天气信息
     * @param cityKey 城市键值
     * @return
     */
    @GetMapping("/cityKey/{cityKey}")
    public WeatherResponse cityKey(@PathVariable("cityKey") String cityKey){

        try {

            return weatherService.getDataByCityKey(cityKey);

        }catch (Exception e){
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }

    /**
     * 根据城市名称获取天气信息
     * @param cityName 城市名称
     * @return
     */
    @GetMapping("/cityName/{cityName}")
    public WeatherResponse cityName(@PathVariable("cityName") String cityName){

        try {

            return weatherService.getDataByCityName(cityName);

        }catch (Exception e){
            log.error("获取天气信息失败，{}", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }


    }


}
