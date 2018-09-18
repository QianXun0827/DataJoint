package com.pm.data.controller;

import com.pm.data.vo.LBPojoList;
import com.pm.data.service.LbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huhaiqiang
 * @date 2018/09/14 14:09
 */
@Controller
public class LbController {

    @Autowired
    private LbService lbService;

    @RequestMapping("/test")
    public String testHtml() {
        return "/LbData.html";
    }

    @RequestMapping(value = "/insert" ,consumes = "application/json;charset=utf-8")
    @ResponseBody
    public void insertData(@RequestBody LBPojoList bojoList) {
        lbService.insertData(bojoList);
    }
}
