package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.OrderItemDao;
import com.cssl.pojo.TbOrderItem;
import com.cssl.service.OrderItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, TbOrderItem> implements OrderItemService {


}
