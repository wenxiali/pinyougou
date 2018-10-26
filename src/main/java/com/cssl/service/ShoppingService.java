package com.cssl.service;

import com.cssl.vo.ShoppingVo;

import java.util.List;
import java.util.Map;

public interface ShoppingService {
    /**
     * 查询购物车
     */
    List<ShoppingVo> shoppingList(String userName);

    /**
     * 修改为选中
     * @param shoppingIds
     * @return
     */
    int trueClick(List<Integer> shoppingIds);

    /**
     *修改为未选中
     */
    int falseClick(List<Integer> shoppingIds);
    /**
     * 查询已选商品总金额
     */
    Double shoppingAmount(String userName);

    /**
     * 修改个数
     */
    int updateQuantity(Integer quantity, Integer shoppingId);

    /**
     *减库存
     * @param quantity
     * @param shoppingId
     * @return
     */
    int jianQuantity(Integer quantity, Integer shoppingId);

    /**
     * 加库存
     * @param quantity
     * @param shoppingId
     * @return
     */
    int jiaQuantity(Integer quantity, Integer shoppingId);

    /**
     * 查询单个商品总金额
     */
    Double priceQuantCount(Integer shoppingId);

    /**
     * 查询已选商品有几件
     */
    Integer clickCount(String userName);

    /**
     * 根据登陆名查询购物车
     */
    public List<Map<String,Object>> selectshop(Map map);
}
