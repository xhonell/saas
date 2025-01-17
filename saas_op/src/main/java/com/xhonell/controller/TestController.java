package com.xhonell.controller;

import com.xhonell.bean.Item;
import com.xhonell.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * program: saas
 * ClassName TestController
 * description:
 * author: xhonell
 * create: 2025年01月16日18时35分
 * Version 1.0
 **/
@Controller
@RequestMapping("/test")
@ResponseBody
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/selectAll")
    public List<Item> selectAll() {

        return testService.selectAll();
    }
}
