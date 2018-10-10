package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbOrder;
import com.cssl.pojo.TbUser;

public interface OrderDao extends SuperMapper<TbUser> {
    TbOrder selectRate();
}
