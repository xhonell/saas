package com.xhonell.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xhonell.commons.DigesterUtils;
import com.xhonell.commons.TokenUtils;
import com.xhonell.exception.BizException;
import com.xhonell.mapper.AdminMapper;
import com.xhonell.mapper.AdminRoleMapper;
import com.xhonell.pojo.dto.AdminAddDto;
import com.xhonell.pojo.dto.AdminLoginDto;
import com.xhonell.pojo.dto.AdminQueryDto;
import com.xhonell.pojo.dto.UpdateAdminRoleDto;
import com.xhonell.pojo.entity.Admin;
import com.xhonell.pojo.entity.AdminRole;
import com.xhonell.pojo.entity.RolePermission;
import com.xhonell.pojo.vo.AdminListVo;
import com.xhonell.result.ResultEnum;
import com.xhonell.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public Page<AdminListVo> findAdminByQueryDto(AdminQueryDto adminQueryDto) {
        Page<Admin> page = new Page<>(adminQueryDto.getPage(), adminQueryDto.getLimit());
        return getBaseMapper().findAdminByQueryDto(page, adminQueryDto);
    }

    /**
     * 插入用户
     * @param adminAddDto 用户信息
     * @return 条目数
     */
    @Override
    public boolean insertAdmin(AdminAddDto adminAddDto) {

        if (adminAddDto == null) {
            throw new BizException(ResultEnum.USER_NOT_EMPTY);
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
        if (adminLoginDto == null) throw new BizException(ResultEnum.USER_NOT_EMPTY);

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, adminLoginDto.getUsername());

        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin == null) throw new BizException(ResultEnum.USERNAME_OR_PASSWORD_ERROR);

        String salt = admin.getSalt();
        String password = DigesterUtils.digesterPassword(adminLoginDto.getPassword(), salt);
        if (!password.equals(admin.getPassword())) throw new BizException(ResultEnum.USERNAME_OR_PASSWORD_ERROR);

        Map<String,Object> map = new HashMap<>();

        map.put("id",admin.getId());
        map.put("name",admin.getName());
        map.put("username",admin.getUsername());
        map.put("image",admin.getImage());
        map.put("phone",admin.getPhone());
        map.put("expire",System.currentTimeMillis()+1000*60*60*2);

        return TokenUtils.createToken(map);
    }

    @Override
    public void updateAdminRole(UpdateAdminRoleDto updateAdminRoleDto) {
        //删除该角色所有权限
        LambdaQueryWrapper<AdminRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(updateAdminRoleDto.getAdminId() != null, AdminRole::getAdminId, updateAdminRoleDto.getAdminId());
        adminRoleMapper.delete(queryWrapper);

        //获取角色的id集合
        List<Long> roleIds = updateAdminRoleDto.getRoleIds();

        //判断角色集合是否为空
        if(!CollectionUtils.isEmpty(roleIds)){

            log.debug("往中间表插入数据...roleId:{},permissionIds:{}",updateAdminRoleDto.getAdminId(),roleIds);

            roleIds.forEach(roleId->{
                AdminRole adminRole=new AdminRole();
                adminRole.setAdminId(updateAdminRoleDto.getAdminId());
                adminRole.setRoleId(roleId);
                adminRoleMapper.insert(adminRole);
            });

        }

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
        if (StrUtil.isEmpty(username)) throw new BizException(ResultEnum.USER_NOT_EMPTY);

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, username);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException(ResultEnum.USERNAME_EXITS);
    }

    /**
     * 检查邮箱
     * @param email 邮箱
     */
    private void checkEmail(String email) {
        if (StrUtil.isEmpty(email)) throw new BizException(ResultEnum.EMAIL_NOT_EMPTY);

        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getEmail, email);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException(ResultEnum.EMAIL_EXITS);
    }

    /**
     * 检查手机号
     * @param phone 手机号
     */
    private void checkPhone(String phone) {
        if (StrUtil.isEmpty(phone)) throw new BizException(ResultEnum.PHONE_NOT_EMPTY);
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getPhone, phone);
        Admin admin = getBaseMapper().selectOne(queryWrapper);
        if (admin != null) throw new BizException(ResultEnum.PHONE_EXITS);
    }
}
