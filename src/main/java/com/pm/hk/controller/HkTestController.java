package com.pm.hk.controller;

import com.pm.common.utils.SysResult;
import com.pm.hk.pojo.ServiceDownloadPojo;
import com.pm.hk.pojo.ServiceTokenPojo;
import com.pm.hk.service.HkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 海康测试接口
 *
 * @author huhaiqiang
 * @date 2018/10/13 10:28
 */
@Controller
@RequestMapping("/hk")
@Slf4j
public class HkTestController {

    @Autowired
    private HkService hkService;

    @RequestMapping("/serviceDownload")
    @ResponseBody
    public SysResult serviceDownload(ServiceDownloadPojo downloadPojo) {
        String msg =  hkService.serviceDownload(downloadPojo);
        return SysResult.oK(msg);
    }

    @RequestMapping("/serviceToken")
    @ResponseBody
    public SysResult serviceToken (ServiceTokenPojo tokenPojo) {
        String msg =  hkService.serviceToken (tokenPojo);
        return SysResult.oK(msg);
    }
}
