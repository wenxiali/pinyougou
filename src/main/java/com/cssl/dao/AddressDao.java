package com.cssl.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.SuperMapper;
import com.cssl.pojo.TbAddress;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface AddressDao extends SuperMapper<TbAddress> {
    /**
     * 查询地址
     * @param page
     * @return
     */
    IPage<Map<String,Object>> selectAddress(IPage page,@Param("username") String username, @Param("aId") Integer aId);

    int deleteAdd(@Param("aId") Integer aId);

    TbAddress byenAddress(String username);
}
