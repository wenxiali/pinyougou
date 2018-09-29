package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbOrder entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbOrder implements Serializable {

	// Fields

	private Long orderId;
	private Double payment;
	private String payment_Type;
	private String post_Fee;
	private String status;
	private Timestamp create_Time;
	private Timestamp update_Time;
	private Timestamp payment_Time;
	private Timestamp consign_Time;
	private Timestamp end_Time;
	private Timestamp close_Time;
	private String shipping_Name;
	private String shipping_Code;
	private String user_Id;
	private String buyer_Message;
	private String buyer_Nick;
	private String buyer_Rate;
	private String receiver_Area_Name;
	private String receiver_Mobile;
	private String receiver_Zip_Code;
	private String receiver;
	private Timestamp expire;
	private String invoice_Type;
	private String source_Type;
	private String seller_Id;
	private TbOrderItem tbOrderItem;

}