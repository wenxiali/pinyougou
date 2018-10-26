package com.cssl.controller;

import com.cssl.dao.ShoppingDao;
import com.cssl.enums.ShoppingEnum;
import com.cssl.pojo.Shopping;
import com.cssl.service.ShoppingService;
import com.cssl.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingController {
    @Autowired
    ShoppingService shoppingService;
    @Autowired
    ShoppingDao shoppingDao;

    @RequestMapping(value = "/shoppingList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> shoppinglist(HttpServletRequest request) {
        Map<String, Object> mobelMap = new HashMap<>();
        //String userName=(String)request.getSession().getAttribute("userName");
        List<ShoppingVo> shoppingVoList = shoppingService.shoppingList("123");
        mobelMap.put("shoppingCart", shoppingVoList);
        return mobelMap;
    }

    @RequestMapping(value = "/trueshoppings", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> trueShoppings(@RequestParam(value = "trueShoppingIds", defaultValue = "") List<Integer> trueShoppingIds,
                                             @RequestParam(value = "falseShoppingIds", defaultValue = "") List<Integer> falseShoppingIds,
                                             HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int cerrt = 0;
        if (trueShoppingIds.size() > 0) {
            for (int i = 0; i < trueShoppingIds.size(); i++) {
                cerrt = shoppingService.trueClick(trueShoppingIds);
            }
        }


        if (falseShoppingIds.size() > 0) {
            for (int i = 0; i < falseShoppingIds.size(); i++) {
                cerrt = shoppingService.falseClick(falseShoppingIds);
            }
        }
        if (cerrt > 0) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/shoppingamount", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> shoppingAmount(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        //String userName=(String)request.getSession().getAttribute("userName");
        modelMap.put("shopinngAmount", shoppingService.shoppingAmount("123"));
        return modelMap;
    }

    @RequestMapping(value = "/jiaquantity", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> jiaquantity(@RequestParam("quantity") Integer quantity, @RequestParam("shoppingId") Integer shoppingId, HttpServletRequest request) {
        System.out.println("==================》" + quantity);
        Map<String, Object> modelMap = new HashMap<>();
        int errcon = shoppingService.updateQuantity((quantity + 1), shoppingId);
        if (errcon == ShoppingEnum.UNDERSTOCK.getCode()) {
            modelMap.put("seccuss", false);
            modelMap.put("errMsg", ShoppingEnum.UNDERSTOCK.getMessge());
        } else {
            modelMap.put("seccuss", true);
        }
        return modelMap;
    }

    @RequestMapping(value = "/jianquantity", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> jianquantity(@RequestParam("quantity") Integer quantity, @RequestParam("shoppingId") Integer shoppingId, HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        int errcon = shoppingService.updateQuantity((quantity - 1), shoppingId);
        if (errcon == ShoppingEnum.QUANABNORMAL.getCode()) {
            modelMap.put("seccuss", false);
            modelMap.put("errMsg", ShoppingEnum.QUANABNORMAL.getMessge());
        } else {
            modelMap.put("seccuss", true);
        }
        return modelMap;
    }

    @RequestMapping(value = "/pricequantCount", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> priceQuantCount(@RequestParam("shoppingId") Integer shoppingId) {
        Map<String, Object> modelMap = new HashMap<>();
        Double aumt = shoppingService.priceQuantCount(shoppingId);

        if (aumt != null && aumt != 0) {
            modelMap.put("success", true);
            modelMap.put("aumqat", aumt);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }

    /**
     * 查询已选商品有几件
     */
    @RequestMapping(value = "/clickcount", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> clickCount(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<>();
        //String userName=(String)request.getSession().getAttribute("userName");
        Integer cout = shoppingService.clickCount("123");
        if (cout != null && cout != 0) {
            modelMap.put("success", true);
            modelMap.put("count", cout);
        } else {
            modelMap.put("success", false);
        }
        return modelMap;
    }


}
