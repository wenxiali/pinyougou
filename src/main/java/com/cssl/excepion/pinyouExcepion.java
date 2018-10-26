package com.cssl.excepion;

import com.cssl.enums.ShoppingEnum;

public class pinyouExcepion extends RuntimeException {
    private Integer code;

    public pinyouExcepion(ShoppingEnum shoppingEnum){
        super(shoppingEnum.getMessge());
        this.code=shoppingEnum.getCode();
    }

    public pinyouExcepion(Integer code,String message){
        super(message);
        this.code=code;
    }
}
