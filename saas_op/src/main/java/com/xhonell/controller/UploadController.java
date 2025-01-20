package com.xhonell.controller;

import com.xhonell.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * program: saas
 * ClassName Upload
 * description:
 * author: xhonell
 * create: 2025年01月19日16时02分
 * Version 1.0
 **/
@Controller
@RequestMapping("/upload")
@ResponseBody
public class UploadController{

    @RequestMapping(value = "/image",method = RequestMethod.POST)
    public Result image(@RequestParam MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        file.transferTo(new File("D:\\Program Files\\Apache\\nginx-1.18.0\\information\\img" +File.separator + newFileName));
        String HttpPath = "http://img.saas.com/img" + File.separator+ newFileName;
        Map<String, String> result = new HashMap<>();
        result.put("src", HttpPath);
        return Result.success(result);
    }
}
