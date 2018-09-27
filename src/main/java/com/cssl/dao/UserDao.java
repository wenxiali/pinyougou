package com.cssl.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserDao   {
    int insertUser(TbUser user);

    TbUser selectName(@Param("username") String username,@Param("phone") String phone);

    IPage<Map<String,Object>> selectList(IPage page,@Param("username") String username);

    TbUser selectUser(@Param("username") String username,@Param("phone") String phone,@Param("password") String password);
}
