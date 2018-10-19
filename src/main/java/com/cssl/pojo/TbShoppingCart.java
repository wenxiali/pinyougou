package com.cssl.pojo;

import lombok.Data;

@Data
public class TbShoppingCart {
    private int id;
    private String sctitle;
    private String scimage;
    private Double scprice;
    private String scseller_id;
    private Integer user_id;
}
