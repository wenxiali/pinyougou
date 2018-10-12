package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.CityDao;
import com.cssl.pojo.TbCities;
import com.cssl.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityServiceImpl extends ServiceImpl<CityDao, TbCities> implements CityService {
}
