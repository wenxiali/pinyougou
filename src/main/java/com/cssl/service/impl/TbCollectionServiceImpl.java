package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbCollectionDao;
import com.cssl.pojo.TbCollection;
import com.cssl.service.TbCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({TbCollectionDao.class})
public class TbCollectionServiceImpl extends ServiceImpl<TbCollectionDao, TbCollection> implements TbCollectionService {

    @Autowired
    private TbCollectionDao dao;

    @Override
    public List<Map<String, Object>> selectCollection(Map map) {
        return dao.selectCollection(map);
    }
}
