package com.cssl.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * TbBrand entity. @author MyEclipse Persistence Tools
 */
@Data
public class TbBrand implements Serializable {

	// Fields
	private Long id;
	private String name;
	private String first_Char;
	private String image;

}