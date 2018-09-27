package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * TbSeller entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbSeller implements Serializable {

	// Fields

	private String seller_Id;
	private String name;
	private String nick_Name;
	private String password;
	private String email;
	private String mobile;
	private String telephone;
	private String status;
	private String address_Detail;
	private String linkman_Name;
	private String linkman_Qq;
	private String linkman_Mobile;
	private String linkman_Email;
	private String license_Number;
	private String tax_Number;
	private String org_Number;
	private Long address;
	private String logo_Pic;
	private String brief;
	private Date create_Time;
	private String legal_Person;
	private String legal_Person_Card_Id;
	private String bank_User;
	private String bank_Name;
	private TbOrderItem tbOrderItem; //引用订单详情表
	private TbSeller tbSeller;   //商家店铺表


}