package com.pm.hk.controller;

import cn.hutool.http.HttpUtil;
import com.pm.common.utils.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 海康对接controller层
 *
 * @author huhaiqiang
 * @date 2018/10/08 15:19
 */
@Controller
@RequestMapping("/hk")
@Slf4j
public class HkController {

    @RequestMapping("/getToken")
    @ResponseBody
    public SysResult getToken(){
        String urlParam = "https://47.97.94.244:443/a/lep/accessToken";
        Map<String, Object> params = new HashMap<>(4);
        params.put("key", "IrwyWsFWcL8yAV7j");
        params.put("secret", "frbUZMfp6wrzR3nyDt2AZ9rSUAGdZU");
        params.put("scheme", "pmjs");
        params.put("userName", "admin");

        String msg = HttpUtil.post(urlParam, params);
        return SysResult.oK(msg);
    }

    @RequestMapping("/getDevicesOnline")
    @ResponseBody
    public SysResult getDevicesOnline(String token, String url) {
        String urlParam = url;
        Map<String, Object> params = new HashMap<>(4);
        params.put("token", token);
        params.put("name", "");
        params.put("pageSize", 10);
        params.put("pageNo", 1);

        String msg = HttpUtil.post(urlParam, params);
        return SysResult.oK(msg);
    }

}
