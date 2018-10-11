package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbOrder;
import com.cssl.pojo.TbOrderItem;
import com.cssl.service.OrderItemService;
import com.cssl.service.OrderService;
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
    @Autowired
    private OrderService oService;
    @Autowired
    private OrderItemService oiService;

    /**
     * 我的订单
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
    /**
     * 首页删除
     * @return
     */
    @RequestMapping("/delete-index")
    public String delete(String orderId){
        boolean a=oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id",orderId));
        if (a){
            boolean b=oService.delete(new QueryWrapper<TbOrder>().eq("order_id",orderId));
            return "forward:home-index";
        }
        return "forward:home-index";
    }

    /**
     * 待付款
     * @param pa
     * @param status
     * @param nick_Name
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/home-order-pay")
    public String homeorderpay(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> pay = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("pay",pay);
        return "home-order-pay";
    }

    /**
     * 代付款删除
     * @return
     */
    @RequestMapping("/delete-pay")
    public String deletepay(String orderId){
        boolean a=oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id",orderId));
        if (a){
            boolean b=oService.delete(new QueryWrapper<TbOrder>().eq("order_id",orderId));
            return "forward:home-order-pay";
        }
        return "forward:home-order-pay";
    }

    /**
     * 待发货
     * @param pa
     * @param status
     * @param nick_Name
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/home-order-send")
    public String homeordersend(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> send = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("send",send);
        return "home-order-send";
    }

    /**
     * 代发货删除
     * @return
     */
    @RequestMapping("/delete-send")
    public String deletesend(String orderId){
        boolean a=oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id",orderId));
        if (a){
            boolean b=oService.delete(new QueryWrapper<TbOrder>().eq("order_id",orderId));
            return "forward:home-order-send";
        }
        return "forward:home-order-send";
    }

    /**
     * 待收货
     * @param pa
     * @param status
     * @param nick_Name
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/home-order-receive")
    public String homeorderreceive(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> receive = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("receive",receive);
        return "home-order-receive";
    }

    /**
     * 代收货删除
     * @return
     */
    @RequestMapping("/delete-receive")
    public String deletereceive(String orderId){
        boolean a=oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id",orderId));
        if (a){
            boolean b=oService.delete(new QueryWrapper<TbOrder>().eq("order_id",orderId));
            return "forward:home-order-receive";
        }
        return "forward:home-order-receive";
    }

    /**
     * 待评价
     * @param pa
     * @param status
     * @param nick_Name
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/home-order-evaluate")
    public String homeorderevaluate(Integer pa, Integer status,String nick_Name,Model model,HttpSession session){

        if (pa==null ||pa==0){
            pa = 1;
        }
        String username=(String)session.getAttribute("username");
        IPage<Map<String,Object>> evaluate = service.selectList(new Page(pa,2),username,status,nick_Name);
        model.addAttribute("evaluate",evaluate);
        return "home-order-evaluate";
    }

    /**
     * 代收货删除
     * @return
     */
    @RequestMapping("/delete-evaluate")
    public String deleteevaluate(String orderId){
        boolean a=oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id",orderId));
        if (a){
            boolean b=oService.delete(new QueryWrapper<TbOrder>().eq("order_id",orderId));
            return "forward:home-order-evaluate";
        }
        return "forward:home-order-evaluate";
    }

    /**
     * 订单详情
     */
    @RequestMapping("/home-orderDetail")
    public String homeorderDetail(HttpSession session,Model model){
        /*String username=(String)session.getAttribute("username");
        model.addAttribute("username",username);*/
        return "home-orderDetail";
    }


}
