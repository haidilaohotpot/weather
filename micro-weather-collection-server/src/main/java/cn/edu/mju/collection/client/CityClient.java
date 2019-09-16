package cn.edu.mju.collection.client;

import cn.edu.mju.collection.entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author <a href="https://github.com/haidilaohotpot">wonder4work</a>
 * @since 1.0.0 2019/9/16
 */
@FeignClient("city")
@Service
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;

}
