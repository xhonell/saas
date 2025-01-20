package com.xhonell.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.BaseQueryDto;
import com.xhonell.pojo.dto.BatchRemoveDto;
import com.xhonell.pojo.dto.TenementQueryDto;
import com.xhonell.pojo.entity.Tenement;
import com.xhonell.result.Result;
import com.xhonell.service.TenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * program: saas
 * ClassName TenementController
 * description:
 * author: xhonell
 * create: 2025年01月18日21时56分
 * Version 1.0
 **/
@Controller
@RequestMapping("/tenement")
@ResponseBody
public class TenementController {
    @Autowired
    private TenementService tenementService;

    /**
     * 返回租户列表
     * @param tenementQueryDto
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result list(TenementQueryDto tenementQueryDto) {

        //创建分页条件
        Page<Tenement> tenementPage = new Page<>(tenementQueryDto.getPage(), tenementQueryDto.getLimit());

        //准备查询条件
        LambdaQueryWrapper<Tenement> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(tenementQueryDto.getCompanyName()), Tenement::getCompanyName, tenementQueryDto.getCompanyName())
                .eq(tenementQueryDto.getBusinessId()!= null, Tenement::getBusinessId, tenementQueryDto.getBusinessId());

        Page<Tenement> page = tenementService.page(tenementPage, queryWrapper);


        return Result.success(page.getTotal(), page.getRecords());
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result insert(@RequestBody Tenement tenement) {
        boolean save = tenementService.save(tenement);
        return Result.judge(save);
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Result update(@RequestBody Tenement tenement) {
        boolean save = tenementService.updateById(tenement);
        return Result.judge(save);
    }



    @RequestMapping(value = "/find" ,method = RequestMethod.GET)
    public Result findById(@RequestParam Long id) {
        Tenement tenement = tenementService.getById(id);
        return Result.success(tenement);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Result delete(@RequestParam Long id) {
        boolean remove = tenementService.removeById(id);
        return Result.judge(remove);
    }

    @RequestMapping(value = "/batchRemove" ,method = RequestMethod.POST)
    public Result batchRemove(@RequestBody BatchRemoveDto batchRemoveDto) {
        boolean remove = tenementService.removeByIds(batchRemoveDto.getIds());
        return Result.judge(remove);
    }

}
