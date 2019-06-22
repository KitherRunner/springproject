package com.kither.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kither.mapper")
public class SysConfiguration {
}
