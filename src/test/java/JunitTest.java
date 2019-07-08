import cn.spring.study.autodiservice.autodiserviceimpl.AutoConfig;
import cn.spring.study.ditest.Eat;
import cn.spring.study.ditest.EatMeat;
import cn.spring.study.ditest.Leaderinwuwei;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.*;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/6/28/028 15:10
 * 4 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/beans.xml"})
class JunitTest {
    @Autowired
    private Leaderinwuwei leaderinwuwei;

    @Test
    void eatTest() {
        Eat eat = mock(Eat.class);
        Leaderinwuwei leaderinwuwei = new Leaderinwuwei(eat);
        leaderinwuwei.dosomeThing();
        verify(eat, times(1)).eatSomeThing();
    }

    @Test
    void eatDItest() {
        EatMeat eatMeat = new EatMeat();
        Leaderinwuwei leaderinwuwei = new Leaderinwuwei(eatMeat);
        leaderinwuwei.dosomeThing();
    }

    @Test
    void autoDITest() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AutoConfig.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName: " + beanName);
        }
    }

    @Test
    void autowiredTest() {
        leaderinwuwei.dosomeThing();
    }
}
