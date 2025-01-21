package com.xhonell.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhonell.commons.DigesterUtils;
import com.xhonell.commons.TokenUtils;
import com.xhonell.exception.BizException;
import com.xhonell.mapper.AdminMapper;
import com.xhonell.pojo.dto.AdminAddDto;
import com.xhonell.pojo.dto.AdminLoginDto;
import com.xhonell.pojo.entity.Admin;
import com.xhonell.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * program: saas
 * ClassName AdminServiceImpl
 * description:
 * author: xhonell
 * create: 2025年01月21日14时20分
 * Version 1.0
 **/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    /**
     * 插入用户
     * @param adminAddDto 用户信息
     * @return 条目数
     */
    @Override
    public boolean insertAdmin(AdminAddDto adminAddDto) {

        if (adminAddDto == null) {
            throw new BizException("用户信息不能为空");
        }

        checkUsername(adminAddDto.getUsername());

        checkEmail(adminAddDto.getEmail());

        checkPhone(adminAddDto.getPhone());

        Admin admin = new Admin();

        BeanUtils.copyProperties(adminAddDto, admin);

        String salt = DigesterUtils.createSalt();
        admin.setSalt(salt);

        String password = createPassword(admin.getPhone(), salt);

        admin.setPassword(password);

        return getBaseMapper().insert(admin) > 0;


    }

    /**
     * 登录
     * @param adminLoginDto 登录信息
     * @return 结果
     */
    @Override
    public String login(AdminLoginDto adminLoginDto) {
        if (adminLoginDto == null) throw new BizException("账号密码不能为空");

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, adminLoginDto.getUsername());

        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin == null) throw new BizException("账号密码错误");

        String salt = admin.getSalt();
        String password = DigesterUtils.digesterPassword(adminLoginDto.getPassword(), salt);
        if (!password.equals(admin.getPassword())) throw new BizException("账号密码错误");

        Map<String,Object> map = new HashMap<>();

        map.put("id",admin.getId());
        map.put("name",admin.getName());
        map.put("username",admin.getUsername());
        map.put("image",admin.getImage());
        map.put("phone",admin.getPhone());
        map.put("expire",System.currentTimeMillis()+1000*60*60*2);

        return TokenUtils.createToken(map);
    }

    private String createPassword(String phone, String salt) {

        String initPassword = phone.substring(5);
        return DigesterUtils.digesterPassword(initPassword, salt);
    }

    /**
     * 检查用户民
     * @param username 用户名
     */
    private void checkUsername(String username) {
        if (StrUtil.isEmpty(username)) throw new BizException("用户名不能为空");

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, username);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException("用户名已经存在");
    }

    /**
     * 检查邮箱
     * @param email 邮箱
     */
    private void checkEmail(String email) {
        if (StrUtil.isEmpty(email)) throw new BizException("邮箱不能为空");

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getEmail, email);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException("邮箱已经存在");
    }

    /**
     * 检查手机号
     * @param phone 手机号
     */
    private void checkPhone(String phone) {
        if (StrUtil.isEmpty(phone)) throw new BizException("手机号不能为空");

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getPhone, phone);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException("手机号已经存在");
    }
}
