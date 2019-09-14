package cn.edu.mju.weather.job;

import cn.edu.mju.weather.entity.City;
import cn.edu.mju.weather.service.CityDataService;
import cn.edu.mju.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 天气同步job
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {


    @Autowired
    private CityDataService cityDataService;


    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("定时任务开始，从第三方获取天气信息");

        List<City> cityList = null;

        try {
            cityList = cityDataService.listCity();
        } catch (Exception e) {

            log.error("同步天气信息失败,{}",e.getMessage());

        }

        //遍历城市ID获取天气

        cityList.stream().forEach(city -> {

            String cityId = city.getCityId();
            log.info("获取到的城市id={}", cityId);

            weatherDataService.syncDataByCityId(cityId);

        });

        log.info("同步天气数据结束");


    }

}
