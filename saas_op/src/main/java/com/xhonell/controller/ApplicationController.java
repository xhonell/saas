package com.xhonell.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhonell.pojo.dto.BatchRemoveDto;
import com.xhonell.pojo.dto.ApplicationQueryDto;
import com.xhonell.pojo.entity.Application;
import com.xhonell.pojo.vo.ApplicationListVo;
import com.xhonell.result.Result;
import com.xhonell.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * program: saas
 * ClassName ApplicationController
 * description:
 * author: xhonell
 * create: 2025年01月18日21时56分
 * Version 1.0
 **/
@Controller
@RequestMapping("/application")
@ResponseBody
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    /**
     * 返回租户列表
     * @param applicationQueryDto
     * @return
     */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public Result list(ApplicationQueryDto applicationQueryDto) {

        Page<ApplicationListVo> page = applicationService.findApplicationByQueryDto(applicationQueryDto);


        return Result.success(page.getTotal(), page.getRecords());
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.POST)
    public Result insert(@RequestBody Application application) {
        boolean save = applicationService.save(application);
        return Result.judge(save);
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public Result update(@RequestBody Application application) {
        boolean save = applicationService.updateById(application);
        return Result.judge(save);
    }



    @RequestMapping(value = "/find" ,method = RequestMethod.GET)
    public Result findById(@RequestParam Long id) {
        Application application = applicationService.getById(id);
        return Result.success(application);
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public Result delete(@RequestParam Long id) {
        boolean remove = applicationService.removeById(id);
        return Result.judge(remove);
    }

    @RequestMapping(value = "/batchRemove" ,method = RequestMethod.POST)
    public Result batchRemove(@RequestBody BatchRemoveDto batchRemoveDto) {
        boolean remove = applicationService.removeByIds(batchRemoveDto.getIds());
        return Result.judge(remove);
    }

}
