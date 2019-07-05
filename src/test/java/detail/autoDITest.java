package detail;

import cn.spring.study.autoDIService.autoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 13:44
 * 4
 */
public class autoDITest implements Context{
    private static cn.spring.study.autoDIService.autoService autoService;


    static {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        autoService = ctx.getBean(autoService.class);
    }

    @Override
    public void test() {
        autoService.print();

    }
}
