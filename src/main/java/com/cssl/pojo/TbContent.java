package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbContent entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbContent implements Serializable {

	// Fields

	private Long id;
	private Long category_Id;
	private String title;
	private String url;
	private String pic;
	private String status;
	private Integer sort_Order;


}