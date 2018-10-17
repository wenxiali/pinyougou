package com.cssl.controller;

import com.cssl.service.AddressService;
import com.cssl.service.OrderItemService;
import com.cssl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @Autowired
    private AddressService aService;

    @Autowired
    private OrderItemService oiService;

    @Autowired
    private OrderService oService;

    /**
     * 删除地址
     * @param aId
     * @return
     */
    @RequestMapping("/delAddress.action")
    public int de(Integer aId){
        int row=aService.deleteAdd(aId);
        return  row;
    }



}
