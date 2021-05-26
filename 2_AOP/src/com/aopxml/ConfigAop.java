package com.aopxml;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.aopxml"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
