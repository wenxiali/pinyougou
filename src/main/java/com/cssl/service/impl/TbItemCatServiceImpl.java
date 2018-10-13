package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbItemCatDao;
import com.cssl.pojo.TbItemCat;
import com.cssl.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional
@AutoConfigureAfter({TbItemCatDao.class})
public class TbItemCatServiceImpl extends ServiceImpl<TbItemCatDao,TbItemCat> implements TbItemCatService {

    @Autowired
    private TbItemCatDao tbdao;

    @Override
    public List<TbItemCat> selectSecond(int id) {
        return tbdao.selectSecond(id);
    }
}
