package cn.spring.study.autodiservice.autodiserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 16:58
 * 4
 */
@Component
public class DITest {
    @Autowired
    private AutoServiceImpl autoServiceImpl;

    public void pp() {
        autoServiceImpl.print();
        System.out.println("注入成功");
    }
}
