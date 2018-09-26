package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbGoodsDesc entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbGoodsDesc implements Serializable {

	// Fields

	private Long goodsId;
	private String introduction;
	private String specification_Items;
	private String custom_Attribute_Items;
	private String item_Images;
	private String package_List;
	private String sale_Service;


}