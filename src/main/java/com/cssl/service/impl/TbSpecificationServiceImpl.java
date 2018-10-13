package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbItemDao;
import com.cssl.dao.TbSpecificationDao;
import com.cssl.pojo.TbSpecification;
import com.cssl.service.TbSpecificationService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AutoConfigureAfter({TbSpecificationDao.class})
public class TbSpecificationServiceImpl extends ServiceImpl<TbSpecificationDao, TbSpecification> implements TbSpecificationService {
}
