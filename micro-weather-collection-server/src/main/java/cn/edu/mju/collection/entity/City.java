package cn.edu.mju.collection.entity;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市实体类
 * @author cheng
 * @version 1.0
 * @since 1.0
 */
@Data
public class City {


    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;


}
