package detail;

import cn.spring.study.DITest.Leaderinwuwei;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/7/5/005 13:43
 * 4
 */
public class ContextTest implements Context{
    @Override
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/beans.xml");
        Leaderinwuwei leaderinwuwei = context.getBean(Leaderinwuwei.class);
        leaderinwuwei.dosomeThing();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
