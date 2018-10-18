package com.cssl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ShowController {


    /**
     * 首页
     */
    @RequestMapping("/index")
    public String index(){
        return "index.html";
    }


    /**
     * 足迹
     */
    @RequestMapping("/home-person-footmark")
    public String  homepersonfootmark(){
        return "home-person-footmark";
    }

    /**
     * 秒杀页面
     */
    @RequestMapping("/seckill-index")
    public String  seckillindex(){
        return "seckill-index.html";
    }

    /**
     * 手机列表页面
     */
    @RequestMapping("/search")
    public String search(){
        return "search.html";
    }

    /**
     * 欢迎界面
     */
    @RequestMapping("/home")
    public String home(String username, HttpSession session){
        username=(String)session.getAttribute("username");
        if (username==null){
            return "login";
        }
        return "forward:home-index";
    }

    /**
     * 合作招商
     * @return
     */
    @RequestMapping("cooperation")
    public String cooperation(){
        return "cooperation";
    }

    /**
     * 商家入驻
     * @return
     */
    @RequestMapping("sampling")
    public String sampling(){
        return "sampling";
    }

}
