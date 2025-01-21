package com.xhonell.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xhonell.pojo.dto.AdminAddDto;
import com.xhonell.pojo.dto.AdminLoginDto;
import com.xhonell.pojo.entity.Admin;

/**
 * program: saas
 * ClassName AdminService
 * description:
 * author: xhonell
 * create: 2025年01月21日14时20分
 * Version 1.0
 **/
public interface AdminService extends IService<Admin> {

    boolean insertAdmin(AdminAddDto adminAddDto);

    String login(AdminLoginDto adminLoginDto);
}
