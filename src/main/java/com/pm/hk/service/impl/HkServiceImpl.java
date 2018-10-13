package com.pm.hk.service.impl;

import cn.hutool.http.HttpUtil;
import com.pm.hk.pojo.ServiceDownloadPojo;
import com.pm.hk.pojo.ServiceTokenPojo;
import com.pm.hk.service.HkService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 海康对接ServiceImpl层
 *
 * @author huhaiqiang
 * @date 2018/10/13 10:26
 */
@Service("HkServiceImpl")
public class HkServiceImpl implements HkService {

    @Override
    public String serviceDownload(ServiceDownloadPojo downloadPojo) {
        String urlParam = "https://47.97.94.244:443/b/lep/video/serviceDownload";
        Map<String, Object> params = new HashMap<>(4);
        params.put("type", downloadPojo.getType());
        params.put("scheme", downloadPojo.getScheme());
        params.put("key", downloadPojo.getKey());
        params.put("secret", downloadPojo.getSecret());

        return HttpUtil.post(urlParam, params);
    }

    @Override
    public String serviceToken(ServiceTokenPojo tokenPojo) {
        String urlParam = "https://47.97.94.244:443/a/lep/authorize/serviceToken";
        Map<String, Object> params = new HashMap<>(4);
        params.put("indexCode", tokenPojo.getIndexCode());
        params.put("scheme", tokenPojo.getScheme());
        params.put("key", tokenPojo.getKey());
        params.put("secret", tokenPojo.getSecret());

        return HttpUtil.post(urlParam, params);
    }
}
