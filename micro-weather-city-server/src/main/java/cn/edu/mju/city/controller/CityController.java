package cn.edu.mju.city.controller;

import cn.edu.mju.city.entity.City;
import cn.edu.mju.city.service.CityDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
