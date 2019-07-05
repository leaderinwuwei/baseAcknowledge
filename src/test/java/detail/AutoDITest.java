package detail;

import cn.spring.study.autodiservice.AutoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 13:44
 * 4
 */
public class AutoDITest implements Context{
    private static AutoService auto;


    static {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        auto = (AutoService) ctx.getBean("autoService");
    }

    @Override
    public void test() {
        auto.print();

    }
}
