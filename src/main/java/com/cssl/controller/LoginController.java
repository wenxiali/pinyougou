package com.cssl.controller;

import com.cssl.pojo.TbUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    /**
     * 注冊
     *
     * @param user
     * @return
     */
    @RequestMapping("register.action")
    public String register(TbUser user) {
        if (user.getUsername() != null) {
            user.setCreated(new Date());
            user.setUpdated(new Date());
            int row = service.insertUser(user);
            System.out.println("注冊成功");

            return "login";
        } else {
            System.out.println("注冊失敗");
            return "register";
        }
    }

    /**
     * 验证用戶名信息
     *
     * @param username
     * @return
     */
    @RequestMapping("verification")
    public void RegisterName(String username,String phone, HttpServletResponse response) throws IOException {
        //判断该用户名是否已被注册
        TbUser num = service.selectName(username,phone);
        String text = "";
        if (num == null) {
            text = "N";
        } else {
            text = "Y";
        }
        PrintWriter out = response.getWriter();
        out.write(text);
        out.flush();
        out.close();
    }


    /**
     * 登陆
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login.action")
    public String login(String username, String password, HttpSession session) {
        TbUser user = service.selectUser(username, username, password);
        if (user != null) {
            session.setAttribute("username", user.getUsername());
            return "forward:home-index";
        }
        return "login";
    }
}
