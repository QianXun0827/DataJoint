package com.pm.hk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 海康对接页面
 *
 * @author huhaiqiang
 * @date 2018/10/13 10:27
 */
@Controller
@RequestMapping("/hk")
@Slf4j
public class HkPage {

    @RequestMapping("/hkPage")
    public String HkPage() {
        return "/hk/GetHkData.html";
    }

    @RequestMapping("/hkData")
    public String hkData() {
        return "/hk/HkData.html";
    }
}
