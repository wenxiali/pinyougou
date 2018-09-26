package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbSeckillGoods entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbSeckillGoods implements Serializable {

	// Fields

	private Long id;
	private Long goods_Id;
	private Long item_Id;
	private String title;
	private String small_Pic;
	private Double price;
	private Double cost_Price;
	private String seller_Id;
	private Timestamp create_Time;
	private Timestamp check_Time;
	private String status;
	private Timestamp start_Time;
	private Timestamp end_Time;
	private Integer num;
	private Integer stock_Count;
	private String introduction;


}