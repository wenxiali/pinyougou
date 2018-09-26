package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbFreightTemplate entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbFreightTemplate implements Serializable {

	// Fields

	private Long id;
	private String seller_Id;
	private String is_Default;
	private String name;
	private String send_Time_Type;
	private Long price;
	private Timestamp create_Time;


}