package com.pm.hk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下载视频客户端pojo
 *
 * @author huhaiqiang
 * @date 2018/10/13 09:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDownloadPojo {

    private Integer type;
    private String scheme;
    private String key;
    private String secret;
}
