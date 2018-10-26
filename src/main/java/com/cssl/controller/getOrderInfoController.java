package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.TbAddress;
import com.cssl.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class getOrderInfoController  {

    @Autowired
    private AddressService service;


    /**
     * 根据登陆名查询地址
     */
    @RequestMapping("/getOrderInfo")
    public String getOrderInfo(HttpSession session, Model model){
       String username=(String) session.getAttribute("username");
       if(username==null){
           return "login";
       }
        List<TbAddress> listdad=service.selectList(new QueryWrapper<TbAddress>().eq("username",username));
        model.addAttribute("listdad",listdad);
        return "getOrderInfo";
    }
}
