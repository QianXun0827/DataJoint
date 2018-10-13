package com.pm.hk.service;

import com.pm.hk.pojo.ServiceDownloadPojo;
import com.pm.hk.pojo.ServiceTokenPojo;

/**
 * 海康对接Service层
 *
 * @author huhaiqiang
 * @date 2018/10/13 10:25
 */
public interface HkService {

    /**
     * 下载客户端/更新客户端
     *
     * @param downloadPojo
     * @return
     */
    String serviceDownload(ServiceDownloadPojo downloadPojo);

    /**
     * 获取预览回放token
     *
     * @param tokenPojo
     * @return
     */
    String serviceToken(ServiceTokenPojo tokenPojo);
}
