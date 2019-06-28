import cn.spring.study.beansInterface.Chinese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class beansTest {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/beans.xml");
        Chinese p = ctx.getBean("person", Chinese.class);
        p.useAxe();
        /*-----------------------*/
        ArrayList list = new ArrayList();
    }
}
