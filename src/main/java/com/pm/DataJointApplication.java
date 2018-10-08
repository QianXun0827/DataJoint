package com.pm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author huhaiqiang
 */
@SpringBootApplication(scanBasePackages= "com.pm.lb")
@MapperScan("com.pm.lb.mapper")
@EnableTransactionManagement
@EnableCaching
public class DataJointApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJointApplication.class, args);
	}
}
