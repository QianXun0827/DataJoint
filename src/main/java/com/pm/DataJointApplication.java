package com.pm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据对接启动类
 *
 * @author huhaiqiang
 */
@SpringBootApplication(scanBasePackages = {
        "com.pm.lb.*", "com.pm.hk.*"
})
@MapperScan(value = {
        "com.pm.lb.mapper", "com.pm.hk.mapper"
})
@EnableTransactionManagement
@EnableCaching
public class DataJointApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJointApplication.class, args);
    }
}
