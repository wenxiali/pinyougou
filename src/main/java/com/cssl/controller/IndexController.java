package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.dto.UserDto;
import com.cssl.pojo.TbOrder;
import com.cssl.pojo.TbOrderItem;
import com.cssl.pojo.TbUser;
import com.cssl.service.OrderItemService;
import com.cssl.service.OrderService;
import com.cssl.service.UserService;
import com.cssl.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
        IPage<Map<String,Object>> list = oService.selectList(new Page(pa,4),username,status,nick_Name);
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
        IPage<Map<String,Object>> pay = oService.selectList(new Page(pa,2),username,status,nick_Name);
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
        IPage<Map<String,Object>> send = oService.selectList(new Page(pa,2),username,status,nick_Name);
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
        IPage<Map<String,Object>> receive = oService.selectList(new Page(pa,2),username,status,nick_Name);
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
        IPage<Map<String,Object>> evaluate = oService.selectList(new Page(pa,2),username,status,nick_Name);
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
     * 完善信息
     * @param request
     * @return
     */
    @RequestMapping(value = "/geteuser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> geteuser(HttpServletRequest request){
        String username=(String)request.getSession().getAttribute("username");
        Map<String,Object> modlMap=new HashMap<>();
        TbUser user =service.getUser(username);
        if(user!=null){
            UserDto userDto=new UserDto();
            userDto.setNick_Name(user.getNick_name());
            userDto.setEmail(user.getEmail());
            userDto.setHead_pic(user.getHead_Pic());
            userDto.setTime(user.getLast_Login_Time());
            userDto.setSex(user.getSex());
            userDto.setProvinceid(user.getProvince_Id());
            userDto.setCityid(user.getCity_Id());
            userDto.setAreaid(user.getTown_Id());
            userDto.setJob(user.getJob());
            modlMap.put("getUser",userDto);
        }

        return modlMap;
    }

    /**
     * 完善信息方法,@RequestParam("fileImg") MultipartFile fileImg
     */
    @RequestMapping(value = "/updateuserty",method = RequestMethod.POST)
    @ResponseBody
    public int updateUserty(MultipartFile fileImg,
                            @RequestParam("strs") String strs,
                            HttpServletRequest request,HttpSession session){
        String username=(String)request.getSession().getAttribute("username");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        UserDto userdato=null;
        try {
            userdato= mapper.readValue(strs,UserDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TbUser user=new TbUser();
        user.setNick_name(userdato.getNick_Name());
        user.setEmail(userdato.getEmail());
        user.setSex(userdato.getSex());
        user.setProvince_Id(userdato.getProvinceid());
        user.setCity_Id(userdato.getCityid());
        user.setTown_Id(userdato.getAreaid());
        user.setJob(userdato.getJob());

        user.setLast_Login_Time(userdato.getTime());
        try{
            if(null!=fileImg.getOriginalFilename()&&!"".equals(fileImg.getOriginalFilename())){

                String fileType="img/head_Pic/";
                String filePath = request.getSession().getServletContext().getRealPath(fileType);
                //清空对应文件头像
                FileUtil.deleteFileOrpath(filePath);
                user.setHead_Pic(FileUtil.addimags(fileImg,fileType,request));
                session.setAttribute("head_Pic",FileUtil.addimags(fileImg,fileType,request));
            }else {
                user.setHead_Pic(null);
            }
        }catch (Exception e){
            user.setHead_Pic(null);
        }

        user.setUsername(username);
        int counr=0;
        if(username!=null &&username!=""){
            counr=service.updateUser(user);
        }

        return counr;
    }

    /**
     * 订单详情
     */
    @RequestMapping("/home-orderDetail")
    public String homeorderDetail(Long orderId,Model model){
        List<Map<String,Object>> list= oService.selectOrder(orderId);
        model.addAttribute("order",list);
        return "home-orderDetail";
    }

}
