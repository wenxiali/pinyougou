package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {


    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    /**
     * 登陸
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * 注冊
     */
    @RequestMapping("/register")
    public String register(){
        return "register";
    }


    @RequestMapping("home")
    public String home(){
        return "home";
    }


    @RequestMapping("cart")
    public String cart(){
        return "cart";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-order-pay")
    public String homeorderpay(){
        return "home-order-pay.html";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/home-order-receive")
    public String homeorderreceive(){
        return "home-order-receive.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-order-send")
    public String homeordersend(){
        return "home-order-send.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-orderDetail")
    public String homeorderDetail(){
        return "home-orderDetail.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-person-collect")
    public String homepersoncollect(){
        return "home-person-collect.html";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/home-order-evaluate")
    public String homeorderevaluate(){
        return "home-order-evaluate.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-setting-address")
    public String homesettingaddress(){
        return "home-setting-address.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-setting-address-complete")
    public String homesettingaddresscomplete(){
        return "home-setting-address-complete.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-setting-address-phone")
    public String homesettingaddressphone(){
        return "home-setting-address-phone.html";
    }

    /**
     *
     * @return
     */
    @RequestMapping("/home-setting-info")
    public String homesettinginfo(){
        return "home-setting-info.html";
    }
    /**
     *
     * @return
     */
    @RequestMapping("/home-setting-safe")
    public String homesettingsafe(){
        return "home-setting-safe.html";
    }

    @RequestMapping("/seckill-index")
    public String seckillindex(){
        return "seckill-index.html";
    }


    @RequestMapping("/home-person-footmark")
    public String homepersonfootmark(){
        return "home-person-footmark.html";
    }

    @RequestMapping("/getOrderInfo")
    public String getOrderInfo(){
        return "getOrderInfo";
    }
}
