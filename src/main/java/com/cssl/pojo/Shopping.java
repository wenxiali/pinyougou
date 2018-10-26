package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Shopping {
   private Integer shoppingid; //购物车id
   private String sellertitle; //商店名称
   private String itemtitle;   //商品名称
   private String itemImg; //商品图片
   private double itemQuantity; //商品数量
   private int itemClick;
   private double itemPrice;    //商品单价
   private double amount;   //商品总价

}
