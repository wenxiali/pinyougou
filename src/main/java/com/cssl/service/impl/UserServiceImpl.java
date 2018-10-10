package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.UserDao;
import com.cssl.pojo.TbUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserDao,TbUser> implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public TbUser selectName(String username,String phone) {
        return dao.selectName(username,phone);
    }


    @Override
    public IPage<Map<String,Object>> selectList(IPage page,String username,Integer status,String nick_Name) {
        return dao.selectList(page,username,status,nick_Name);
    }

    @Override
    public TbUser selectUser(String username, String phone, String password) {
        return dao.selectUser(username,phone,password);
    }
}
