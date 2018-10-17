package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.OrderDao;
import com.cssl.pojo.TbOrder;
import com.cssl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderDao, TbOrder> implements OrderService {
    @Autowired
    private OrderDao dao;

    @Override
    public IPage<Map<String,Object>> selectList(IPage page, String username, Integer status, String nick_Name) {
        return dao.selectList(page,username,status,nick_Name);
    }

    @Override
    public  List<Map<String,Object>> selectOrder(Long orderId) {
        return dao.selectOrder(orderId);
    }
}

