package cn.spring.study.autodiservice;

import cn.spring.study.config.AutoConfig;
import cn.spring.study.autodiservice.autodiserviceimpl.DITest;
import cn.spring.study.ditest.Leaderinwuwei;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JunitTest Tester.
 * 此测试类需要在java包下才能够拿到实例化的bean
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>七月 6, 2019</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfig.class)
public class JavaConfigTest {
    @Autowired
    private AutoService autoService;
    @Autowired
    private DITest diTest;
    @Autowired
    private Leaderinwuwei leaderinwuwei;
    @Test
    public void testAutoDITest() throws Exception {
        autoService.print();
        diTest.pp();
        leaderinwuwei.dosomeThing();
    }


} 
