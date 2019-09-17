package cn.edu.mju.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class MicroWeatherCityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCityServerApplication.class, args);
    }

}
