package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbBrand;

import java.util.List;

public interface TbBrandDao extends SuperMapper<TbBrand> {

    /**
     * 查询手机品牌
     */
    public List<TbBrand> listbrand();
}
