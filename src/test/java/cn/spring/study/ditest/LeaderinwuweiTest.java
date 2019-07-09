package cn.spring.study.ditest; 

import cn.spring.study.config.AutoConfig;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
* Leaderinwuwei Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 8, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutoConfig.class)
public class LeaderinwuweiTest {
    @Autowired
    private Leaderinwuwei leaderinwuwei;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: dosomeThing() 
* 
*/ 
@Test
public void testDosomeThing() throws Exception {
    leaderinwuwei.dosomeThing();
} 


} 
