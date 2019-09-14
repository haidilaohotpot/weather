package cn.edu.mju.weather.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * 城市集合
 *
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

}
