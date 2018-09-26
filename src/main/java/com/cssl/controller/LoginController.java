package com.cssl.controller;

import com.cssl.pojo.TbUser;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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
    public void RegisterName(String username, HttpServletResponse response) throws IOException {
        //判断该用户名是否已被注册
        TbUser num = service.selectName(username);
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
     * 验证手機號信息
     *
     * @param phone
     * @return
     */
    @RequestMapping("verification")
    public void RegisterPhone(String phone, HttpServletResponse response) throws IOException {
        //判断该用户名是否已被注册
        TbUser num = service.selectPhone(phone);
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

    @RequestMapping("/login.action")
    public String login(String username, String password, HttpSession session, String isTrue,HttpServletRequest request, HttpServletResponse response) {
        TbUser user = service.selectUser(username, username, password);
        if (user != null) {
            //System.out.println("登陆："+user.getUsername());
           /* //记住密码操作
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("isTrue")) {
                        String name = cookies[i].getValue();
                        if (("true").equals(name)) {
                            Cookie users = new Cookie("users", user.getUsername() + "-" + user.getPassword());
                            response.addCookie(users);
                        } else {
                            Cookie users = new Cookie("users", "null");//这里试了很多种方式，我的就只有这种在取值的时候不报错。
                            response.addCookie(users);
                        }
                    }
                }
            }*/

            session.setAttribute("username", user.getUsername());
            return "forward:home-index";
        }
        return "login";
    }
}
