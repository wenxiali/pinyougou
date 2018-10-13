package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbContent;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbItemCat;
import com.cssl.service.TbContentService;
import com.cssl.service.TbItemCatService;
import com.cssl.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class TbItemCatController {
    //目录表
    @Autowired
    private TbItemCatService service;

    //广告表
    @Autowired
    private TbContentService servicec;

    //商品详情表
    @Autowired
    private TbItemService servicei;

    /**
     * 首页
     */
    @RequestMapping("/indexx")
    public String indexx( HttpSession session,Model model,Map<String,Object> map,Integer id){
        System.err.println("进入"+id);
        //查询一级目录
        IPage<TbItemCat> list= service.selectPage(new Page(1,15),new QueryWrapper<TbItemCat>().eq("parent_Id",0));
        model.addAttribute("list",list.getRecords());
        //查询轮播广告
        List<TbContent> listc=servicec.selectList(new QueryWrapper<TbContent>());
        model.addAttribute("listc",listc);
        //猜你喜欢
        if(id==null){
            IPage<TbItem> listi=servicei.selectPage(new Page(1,6),new QueryWrapper<TbItem>());
            model.addAttribute("listi",listi.getRecords());
        }else {
            IPage<TbItem> listi =null;

            listi= servicei.selectPage(new Page(1, 6), new QueryWrapper<TbItem>().eq("categoryId", id));
            if(listi.getTotal()!=0){
                model.addAttribute("listi",listi.getRecords());
            }else{
                listi=servicei.selectPage(new Page(1,6),new QueryWrapper<TbItem>());
                model.addAttribute("listi",listi.getRecords());
            }
        }
        //家用电器区appliances
          //标题
        List<TbItemCat> listals=service.selectList(new QueryWrapper<TbItemCat>().eq("parent_Id",74));
        model.addAttribute("listals",listals);
          //最热
        List<Map<String,Object>> listhoot=servicei.selectHottest(map);
        model.addAttribute("listhoot",listhoot);
          //轮播
        List<Map<String,Object>> listshow=servicei.selectHotshow(map);
        model.addAttribute("listshow",listshow);

        //手机通讯 mobile
          //标题
        List<TbItemCat> listmob=service.selectList(new QueryWrapper<TbItemCat>().eq("parent_Id",558));
        model.addAttribute("listmob",listmob);
         //最热
        List<Map<String,Object>> listmhod=servicei.selectMod(map);
        model.addAttribute("listmhod",listmhod);
         //轮播
        List<Map<String,Object>> listmobshow=servicei.selectMod(map);
        model.addAttribute("listmobshow",listmobshow);

        return "forward:index";
    }

    /**
     * 查询二级目录ajax
     */
    @ResponseBody
    @RequestMapping("/ajindex")
    public List<TbItemCat> ajindex(int id,Model model){
        List<TbItemCat> listm=service.selectList(new QueryWrapper<TbItemCat>().eq("parent_Id",id));
        List<TbItemCat> list=service.selectSecond(id);
        return list;
    }

    /**
     * 猜你喜欢换一换
     */
    @ResponseBody
    @RequestMapping("/change")
    public List<TbItem> change(Integer pa){
        IPage<TbItem> listi=servicei.selectPage(new Page<TbItem>(pa,6),new QueryWrapper<TbItem>());
        List<TbItem> listt=listi.getRecords();
        return  listt;
    }

    /**
     * 根据标题id查询（家用电器，手机通讯通用）
     */
    @ResponseBody
    @RequestMapping("/ajextitle")
    public List<Map<String,Object>> ajextitle(int id,Model model,Map<String, Object> map){
        if(id!=0){
            map.put("id",id);
        }
        List<Map<String,Object>> listtit=servicei.selecttitle(map);
        return listtit;
    }
}
