package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * TbItem entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbItem implements Serializable {

	// Fields

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
    private String cat_id;












}