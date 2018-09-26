package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * TbSeckillOrder entity. @author MyEclipse Persistence Tools
 */
@Getter
@Setter
public class TbSeckillOrder implements Serializable {

	// Fields

	private Long id;
	private Long seckill_Id;
	private Double money;
	private String user_Id;
	private String seller_Id;
	private Timestamp create_Time;
	private Timestamp pay_Time;
	private String status;
	private String receiver_Address;
	private String receiver_Mobile;
	private String receiver;
	private String transaction_Id;


}