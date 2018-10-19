package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbItemImg;

import java.util.List;
import java.util.Map;

public interface TbItemService extends IService<TbItem> {

    /**
     * 家用电器最热
     */
    public List<Map<String,Object>> selectHottest(Map map);

    /**
     * 家用电器轮播
     */
    public List<Map<String,Object>> selectHotshow(Map map);

    /**
     * 手机通讯最热
     */
    public List<Map<String,Object>> selectMod(Map map);

    /**
     * 手机通讯轮播
     */
    public List<Map<String,Object>> selectModshow(Map map);

    /**
     * 根据标题查询（家用电器，手机通讯）
     */
    public List<Map<String,Object>> selecttitle(Map map);

    /**
     * 热卖单品
     * @return
     */
    public List<Map<String,Object>> selectSelling();

    int insertItemImg(List<TbItemImg> tbItemImgs);

    int updateItme(Map<String,Object>map);


    /**
     * 查询商家卖的商品品牌
     */
    public List<Map<String,Object>> selectBrand(Map map);
}
