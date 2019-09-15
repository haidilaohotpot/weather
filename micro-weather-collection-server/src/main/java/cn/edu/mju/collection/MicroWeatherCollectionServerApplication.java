package cn.edu.mju.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroWeatherCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCollectionServerApplication.class, args);
    }

}
