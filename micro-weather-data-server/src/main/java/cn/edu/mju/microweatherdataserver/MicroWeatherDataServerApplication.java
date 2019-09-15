package cn.edu.mju.microweatherdataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroWeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherDataServerApplication.class, args);
    }

}
