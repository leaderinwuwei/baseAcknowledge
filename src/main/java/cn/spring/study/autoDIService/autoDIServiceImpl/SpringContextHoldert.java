package cn.spring.study.autoDIService.autoDIServiceImpl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 11:34
 * 4
 */
public class SpringContextHoldert implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext a) throws BeansException {
            applicationContext = a;
    }
}