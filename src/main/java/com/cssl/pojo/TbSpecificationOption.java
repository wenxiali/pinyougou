package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * TbSpecificationOption entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbSpecificationOption implements Serializable {

	// Fields

	private Long id;
	private String option_Name;
	private Long spec_Id;
	private Integer orders;


}