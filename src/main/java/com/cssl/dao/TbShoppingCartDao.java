package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbShoppingCart;

public interface TbShoppingCartDao  extends SuperMapper<TbShoppingCart> {

    /**
     * 添加
     */
    public int inserttj(TbShoppingCart tbs);

}
