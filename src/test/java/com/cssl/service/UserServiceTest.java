package com.cssl.service;

import com.cssl.pojo.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
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

        int coiun=userService.updateUser(user);
        System.out.println(coiun);
    }

    @Test
    public void getUser() {
    }
}