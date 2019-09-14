package cn.edu.mju.weather.config;

import cn.edu.mju.weather.constant.QuartzConstant;
import cn.edu.mju.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定时任务配置
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class QuartzConfiguration {

    //JobDetail
    @Bean
    public JobDetail weatherDataSyncJobJobDetail(){

        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();

    }

    //Trigger
    @Bean
    public Trigger weatherDataSyncTrigger(){

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(QuartzConstant.TIME).repeatForever();


        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail()).withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder).build();

    }

}
