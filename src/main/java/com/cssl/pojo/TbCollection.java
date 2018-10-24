package com.cssl.pojo;

import lombok.Data;

@Data
public class TbCollection {
    //收藏表
    private int id;
    private Long iid;
    private Long uid;
    private String ctitle;
    private Double cprice;
    private String cimage;
}
