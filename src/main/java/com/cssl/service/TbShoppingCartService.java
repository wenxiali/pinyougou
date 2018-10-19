package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbShoppingCart;

public interface TbShoppingCartService extends IService<TbShoppingCart> {

    /**
     * 添加
     */
    public int inserttj(TbShoppingCart tbs);

}
