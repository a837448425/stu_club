package com.lxz.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 刷题微服务启动类
 * @Author: luo
 * @date: 2023/12/11 19:21
 * @Description:
 * @Version: 1.0
 */

@SpringBootApplication
@ComponentScan("com.lxz")
@MapperScan("com.lxz.**.mapper")
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class, args);
    }
}
