package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbUser;

import java.util.Map;

public interface UserService extends IService<TbUser> {

    TbUser selectName(String username,String phone);

    IPage<Map<String,Object>> selectList(IPage page,String username,Integer status,String nick_Name);

    TbUser selectUser(String username,String phone,String password);
}
