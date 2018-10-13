package com.pm.hk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 预览回放pojo类
 *
 * @author huhaiqiang
 * @date 2018/10/13 10:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTokenPojo {

    private String indexCode;
    private String scheme;
    private String key;
    private String secret;
}
