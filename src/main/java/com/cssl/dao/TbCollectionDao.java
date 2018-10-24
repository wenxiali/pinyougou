package com.cssl.dao;

import com.cssl.SuperMapper;
import com.cssl.pojo.TbCollection;

import java.util.List;
import java.util.Map;

public interface TbCollectionDao extends SuperMapper<TbCollection> {

    List<Map<String,Object>> selectCollection(Map map);

}
