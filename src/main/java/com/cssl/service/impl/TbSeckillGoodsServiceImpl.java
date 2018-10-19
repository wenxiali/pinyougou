package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbBrandDao;
import com.cssl.dao.TbSeckillGoodsDao;
import com.cssl.pojo.TbSeckillGoods;
import com.cssl.service.TbSeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({TbSeckillGoodsDao.class})
public class TbSeckillGoodsServiceImpl extends ServiceImpl<TbSeckillGoodsDao, TbSeckillGoods> implements TbSeckillGoodsService {

    @Autowired
    private TbSeckillGoodsDao dao;

    /**
     * 查询所有
     * @param map
     * @return
     */
    @Override
    public List<Map<String, Object>> selectsy(Map map) {
        return dao.selectsy(map);
    }

    /**
     * 根据id查询
     * @param
     * @return
     */
    @Override
    public List<Map<String, Object>> selectid(Map map) {
        return dao.selectid(map);
    }
}
