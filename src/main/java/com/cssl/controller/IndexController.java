package com.cssl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService service;

    /**
     * 個人信息首頁
     * @return
     */
    @RequestMapping("/home-index")
    public String index(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> list = service.selectList(new Page(pa,4),username,status,nick_Name);
        model.addAttribute("list",list);
        return "home-index";
    }

    @RequestMapping("/home-order-pay")
    public String homeorderpay(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> list = service.selectList(new Page(pa,4),username,status,nick_Name);
        model.addAttribute("list",list);
        return "home-order-pay";
    }

    @RequestMapping("/home-order-send")
    public String homeordersend(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> list = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("list",list);
        return "home-order-send";
    }

    @RequestMapping("/home-order-receive")
    public String homeorderreceive(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> list = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("list",list);
        return "home-order-receive";
    }
}
