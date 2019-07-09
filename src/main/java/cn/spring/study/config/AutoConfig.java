package cn.spring.study.config;

import cn.spring.study.autodiservice.autodiserviceimpl.AutoServiceImpl;
import cn.spring.study.autodiservice.autodiserviceimpl.DITest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 10:52
 * 4
 */
@Configuration
@ComponentScan(basePackageClasses = {AutoServiceImpl.class, DITest.class})
@ImportResource(locations = {"classpath:conf/beans.xml"})
public class AutoConfig {
}
