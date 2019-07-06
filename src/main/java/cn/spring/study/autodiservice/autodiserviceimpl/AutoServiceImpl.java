package cn.spring.study.autodiservice.autodiserviceimpl;

import cn.spring.study.autodiservice.AutoService;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 10:41
 * 4
 */
@Component
public class AutoServiceImpl implements AutoService {
    public AutoServiceImpl() {
        System.out.println("实例化！！！！！！！！！！！！！！");
    }

    @Override
    public void print() {
        System.out.println("自动装配成功");
    }
}
