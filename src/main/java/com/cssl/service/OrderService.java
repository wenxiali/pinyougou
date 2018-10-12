package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbOrder;

import java.util.Map;

public interface OrderService extends IService<TbOrder> {

    IPage<Map<String,Object>> selectList(IPage page, String username, Integer status, String nick_Name);

}
