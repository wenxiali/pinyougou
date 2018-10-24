package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * TbAddress entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbAddress implements Serializable {

	// Fields

	private Long aid;
	private String username;
	private String province_Id;
	private String city_Id;
	private String town_Id;
	private String mobile;
	private String address;
	private String contact;
	private int is_Default; //改
	private String notes;
	private Date create_Date; //改
	private String alias;



}