package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbBrand;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbSpecification;
import com.cssl.pojo.TbSpecificationOption;
import com.cssl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SeardsController {
    //小类别表（电视屏幕）
    @Autowired
    private TbSpecificationService service;

    //类别详情
    @Autowired
    private TbSpecificationOptionService serviceop;

    //商品详情表
    @Autowired
    private TbItemService servicei;

    //品牌表
    @Autowired
    private TbBrandService serviceb;

    //收藏表
    @Autowired
    private TbCollectionService servicec;

    /**
     * 手机列表
     */
    @RequestMapping("/seards")
    public String searchh(Model model, Map<String,Object> map, HttpSession session, Integer pa, String spec, String specc, String sell_point, String brand,Integer px, String name, HttpServletRequest request, HttpServletResponse response){
        //TbSpecificationOption  TbSpecification
        //spec :网络    specc:内存  sell_point:屏幕 brand:品牌 price:价格1 pricee 价格2  pa:页码 px:排序方式 1：销量，2.新品，3.评价，4.价格  name:收索框
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String price=request.getParameter("price");
        String pricee=request.getParameter("pricee");
        System.out.println(price+pricee);
        //品牌
        List<TbBrand> listtele=serviceb.listtele();
        model.addAttribute("listtele",listtele);

        //电视屏幕尺寸
        TbSpecification sizet=service.selectOne(new QueryWrapper<TbSpecification>().eq("id",33));
        model.addAttribute("sizet",sizet);
        List<TbSpecificationOption> listsizt=serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id",33));
        model.addAttribute("listsizt",listsizt);


        //商品详情
        if(pa==null){
            pa=1;
        }
        IPage<TbItem> listmobt=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",76));
        model.addAttribute("listmobt",listmobt);
        //按品牌
        session.setAttribute("brandse",brand);
        //按屏幕
        session.setAttribute("sell_point",sell_point);
        //按价格
        session.setAttribute("price",price);//大于
        session.setAttribute("pricee",pricee);//小于

        //排序方式
        session.setAttribute("px",px);

        if(name!=null){
            listmobt = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().like("title", name).or().like("spec", name).or().like("brand", name));
            model.addAttribute("listmobt", listmobt);
        }

        if(spec!=null || sell_point!=null || brand!=null || px!=null){
            listmobt = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 76).like("spec", spec).like("sell_point", sell_point).like("brand", brand));
            // listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand).gt("price", price).lt("price", pricee));
            model.addAttribute("listmobt", listmobt);
        }
        if(px!=null){
            if(px==2){
                listmobt = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 76).like("spec",spec).like("spec", specc).like("brand", brand).orderByDesc("create_time"));
                model.addAttribute("listmobt", listmobt);
            }else if(px==4){
                listmobt = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 76).like("spec",spec).like("spec", specc).like("brand", brand).orderByDesc("price"));
                model.addAttribute("listmobt", listmobt);
            }
        }
        //价格有冲突所以分开
        if(price!=null || pricee!=null){
            listmobt=servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 76).like("spec", spec).like("spec",specc).like("brand",brand).gt("price", price).lt("price", pricee));
            model.addAttribute("listmobt",listmobt);
        }
        if(sell_point!=null){
            listmobt=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",76).like("sell_point",sell_point));
            model.addAttribute("listmobt",listmobt);
        }
        //System.out.println(listmob.getCurrent());//当前页码
        //System.out.println(listmob.getPages());//总页码
        //页面1.2.3.4.5.6.。。
        int i=0;
        List<Integer> iit=new ArrayList();
        for(i=1;i<=listmobt.getPages();i++){
            iit.add(i);
        }
        model.addAttribute("iit",iit);
        /*for(Integer a:ii){
            System.out.println(a);
        }*/

        return  "seards.html";
    }

}
