package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbPayLog entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbPayLog implements Serializable {

	// Fields

	private String out_Trade_No;
	private Timestamp create_Time;
	private Timestamp pay_Time;
	private Long total_Fee;
	private String user_Id;
	private String transaction_Id;
	private String trade_State;
	private String order_List;
	private String pay_Type;



}