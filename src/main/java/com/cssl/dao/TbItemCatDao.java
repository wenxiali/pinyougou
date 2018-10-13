package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCatDao extends SuperMapper<TbItemCat> {

    /**
     * 查询三级目录
     */
    public List<TbItemCat> selectSecond(@Param("id") int id);

}
