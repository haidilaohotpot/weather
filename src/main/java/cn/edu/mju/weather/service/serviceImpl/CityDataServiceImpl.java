package cn.edu.mju.weather.service.serviceImpl;

import cn.edu.mju.weather.entity.City;
import cn.edu.mju.weather.entity.CityList;
import cn.edu.mju.weather.service.CityDataService;
import cn.edu.mju.weather.utils.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
@Service
public class CityDataServiceImpl implements CityDataService {


    @Override
    public List<City> listCity() throws Exception {

        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");

        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));

        StringBuffer buffer = new StringBuffer();

        String line = "";
        while ((line = bf.readLine()) != null) {

            buffer.append(line);

        }
        bf.close();
        //xml转换为java对象
        CityList cityList = (CityList)XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());
        return cityList.getCityList();
    }


}
