package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.AreasDao;
import com.cssl.pojo.TbAreas;
import com.cssl.service.AreasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AreasServiceImpl extends ServiceImpl<AreasDao, TbAreas> implements AreasService {
}
