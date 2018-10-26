package com.cssl.service.impl;

import com.cssl.dao.ShoppingDao;
import com.cssl.enums.ShoppingEnum;
import com.cssl.excepion.pinyouExcepion;
import com.cssl.pojo.Shopping;
import com.cssl.service.ShoppingService;
import com.cssl.vo.ShoppingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    ShoppingDao shoppingDao;

    @Override
    public List<ShoppingVo> shoppingList(String userName) {
        List<ShoppingVo> list = new ArrayList<>();
        if (null != userName && !"".equals(userName)) {
            List<String> sellerList = shoppingDao.selectSeller(userName);

            if (sellerList.size() > 0) {
                for (int i = 0; i < sellerList.size(); i++) {
                    List<Shopping> shoppings = shoppingDao.shoppingList(userName, sellerList.get(i));
                    ShoppingVo shoppingVo = new ShoppingVo();
                    shoppingVo.setSellertitle(shoppings.get(i).getSellertitle());
                    shoppingVo.setShoppingList(shoppings);
                    list.add(shoppingVo);
                }

            } else {
                throw new pinyouExcepion(ShoppingEnum.CART_EMPTY);
            }
        } else {
            throw new pinyouExcepion(ShoppingEnum.IDISNULL);
        }

        return list;
    }

    @Override
    public int trueClick(List<Integer> shoppingIds) {
        return shoppingDao.trueClick(shoppingIds);
    }

    @Override
    public int falseClick(List<Integer> shoppingIds) {
        return shoppingDao.falseClick(shoppingIds);
    }

    @Override
    public Double shoppingAmount(String userName) {
        Double amount = 0.00;
        if (amount == null || amount == 0.0) {
            amount = shoppingDao.shoppingAmount(userName);
        }
        return amount;
    }

    @Override
    public int updateQuantity(Integer quantity, Integer shoppingId) {

        if (shoppingId != 0 && !shoppingId.equals(null)) {
            if (quantity > 0 && !quantity.equals(null)) {
                Integer mun = shoppingDao.queryItemMum(shoppingId);
                if (mun > quantity) {
                    shoppingDao.updateQuantity(quantity, shoppingId);

                } else {

                    return ShoppingEnum.UNDERSTOCK.getCode();
                }
            } else {
                return ShoppingEnum.QUANABNORMAL.getCode();
            }

        }

        return ShoppingEnum.TURIRU.getCode();
    }

    @Override
    public Double priceQuantCount(Integer shoppingId) {

        return shoppingDao.priceQuantCount(shoppingId);
    }

    @Override
    public Integer clickCount(String userName) {
        return shoppingDao.clickCount(userName);
    }


    @Override
    public int jiaQuantity(Integer quantity, Integer shoppingId) {
        int itemMum=shoppingDao.queryItemMum(shoppingId);
        if(itemMum<1){
            if(quantity<=itemMum){
                shoppingDao.updateQuantity(quantity,shoppingId);
            }else {
                return ShoppingEnum.UNDERSTOCK.getCode();
            }
        }else {
            return ShoppingEnum.UNDERSTOCK.getCode();
        }
    return ShoppingEnum.TURIRU.getCode();
    }

    @Override
    public int jianQuantity(Integer quantity, Integer shoppingId) {
        if(quantity>0&&quantity!=null){
            shoppingDao.updateQuantity(quantity,shoppingId);
        }else {
            return ShoppingEnum.QUANABNORMAL.getCode();
        }
        return ShoppingEnum.TURIRU.getCode();
    }

    /**
     * 根据登陆名查询购物车
     */
    @Override
    public List<Map<String, Object>> selectshop(Map map) {
        return shoppingDao.selectshop(map);
    }

}