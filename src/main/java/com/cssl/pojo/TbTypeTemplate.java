package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbTypeTemplate entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbTypeTemplate implements Serializable {

	// Fields

	private Long id;
	private String name;
	private String spec_Ids;
	private String brand_Ids;
	private String custom_Attribute_Items;


}