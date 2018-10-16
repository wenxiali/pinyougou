package com.cssl.dao;

import com.cssl.pojo.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void updateUser() {
        TbUser user=new TbUser();
        user.setUsername("123");
        user.setNick_name("小明");
        user.setEmail("wwee@852478052.com");
        user.setSex("1");
        user.setLast_Login_Time(new Date());
        user.setProvince_Id("110000");
        user.setCity_Id("110100");
        user.setTown_Id("110101");
        user.setJob("吃屎");
        int a=userDao.updateUser(user);
        System.out.println(a);
    }

    @Test
    public void getUser() {
        TbUser tbUser=userDao.byenUser("123");
        System.out.println(tbUser.getNick_name());
        System.out.println(tbUser.getSex());
        System.out.println(tbUser.getJob());
        System.out.println(tbUser.getProvince_Id());
        System.out.println(tbUser.getCity_Id());
        System.out.println(tbUser.getTown_Id());
    }
}