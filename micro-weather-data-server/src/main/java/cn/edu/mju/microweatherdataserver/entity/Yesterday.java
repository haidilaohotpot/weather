package cn.edu.mju.microweatherdataserver.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class Yesterday implements Serializable {

    private String date;

    private String high;

    private String fx;

    private String low;

    private String fl;

    private String type;



}
