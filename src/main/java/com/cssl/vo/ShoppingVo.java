package com.cssl.vo;

import com.cssl.pojo.Shopping;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShoppingVo {
    private String sellertitle ;
    //商品信息
    List<Shopping> shoppingList=new ArrayList<>();
    //购物车所有商品总价
   /* private double shoppingItemAmount;*/
}
