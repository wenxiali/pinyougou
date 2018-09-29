package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cssl.dao.UserDao;
import com.cssl.pojo.TbUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public int insertUser(TbUser user) {
        return dao.insertUser(user);
    }

    @Override
    public TbUser selectName(String username,String phone) {
        return dao.selectName(username,phone);
    }


    @Override
    public IPage<Map<String,Object>> selectList(IPage page,String username) {
        return dao.selectList(page,username);
    }

    @Override
    public TbUser selectUser(String username, String phone, String password) {
        return dao.selectUser(username,phone,password);
    }
}
