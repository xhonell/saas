package com.xhonell.service;

import com.xhonell.bean.Item;
import com.xhonell.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * program: saas
 * ClassName TestService
 * description:
 * author: xhonell
 * create: 2025年01月16日18时37分
 * Version 1.0
 **/
@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public List<Item> selectAll() {
        return testMapper.selectAll();
    }

}
