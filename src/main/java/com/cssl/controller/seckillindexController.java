package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbSeckillGoods;
import com.cssl.service.TbItemService;
import com.cssl.service.TbSeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class seckillindexController {

    //秒杀表
    @Autowired
    private TbSeckillGoodsService service;

    //商品详情页面
    @Autowired
    private  TbItemService servicei;

    /**
     * 秒杀页面(查询所有)
     */
    @RequestMapping("/seckill-index")
    public String  seckillindex(Model model, Map map){
        /**
         * 查询所有
         */
        List<Map<String,Object>> list=service.selectsy(map);
        model.addAttribute("list",list);
        return "seckill-index.html";
    }


    /**
     * 根据id（查询商品详情,商品详情seckill-item.html页面）
     */
    @RequestMapping("/selectid")
    public String selectid(Model model,int id,Map map){
        map.put("id",id);
        //详情信息
        List<Map<String,Object>> listid=service.selectid(map);
        model.addAttribute("listid",listid);

        //相关推荐
        IPage<TbItem> listtb=servicei.selectPage(new Page<>(1,5),new QueryWrapper<TbItem>());
        model.addAttribute("listtb",listtb);

        //倒计时

        return "seckill-item.html";
    }

    @RequestMapping("/deleteid")
    public String deleteid(int id){
        boolean i=service.delete(new QueryWrapper<TbSeckillGoods>().eq("id",id));
        return "forward:seckill-index";
    }

    /**
     * 进入商铺（商铺页面shop.html）
     */
    @RequestMapping("/shop")
    public String shop(Model model, String seller_id, Map<String,Object> map, String seller, HttpSession session,String tjname){
        System.out.print(tjname);
        //seller_id:商家名称，seller：品牌名称
        session.setAttribute("seller_id",seller_id);

        IPage<TbItem> listbra=null;

        listbra=servicei.selectPage(new Page(1,8),new QueryWrapper<TbItem>().eq("seller_Id",seller_id));
        model.addAttribute("listbra",listbra);

        //根据时间查询
        IPage<TbItem> listtime=servicei.selectPage(new Page(1,8),new QueryWrapper<TbItem>().eq("seller_Id",seller_id).orderByDesc("create_time"));
        model.addAttribute("listtime",listtime);

        //查询商家卖的商品品牌
        map.put("seller_Id",seller_id);
        List<Map<String,Object>> listbrand = servicei.selectBrand(map);
        model.addAttribute("listbrand",listbrand);

        //按品牌查询
        if(seller!=null){
            listbra=servicei.selectPage(new Page(1,8),new QueryWrapper<TbItem>().eq("seller_Id",seller_id).eq("seller",seller));
            model.addAttribute("listbra",listbra);
        }
        //手动查询
        if(tjname!=null){
            listbra=servicei.selectPage(new Page(1,8),new QueryWrapper<TbItem>().eq("seller_Id",seller_id).or().like("title", tjname).or().like("spec",tjname));
            model.addAttribute("listbra",listbra);
        }

        return "shop.html";
    }

    @RequestMapping("/cs")
    public String cs(){
        return "cs.html";
    }


}
