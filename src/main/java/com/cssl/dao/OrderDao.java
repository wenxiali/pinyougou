package com.cssl.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.SuperMapper;
import com.cssl.pojo.TbOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDao extends SuperMapper<TbOrder> {
    IPage<Map<String,Object>> selectList(IPage page,
                                         @Param("username") String userName,
                                         @Param("status") Integer status,
                                         @Param("nick_Name") String nick_Name);

    List<Map<String,Object>> selectOrder(@Param("orderId") Long orderId);
}
