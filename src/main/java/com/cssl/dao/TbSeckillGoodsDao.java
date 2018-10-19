package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbSeckillGoods;

import java.util.List;
import java.util.Map;

public interface TbSeckillGoodsDao extends SuperMapper<TbSeckillGoods> {

    /**
     * 查询所有
     */
    public List<Map<String,Object>> selectsy(Map map);

    /**
     * 根据id查询一条数据
     */
    public List<Map<String,Object>> selectid(Map map);
}
