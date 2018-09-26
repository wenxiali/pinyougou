package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbUser entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbUser implements Serializable {

	public TbUser(){

	}

	private Long id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private Timestamp created;
	private Timestamp updated;
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
	private Timestamp birthday;
	private Timestamp last_Login_Time;



}