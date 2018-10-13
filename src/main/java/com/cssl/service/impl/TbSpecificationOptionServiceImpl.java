package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbSpecificationDao;
import com.cssl.dao.TbSpecificationOptionDao;
import com.cssl.pojo.TbSpecificationOption;
import com.cssl.service.TbSpecificationOptionService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AutoConfigureAfter({TbSpecificationOptionDao.class})
public class TbSpecificationOptionServiceImpl extends ServiceImpl<TbSpecificationOptionDao, TbSpecificationOption> implements TbSpecificationOptionService {
}
