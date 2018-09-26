package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.pojo.TbUser;

import java.util.Map;

public interface UserService {
    int insertUser(TbUser user);

    TbUser selectName(String username);

    TbUser selectPhone(String phone);

    IPage<Map<String,Object>> selectList(IPage page,String username);

    TbUser selectUser(String username,String phone,String password);
}
