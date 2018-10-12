package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbUser implements Serializable {

	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private Date created;
	private Date updated;
	private String source_Type;
	private String nick_Name;
	private String name;
	private String status;
	private String head_Pic;
	private String qq;
	private Long account_Balance;
	private String is_Mobile_Check;
	private String is_Email_Check;
	private String sex;
	private Integer user_Level;
	private Integer points;
	private Integer experience_Value;
	private Date birthday;
	private Date last_Login_Time;
	private String province_Id;
	private String city_Id;
	private String town_Id;

}