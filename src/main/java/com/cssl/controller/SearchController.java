package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbSpecification;
import com.cssl.pojo.TbSpecificationOption;
import com.cssl.service.TbItemService;
import com.cssl.service.TbSpecificationOptionService;
import com.cssl.service.TbSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    //小类别表（网络，手机屏幕尺寸，机身内存）
    @Autowired
    private TbSpecificationService service;

    //类别详情
    @Autowired
    private TbSpecificationOptionService serviceop;

    //商品详情表
    @Autowired
    private TbItemService servicei;


    /**
     * 手机列表
     */
    @RequestMapping("/searchh")
    public String searchh(Model model,Map<String,Object> map,Integer pa,String spec,String sell_point){
        //TbSpecificationOption  TbSpecification
        //网络
        TbSpecification network=service.selectOne(new QueryWrapper<TbSpecification>().eq("id",27));
        model.addAttribute("network",network);
        List<TbSpecificationOption> listnet=serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id",27));
        model.addAttribute("listnet",listnet);

        //手机屏幕尺寸
        TbSpecification size=service.selectOne(new QueryWrapper<TbSpecification>().eq("id",28));
        model.addAttribute("size",size);
        List<TbSpecificationOption> listsiz=serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id",28));
        model.addAttribute("listsiz",listsiz);

        //机身内存Memory
        TbSpecification memory=service.selectOne(new QueryWrapper<TbSpecification>().eq("id",32));
        model.addAttribute("memory",memory);
        List<TbSpecificationOption> listmem=serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id",32));
        model.addAttribute("listmem",listmem);

        //商品详情
        if(pa==null){
            pa=1;
        }
        IPage<TbItem> listmob=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",560));
        model.addAttribute("listmob",listmob);
        if(spec!=null){
            listmob=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",560).like("spec",spec));
            model.addAttribute("listmob",listmob);
        }
        if(sell_point!=null){
            listmob=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",560).like("sell_point",sell_point));
            model.addAttribute("listmob",listmob);
        }
        //System.out.println(listmob.getCurrent());//当前页码
        //System.out.println(listmob.getPages());//总页码
        int i=0;
        List<Integer> ii=new ArrayList();
        for(i=1;i<=listmob.getPages();i++){
            ii.add(i);
        }
        model.addAttribute("ii",ii);
        /*for(Integer a:ii){
            System.out.println(a);
        }*/

        return  "forward:search";
    }

}
