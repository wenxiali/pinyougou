package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbGoods entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbGoods implements Serializable {

	// Fields

	private Long id;
	private String seller_Id;
	private String goods_Name;
	private Long default_Item_Id;
	private String audit_Status;
	private String is_Marketable;
	private Long brand_Id;
	private String caption;
	private Long category1_Id;
	private Long category2_Id;
	private Long category3_Id;
	private String small_Pic;
	private Double price;
	private Long type_Template_Id;
	private String is_Enable_Spec;
	private String is_Delete;

}