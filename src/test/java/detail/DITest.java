package detail;

import cn.spring.study.beansInterface.Chinese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 13:41
 * 4
 */
public class DITest implements Context{
    @Override
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        Chinese p = ctx.getBean("person", Chinese.class);
        p.useAxe();
        ArrayList list = new ArrayList();
    }
}
