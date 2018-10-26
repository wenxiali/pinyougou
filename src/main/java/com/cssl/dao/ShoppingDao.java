package com.cssl.dao;

import com.cssl.pojo.Shopping;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ShoppingDao {
    /**
     * 查询购物车
     */
    List<Shopping> shoppingList(@Param("userName") String userName, @Param("sellerId") String sellerId);

    /**
     * 添加购物车
     */
    int insertShopping(Map<String, Object> map);


    /**
     * 修改商品数量
     */
     int updateQuantity(@Param("quantity") Integer quantity, @Param("shoppingId") Integer shoppingId);


    /**
     * 删除单个商品
     */
    int deleteshItem(int shoppingId);

    /**
     * 查询总价
     */
    Double shoppingAmount(@Param("userName") String userName);

    /**
     * 清空以购买的商品
     */
     int deleteShoopingItem(List<Integer> shoppingId);

    /**
     * 查询商店信息
     */
    List<String> selectSeller(String userName);

    /**
     * 批量
     */
    int trueClick(@Param("shoppingIds") List<Integer> shoppingIds);

    /**
     *
     */
    int falseClick(@Param("shoppingIds") List<Integer> shoppingIds);

    /**
     * 查询库存
     */
    Integer queryItemMum(Integer shoppingId);

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
