package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.SuperMapper;
import com.cssl.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbItemCatService extends IService<TbItemCat> {

    /**
     * 查询三级目录
     */
    public List<TbItemCat> selectSecond(@Param("id") int id);
}
