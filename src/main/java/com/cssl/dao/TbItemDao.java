package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.dto.ItemDto;
import com.cssl.pojo.TbItem;
import com.cssl.pojo.TbItemImg;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TbItemDao extends SuperMapper<TbItem> {

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
     * 热卖
     * @return
     */
    public List<Map<String,Object>> selectSelling();

    ItemDto getTbItem(Integer itemId);

    int insertItemImg(@Param("temImgs") List<TbItemImg> temImgs);

    int updateItme(Map<String, Object> map);

    /**
     * 查询商家卖的商品品牌
     */
    public List<Map<String,Object>> selectBrand(Map map);
}
