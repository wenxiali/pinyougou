package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbBrandDao;
import com.cssl.pojo.TbBrand;
import com.cssl.service.TbBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AutoConfigureAfter({TbBrandDao.class})
public class TbBrandServiceImpl extends ServiceImpl<TbBrandDao, TbBrand> implements TbBrandService {

    @Autowired
    private TbBrandDao dao;

    @Override
    public List<TbBrand> listbrand() {
        return dao.listbrand();
    }
}
