package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TbAreas implements Serializable {
    private int id;
    private String areaId;
    private String area;
    private String cityId;
}
