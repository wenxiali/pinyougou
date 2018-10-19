package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbItemCat entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbItemCat implements Serializable {

	// Fields

	private Long id;
	private Long parent_Id;
	private String name;


}