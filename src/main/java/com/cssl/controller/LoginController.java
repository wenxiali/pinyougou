package com.cssl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbAddress;
import com.cssl.pojo.TbUser;
import com.cssl.service.AddressService;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @Autowired
    private AddressService aService;

    /**
     * 注冊
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }


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
            boolean row = service.insert(user);
            return "login";
        } else {
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
    public void RegisterName(String username, String phone, HttpServletResponse response) throws IOException {
        //判断该用户名是否已被注册
        TbUser num = service.selectName(username, phone);
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
     * 登陸
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登陆
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login.action")
    public String login(String username, String password, HttpSession session) {
        TbUser user = service.selectUser(username, username, password);
        if (user != null) {
            session.setAttribute("id", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("phone", user.getPhone());
            session.setAttribute("head_Pic", user.getHead_Pic());
            return "forward:home-index";
        }
        return "login";
    }

    /**
     * 基本资料完善
     *
     * @param user
     * @return
     */
    @RequestMapping("/home-setting-info.action")
    private String insertInfo(TbUser user, String username, HttpSession session) {
        username = (String) session.getAttribute("username");
        if (user.getUsername().equals(username)) {
            int row = service.updateUser(user);
            if (row > 0) {
                return "home";
            }
        }
        return "home-setting-info";
    }

    /**
     * 地址管理
     *
     * @return
     */
    @RequestMapping("/home-setting-address.action")
    public String homesettingaddress(Integer pa, Integer id, String username, Model model, HttpSession session) {
        if (pa == null || pa == 0) {
            pa = 1;
        }
        username = (String) session.getAttribute("username");
        IPage<Map<String, Object>> address = aService.selectAddress(new Page(pa, 10), username, id);
        model.addAttribute("address", address);
        return "home-setting-address";
    }

    @RequestMapping("/insert.action")
    public String insertAddress(TbAddress address, HttpSession session) {
        String username = (String) session.getAttribute("username");
        address.setUsername(username);
        address.setCreate_Date(new Date());
        boolean row = aService.insert(address);
        if (row) {
            return "redirect:/home-setting-address.action";
        } else {
            return "redirect:/home-setting-address.action";
        }
    }

    /**
     * 安全管理页面
     * @return
     */
    @RequestMapping("/home-setting-safe")
    public String homesettingsafe(){

        return "home-setting-safe";
    }

    @RequestMapping("/home-setting-safe-phone")
    public String a(){

        return "home-setting-safe-phone";
    }

    @RequestMapping("/home-setting-safe-complete")
    public String b(){

        return "home-setting-safe-complete";
    }


    @RequestMapping("/modify.action")
    public String update(){
        return "redirect:/home-setting-address.action";
    }

}
