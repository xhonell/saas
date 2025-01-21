package com.xhonell.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhonell.mapper.ApplicationMapper;
import com.xhonell.pojo.dto.ApplicationQueryDto;
import com.xhonell.pojo.entity.Application;
import com.xhonell.pojo.vo.ApplicationListVo;
import com.xhonell.service.ApplicationService;
import org.springframework.stereotype.Service;

/**
 * program: saas
 * ClassName ApplicationServiceImpl
 * description:
 * author: xhonell
 * create: 2025年01月20日18时20分
 * Version 1.0
 **/
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {
    @Override
    public Page<ApplicationListVo> findApplicationByQueryDto(ApplicationQueryDto applicationQueryDto) {
        Page<Application> page = new Page<>(applicationQueryDto.getPage(), applicationQueryDto.getLimit());
        return getBaseMapper().findApplicationByQueryDto(page,applicationQueryDto);
    }
}
