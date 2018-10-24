package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.pojo.TbCollection;

import java.util.List;
import java.util.Map;

public interface TbCollectionService extends IService<TbCollection> {
    List<Map<String,Object>> selectCollection(Map map);
}
