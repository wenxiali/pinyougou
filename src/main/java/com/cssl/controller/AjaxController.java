package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.pojo.TbAddress;
import com.cssl.pojo.TbCollection;
import com.cssl.pojo.TbOrder;
import com.cssl.pojo.TbOrderItem;
import com.cssl.service.AddressService;
import com.cssl.service.OrderItemService;
import com.cssl.service.OrderService;
import com.cssl.service.TbCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AjaxController {
    @Autowired
    private AddressService aService;

    @Autowired
    private OrderItemService oiService;

    @Autowired
    private OrderService oService;

    @Autowired
    private TbCollectionService cService;

    /**
     * 删除地址
     *
     * @param aId
     * @return
     */
    @RequestMapping("/delAddress.action")
    public int de(Integer aId) {
        int row = aService.deleteAdd(aId);
        return row;
    }

    /**
     * 选中删除
     *
     * @param orderId
     * @return
     */
    @RequestMapping("/delete")
    public boolean deleteevaluate(String orderId) {
        boolean a = oiService.delete(new QueryWrapper<TbOrderItem>().eq("order_id", orderId));
        // System.out.println(a);
        boolean b = false;
        if (a) {
            b = oService.delete(new QueryWrapper<TbOrder>().eq("order_id", orderId));
            //System.out.println(b);
        }
        return b;
    }

    /**
     * 退款
     */
    @RequestMapping("/home-tuikuan")
    public int tuikuan(TbOrder order) {
        int row = oService.updateTui(order);
        return row;
    }

    /**
     * 修改默认地址
     *
     * @param address
     * @return
     */
    @RequestMapping("/home-moren")
    public int moren(TbAddress address, String username,Long aid, HttpServletRequest request) {
        username=(String)request.getSession().getAttribute("username");
        address.setUsername(username);
        int a=aService.updateUs(address);
        int b=0;
        if (a>0){
            address.setAid(aid);
            b=aService.updateIs(address);
        }
        return b;
    }

    /**
     * 删除收藏
     * @param id
     * @return
     */
    @RequestMapping("home-conllection")
    public boolean homeconllectdel(int id){
        boolean row=cService.delete(new QueryWrapper<TbCollection>().eq("id", id));
        return row;
    }
}
