package com.cssl.enums;

import lombok.Getter;

@Getter
public enum ShoppingEnum {
    TURIRU(1,"修改商品数量成功"),

    QUANABNORMAL(3,"商品数量至少一个"),
    UNDERSTOCK(4,"库存不足"),
    IDISNULL(5,"用户名为空"),
    CART_EMPTY(6,"购物车为空");
    private Integer code;
    private String messge;

    ShoppingEnum(Integer code, String messge) {
        this.code = code;
        this.messge = messge;
    }
}
