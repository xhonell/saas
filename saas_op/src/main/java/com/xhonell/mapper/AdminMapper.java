package com.xhonell.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.AdminQueryDto;
import com.xhonell.pojo.entity.Admin;
import com.xhonell.pojo.vo.AdminListVo;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<Admin> {

    Page<AdminListVo> findAdminByQueryDto(Page<Admin> page ,@Param("adminQueryDto") AdminQueryDto adminQueryDto);
}
