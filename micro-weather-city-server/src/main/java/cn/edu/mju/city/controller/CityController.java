package cn.edu.mju.city.controller;

import cn.edu.mju.city.entity.City;
import cn.edu.mju.city.service.CityDataService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">cheng</a>
 * @since 1.0.0 2019/9/15
 */
@Slf4j
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;


    /**
     * 获取城市列表
     * @return
     */
    @GetMapping
    @HystrixCommand(fallbackMethod = "fallback")
    public List<City> listCity() throws RuntimeException {

        List<City> cityList = null;
        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {
            log.error("获取城市列表失败，{}",e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return cityList;
    }

    /**
     * 熔断默认返回的方法
     * @return
     */
    public List<City> fallback(){

        List<City> cityList = new ArrayList<>();
        City city = new City();
        city.setCityName("福州");
        city.setCityCode("1102454");
        city.setCityId("2120245");
        city.setProvince("福建");
        cityList.add(city);
        return cityList;

    }


}
