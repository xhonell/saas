package com.xhonell.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xhonell.pojo.dto.AdminAddDto;
import com.xhonell.pojo.dto.AdminLoginDto;
import com.xhonell.pojo.dto.AdminQueryDto;
import com.xhonell.pojo.dto.UpdateAdminRoleDto;
import com.xhonell.pojo.entity.Admin;
import com.xhonell.pojo.vo.AdminListVo;

import java.util.List;

/**
 * program: saas
 * ClassName AdminService
 * description:
 * author: xhonell
 * create: 2025年01月21日14时20分
 * Version 1.0
 **/
public interface AdminService extends IService<Admin> {

    Page<AdminListVo> findAdminByQueryDto(AdminQueryDto adminQueryDto);

    boolean insertAdmin(AdminAddDto adminAddDto);

    String login(AdminLoginDto adminLoginDto);

    void updateAdminRole(UpdateAdminRoleDto updateAdminRoleDto);


}
