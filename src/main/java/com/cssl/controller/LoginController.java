package com.cssl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.dto.RegisUser;
import com.cssl.pojo.TbAddress;
import com.cssl.pojo.TbUser;
import com.cssl.service.AddressService;
import com.cssl.service.TbItemService;
import com.cssl.service.UserService;
import com.cssl.util.Constant;
import com.cssl.util.PhoneRandom;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService service;

    @Autowired
    private AddressService aService;

    @Autowired
    private TbItemService iService;

    /**
     * 注冊
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    /**
     *注册用户
     * @return
     */
    @RequestMapping(path = "/phoneregis")
    @ResponseBody
    public Map<String,Object> pathregister(@RequestParam("strs")String strs, HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        RegisUser regisUser=null;
        try {
            regisUser= mapper.readValue(strs,RegisUser.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String vercation=(String)request.getSession().getAttribute(Constant.VERCATION);

        if(regisUser.getPhoneyzm().equals(vercation)){
            int cont=service.insertUser(regisUser);
            if(cont>0){
                modelMap.put("success",true);
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg","注册失败。");
            }
        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","验证码不一致。");
        }
        modelMap.put("success",true);
        return modelMap;
    }


    /**
     * 获取验证码并发送短信
     */
    @RequestMapping(path = "/pathredx",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> pathredx(String phone,HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
        if(!"".equals(phone)&&null!=phone){

            PhoneRandom.Phonedxe(phone,request);
            modelMap.put("success",true);
            return modelMap;
        }else {

            modelMap.put("success",false);
            modelMap.put("errMsg","手机号码不能为空。");
            return modelMap;
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
            return "forward:home-index";
        }
        return "login";
    }

    /**
     * 基本资料完善
     * @return
     */
    @RequestMapping("/home-setting-info.action")
    private String insertInfo() {

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

    /**
     * 新增地址
     * @param address
     * @param session
     * @return
     */
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
    @RequestMapping("/home-setting-safe.action")
    public String homesettingsafe(){

        return "home-setting-safe";
    }

    /**
     * 商品详情
     * @return
     */
    @RequestMapping("/item")
    public String item(){

        return "item";
    }

    /**
     * 修改密码和手机号
     * @param user
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/modifyPW.action")
    public String modifyPW(TbUser user,Integer id, HttpSession session){
        id=(Integer)session.getAttribute("id");
        boolean row=service.updateById(user);
        if (row){
            return "login";
        }else {
            return "home-setting-safe.action";
        }
    }

    @RequestMapping("/home-setting-safe-phone")
    public String a(){

        return "home-setting-safe-phone";
    }

    @RequestMapping("/home-setting-safe-complete")
    public String b(){

        return "home-setting-safe-complete";
    }

    /**
     * 修改地址
     * @return
     *//*
    @RequestMapping("/modify.action")
    public String update(){
        return "redirect:/home-setting-address.action";
    }*/

}
