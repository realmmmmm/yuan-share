package com.mmm;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mmm.*.mapper")
@Slf4j
public class YuanFullstackBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuanFullstackBackendApplication.class, args);
    }

}
