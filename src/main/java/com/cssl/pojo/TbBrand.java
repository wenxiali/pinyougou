package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbBrand entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbBrand implements Serializable {

	// Fields

	private Long id;
	private String name;
	private String first_Char;


}