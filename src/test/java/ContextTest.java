import cn.spring.study.DITest.Leaderinwuwei;
import cn.spring.study.beansInterface.Chinese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;




/*public class ContextTest {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        Chinese p = ctx.getBean("person", Chinese.class);
        p.useAxe();
        ArrayList list = new ArrayList();
    }
}*/

/**
 * 依赖注入上下文测试
 */
public class ContextTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("conf/beans.xml");
        Leaderinwuwei leaderinwuwei = context.getBean(Leaderinwuwei.class);
        leaderinwuwei.dosomeThing();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
