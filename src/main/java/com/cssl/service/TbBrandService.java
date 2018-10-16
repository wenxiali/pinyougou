package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbBrand;

import java.util.List;

public interface TbBrandService extends IService<TbBrand> {
    /**
     * 查询手机品牌
     */
    public List<TbBrand> listbrand();
}
