package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbOrderItem entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbOrderItem implements Serializable {

	// Fields

	private Long id;
	private Long item_Id;
	private Long goods_Id;
	private Long order_Id;
	private String title;
	private Double price;
	private Integer num;
	private Double total_Fee;
	private String pic_Path;
	private String seller_Id;

}