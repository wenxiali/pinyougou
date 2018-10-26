package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.dto.ItemDto;
import com.cssl.pojo.*;
import com.cssl.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Autowired
    private TbItemService iService;

    //品牌表
    @Autowired
    private TbBrandService serviceb;

    //收藏表
    @Autowired
    private TbCollectionService servicec;


    /**
     * 手机列表
     */
    @RequestMapping("/searchh")
    public String searchh(Model model, Map<String, Object> map, HttpSession session, Integer pa, String spec, String specc, String sell_point, String brand, Double price, Double pricee, Integer px) {
        //TbSpecificationOption  TbSpecification
        //spec :网络    specc:内存  sell_point:屏幕 brand:品牌 price:价格1 pricee 价格2  pa:页码 px:排序方式 1：销量，2.新品，3.评价，4.价格
        //品牌
        List<TbBrand> listbra = serviceb.listbrand();
        model.addAttribute("listbra", listbra);

        //网络
        TbSpecification network = service.selectOne(new QueryWrapper<TbSpecification>().eq("id", 27));
        model.addAttribute("network", network);
        List<TbSpecificationOption> listnet = serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id", 27));
        model.addAttribute("listnet", listnet);

        //手机屏幕尺寸
        TbSpecification size = service.selectOne(new QueryWrapper<TbSpecification>().eq("id", 28));
        model.addAttribute("size", size);
        List<TbSpecificationOption> listsiz = serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id", 28));
        model.addAttribute("listsiz", listsiz);

        //机身内存Memory
        TbSpecification memory = service.selectOne(new QueryWrapper<TbSpecification>().eq("id", 32));
        model.addAttribute("memory", memory);
        List<TbSpecificationOption> listmem = serviceop.selectList(new QueryWrapper<TbSpecificationOption>().eq("spec_Id", 32));
        model.addAttribute("listmem", listmem);

        //热卖
        List<Map<String, Object>> selling = iService.selectSelling();
        model.addAttribute("selling", selling);

        //商品详情
        if (pa == null) {
            pa = 1;
        }
        IPage<TbItem> listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560));
        model.addAttribute("listmob", listmob);
        //按品牌
        session.setAttribute("brandse", brand);
        //按网络
        session.setAttribute("specse", spec);
        //按内存
        session.setAttribute("speccse", specc);
        //按价格
        session.setAttribute("price", price);//大于
        session.setAttribute("pricee", pricee);//小于
        //排序方式
        session.setAttribute("px", px);

        if (spec != null || specc != null || brand != null || px != null) {
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand));
            // listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand).gt("price", price).lt("price", pricee));
            model.addAttribute("listmob", listmob);
        }
        if (px != null) {
            if (px == 2) {
                listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand).orderByDesc("create_time"));
                model.addAttribute("listmob", listmob);
            } else if (px == 4) {
                listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand).orderByDesc("price"));
                model.addAttribute("listmob", listmob);
            }
        }
        //价格有冲突所以分开
        if (price != null || pricee != null) {
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec", specc).like("brand", brand).gt("price", price).lt("price", pricee));
            model.addAttribute("listmob", listmob);
        }
        if (sell_point != null) {
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("sell_point", sell_point));
            model.addAttribute("listmob", listmob);
        }

        int i = 0;
        List<Integer> ii = new ArrayList();
        for (i = 1; i <= listmob.getPages(); i++) {
            ii.add(i);
        }
        model.addAttribute("ii", ii);
        /*for(Integer a:ii){
            System.out.println(a);
        }*/

        return "forward:search";
    }

    /**
     * 手机列表复(有用)
     */
    @RequestMapping("/searchcs")
    public String searchcs(Model model, Map<String,Object> map,HttpSession session,Integer pa, String spec, String specc, String sell_point,String brand,Double price,Double pricee,Integer px,String name){
        //TbSpecificationOption  TbSpecification
        //spec :网络    specc:内存  sell_point:屏幕 brand:品牌 price:价格1 pricee 价格2  pa:页码 px:排序方式 1：销量，2.新品，3.评价，4.价格  name:收索框
        //品牌
        List<TbBrand> listbra=serviceb.listbrand();
        model.addAttribute("listbra",listbra);

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
        //按品牌
        session.setAttribute("brandse",brand);
        //按网络
        session.setAttribute("specse",spec);
        //按内存
        session.setAttribute("speccse",specc);
        //按价格
        session.setAttribute("price",price);//大于
        session.setAttribute("pricee",pricee);//小于
        //排序方式
        session.setAttribute("px",px);

        if(name!=null){
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().like("title", name).or().like("spec", name).or().like("brand", name));
            model.addAttribute("listmob", listmob);
        }
        if(spec!=null){
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec));
            model.addAttribute("listmob", listmob);
        }
        if(specc!=null){
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("specc", specc));
            model.addAttribute("listmob", listmob);
        }
        if(brand!=null){
            listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("brand", brand));
            model.addAttribute("listmob", listmob);
        }

        if(px!=null){
            if(px==2){
                listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec",spec).like("spec", specc).like("brand", brand).orderByDesc("create_time"));
                model.addAttribute("listmob", listmob);
            }else if(px==4){
                listmob = servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec",spec).like("spec", specc).like("brand", brand).orderByDesc("price"));
                model.addAttribute("listmob", listmob);
            }
        }
        //价格有冲突所以分开
        if(price!=null || pricee!=null){
            listmob=servicei.selectPage(new Page(pa, 10), new QueryWrapper<TbItem>().eq("categoryId", 560).like("spec", spec).like("spec",specc).like("brand",brand).gt("price", price).lt("price", pricee));
            model.addAttribute("listmob",listmob);
        }
        if(sell_point!=null){
            listmob=servicei.selectPage(new Page(pa,10),new QueryWrapper<TbItem>().eq("categoryId",560).like("sell_point",sell_point));
            model.addAttribute("listmob",listmob);
        }
        //System.out.println(listmob.getCurrent());//当前页码
        //System.out.println(listmob.getPages());//总页码
        //页面1.2.3.4.5.6.。。
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



    /**
     * 添加我的收藏
     */
    @ResponseBody
    @RequestMapping("/ajexinsert")
    public int ajiexinte(TbCollection tbc, long iid, HttpServletRequest request) {
        TbItem tbi = servicei.selectOne(new QueryWrapper<TbItem>().eq("id", iid));
        String cimage = tbi.getImage();
        String ctitle = tbi.getTitle();
        Double cprice = tbi.getPrice();

        Integer uid = (Integer) request.getSession().getAttribute("id");
        if (uid == null) {
            return 0;
        }
        tbc.setIid(iid);
        tbc.setUid(uid);
        tbc.setCimage(cimage);
        tbc.setCtitle(ctitle);
        tbc.setCprice(cprice);
        boolean i = servicec.insert(tbc);
        return 1;
    }

    /**
     * 查询我的收藏
     */
    @ResponseBody
    @RequestMapping("/ajexselect")
    public List<TbCollection> ajexselect(Integer uid, HttpSession session) {
        uid = (Integer) session.getAttribute("id");
        List<TbCollection> listcol = servicec.selectList(new QueryWrapper<TbCollection>().eq("uid", uid));
        for (TbCollection a : listcol) {
            System.out.print(a.getCtitle());
        }
        return listcol;
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/ajexdelete")
    public int ajexdelete(TbCollection tbc, long iid, HttpSession session) {
        boolean i = servicec.delete(new QueryWrapper<TbCollection>().eq("iid", iid));
        return 1;
    }

    @RequestMapping(value = "/congetitems", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> congetitems(String itemid) {
        Map<String, Object> modelMap = new HashMap<>();
        ItemDto itemDto = servicei.getItemDto(Integer.valueOf(itemid));
        for (TbItemImg img : itemDto.getTbItemImgs()) {
            System.out.println(img.getImg_type() + "  " + img.getImg_fdw());
        }

        modelMap.put("itemImgs", itemDto.getTbItemImgs());
        return modelMap;
    }

    //购物车页面

    @RequestMapping(value = "/shopcart", method = RequestMethod.GET)
    public String shopcart() {
        return "cart";
    }
}
