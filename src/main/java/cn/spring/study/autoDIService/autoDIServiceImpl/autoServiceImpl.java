package cn.spring.study.autoDIService.autoDIServiceImpl;

import cn.spring.study.autoDIService.autoService;
import org.springframework.stereotype.Component;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 10:41
 * 4
 */
@Component
public class autoServiceImpl implements autoService {
    @Override
    public void print() {
        System.out.println("自动装配成功");
    }
}
