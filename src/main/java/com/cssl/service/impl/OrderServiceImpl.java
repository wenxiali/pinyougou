package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.OrderDao;
import com.cssl.pojo.TbOrder;
import com.cssl.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends ServiceImpl<OrderDao, TbOrder> implements OrderService {
}

