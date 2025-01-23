package com.xhonell.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.RoleQueryDto;
import com.xhonell.pojo.entity.Role;
import com.xhonell.pojo.vo.RoleListVo;
import org.apache.ibatis.annotations.Param;

/**
 * program: saas
 * ClassName RoleMapper
 * description:
 * author: xhonell
 * create: 2025年01月23日21时05分
 * Version 1.0
 **/
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 分页查询角色列表
     * @param page
     * @param roleQueryDto
     * @return
     */
    Page<RoleListVo> findRoleByQueryDto(Page<Role> page, @Param("roleQueryDto") RoleQueryDto roleQueryDto);
}
