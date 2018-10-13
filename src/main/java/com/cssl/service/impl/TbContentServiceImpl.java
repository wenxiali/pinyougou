package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.TbContentDao;
import com.cssl.pojo.TbContent;
import com.cssl.service.TbContentService;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AutoConfigureAfter({TbContentDao.class})
public class TbContentServiceImpl extends ServiceImpl<TbContentDao, TbContent> implements TbContentService {
}
