package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbItemDao;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbItemImg;
import com.cssl.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({TbItemDao.class})
public class TbItemServiceImpl extends ServiceImpl<TbItemDao, TbItem> implements TbItemService {

    @Autowired
    private TbItemDao dao;

    /**
     * 家用电器最热
     */
    @Override
    public List<Map<String, Object>> selectHottest(Map map) {
        return dao.selectHottest(map);
    }

    /**
     * 家用电器轮播
     */
    @Override
    public List<Map<String, Object>> selectHotshow(Map map) {
        return dao.selectHotshow(map);
    }

    /**
     * 根据标题查询（家用电器，手机通讯）
     */
    @Override
    public List<Map<String, Object>> selecttitle(Map map) {
        return dao.selecttitle(map);
    }

    /**
     * 热卖单品
     * @return
     */
    @Override
    public List<Map<String, Object>> selectSelling() {
        return dao.selectSelling();
    }

    @Override
    public int insertItemImg(List<TbItemImg> tbItemImgs) {
        int count=0;
        if(tbItemImgs.size()>0){
            count=dao.insertItemImg(tbItemImgs);
        }
        return count;
    }

    @Override
    public int updateItme(Map<String, Object> map) {
        return dao.updateItme(map);
    }

    /**
     * 手机通讯最热
     */
    @Override
    public List<Map<String, Object>> selectMod(Map map) {
        return dao.selectMod(map);
    }

    /**
     * 手机通讯轮播
     */
    @Override
    public List<Map<String, Object>> selectModshow(Map map) {
        return dao.selectModshow(map);
    }

    /**
     * 查询商家卖的商品品牌
     */
    @Override
    public List<Map<String, Object>> selectBrand(Map map) {
        return dao.selectBrand(map);
    }
}
