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
    public TbUser selectUser(String username, String phone, String password) {
        return dao.selectUser(username,phone,password);
    }

    @Override
    public int updateUser(TbUser user) {
        return dao.updateUser(user);
    }

    @Override
    public TbUser getUser(String username) {
        return dao.byenUser(username);
    }
}
