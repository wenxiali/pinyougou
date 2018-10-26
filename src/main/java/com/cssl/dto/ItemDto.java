package com.cssl.dto;

import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbItemCat;
import com.cssl.pojo.TbItemImg;
import com.cssl.pojo.TbSeller;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ItemDto {
    private Long id;
    private String title;
    private String sell_Point;
    private Double price;
    private Integer stock_Count;
    private Integer num;
    private String barcode;
    private String image;
    private Long categoryId;
    private String status;
    private Timestamp create_Time;
    private Timestamp update_Time;
    private String item_Sn;
    private Double cost_Pirce;
    private Double market_Price;
    private String is_Default;
    private Long goods_Id;
    private String seller_Id;
    private String cart_Thumbnail;
    private String category;
    private String brand;
    private String spec;
    private String seller;
    //所属商店
    private TbSeller tbSeller;
    //所属分类
    private TbItemCat tbItemCat;
    //图片详情
    private List<TbItemImg> tbItemImgs=new ArrayList<>();
}
