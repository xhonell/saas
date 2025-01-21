package com.xhonell.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.ApplicationQueryDto;
import com.xhonell.pojo.entity.Application;
import com.xhonell.pojo.vo.ApplicationListVo;
import org.apache.ibatis.annotations.Param;

/**
 * program: saas
 * ClassName ApplicationMapper
 * description:
 * author: xhonell
 * create: 2025年01月20日17时52分
 * Version 1.0
 **/
public interface ApplicationMapper extends BaseMapper<Application> {
    Page<ApplicationListVo> findApplicationByQueryDto(Page<Application> page, @Param("application") ApplicationQueryDto applicationQueryDto);
}
