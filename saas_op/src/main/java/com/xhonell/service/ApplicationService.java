package com.xhonell.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhonell.pojo.dto.ApplicationQueryDto;
import com.xhonell.pojo.entity.Application;
import com.xhonell.pojo.vo.ApplicationListVo;
import org.apache.ibatis.annotations.Param;

public interface ApplicationService extends IService<Application> {

    Page<ApplicationListVo> findApplicationByQueryDto(ApplicationQueryDto applicationQueryDto);


}
