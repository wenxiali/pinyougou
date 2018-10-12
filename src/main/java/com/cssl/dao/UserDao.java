package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbUser;
import org.apache.ibatis.annotations.Param;

public interface UserDao extends SuperMapper<TbUser> {

    TbUser selectName(@Param("username") String username,@Param("phone") String phone);


    TbUser selectUser(@Param("username") String username,@Param("phone") String phone,@Param("password") String password);
}
