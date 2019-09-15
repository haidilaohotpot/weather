package cn.edu.mju.collection.job;

import cn.edu.mju.collection.entity.City;
import cn.edu.mju.collection.service.WeatherDataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气同步job
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {



    @Autowired
    private WeatherDataCollectionService WeatherDataCollectionService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        log.info("定时任务开始，从第三方获取天气信息");

        // TODO: 2019/9/15 改为城市数据api来提供服务
        List<City> cityList = null;

        try {
            // TODO: 2019/9/15 替换 cityList
            cityList = new ArrayList<>();

            City city = new City();

            city.setCityId("101280601");
            cityList.add(city);

        } catch (Exception e) {

            log.error("同步天气信息失败,{}",e.getMessage());

        }

        //遍历城市ID获取天气

        cityList.stream().forEach(city -> {

            String cityId = city.getCityId();
            log.info("获取到的城市id={}", cityId);

            WeatherDataCollectionService.syncDataByCityId(cityId);

        });

        log.info("同步天气数据结束");


    }

}
