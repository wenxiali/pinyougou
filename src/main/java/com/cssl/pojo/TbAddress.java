package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * TbAddress entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbAddress implements Serializable {

	// Fields

	private Long id;
	private String user_Id;
	private String province_Id;
	private String city_Id;
	private String town_Id;
	private String mobile;
	private String address;
	private String contact;
	private String isDefault;
	private String notes;
	private Timestamp createDate;
	private String alias;



}