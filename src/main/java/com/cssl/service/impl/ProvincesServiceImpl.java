package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.ProvincesDao;
import com.cssl.pojo.TbProvinces;
import com.cssl.service.ProvincesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProvincesServiceImpl extends ServiceImpl<ProvincesDao, TbProvinces> implements ProvincesService {
}
