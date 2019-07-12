import cn.spring.study.config.AutoConfig;
import cn.spring.study.testmodel.LongBean;
import cn.spring.study.ditest.Eat;
import cn.spring.study.ditest.EatMeat;
import cn.spring.study.ditest.Leaderinwuwei;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    void mmm() {
        List<Long> a = new ArrayList<>();
        a.add(1L);
        a.add(2L);
        System.out.println("--------a -------------");
        a.forEach(System.out::println);
        List<Long> b = new ArrayList<>();
        b.add(3L);
        b.add(4L);
        System.out.println("--------b -------------");
        b.forEach(System.out::println);
        a.addAll(b);
        System.out.println("--------a 加上b之后-------------");
        a.forEach(System.out::println);
        b.removeIf(v -> v == 3L);
        System.out.println("--------a 在 b remove if 3 之后的结果-------------");
        a.forEach(System.out::println);
        System.out.println("--------b 在 b remove if 3 之后的结果-------------");
        b.forEach(System.out::println);
        System.out.println("--------remove if 对于结果的改变测试完毕-------------");
    }

    @Test
    void nnn() {
        List<Long> a = new ArrayList<>();
        a.add(1L);
        a.add(2L);
        System.out.println("--------a -------------");
        a.forEach(System.out::println);
        List<Long> b = new ArrayList<>();
        b.add(3L);
        b.add(4L);
        System.out.println("--------b -------------");
        b.forEach(System.out::println);
        a.addAll(b);
        System.out.println("--------a 加上b之后-------------");
        a.forEach(System.out::println);
        b = b.stream().filter(v -> v == 3L).collect(Collectors.toList());
        System.out.println("--------a 在 b filter 3 之后的结果-------------");
        a.forEach(System.out::println);
        System.out.println("--------b 在 b filter 3 之后的结果-------------");
        b.forEach(System.out::println);
        System.out.println("--------filter 对于结果的改变测试完毕-------------");
    }

    @Test
    void lll() {
        List<Long> b = new ArrayList<>();
        b.add(3L);
        b.add(4L);
        System.out.println("--------b -------------");
        b.forEach(System.out::println);
        List<Long> a = new ArrayList<>(b);
        System.out.println("--------a 加上b之后-------------");
        a.forEach(System.out::println);
        b = b.stream().filter(v -> v == 3L).collect(Collectors.toList());
        System.out.println("--------a 在 b filter 3 之后的结果-------------");
        a.forEach(System.out::println);
        System.out.println("--------b 在 b filter 3 之后的结果-------------");
        b.forEach(System.out::println);
        System.out.println("--------filter 对于结果的改变测试完毕-------------");
    }


    List<LongBean> addList() {
        List<LongBean> longList = new ArrayList<>();
        for (long i= 0 ; i < 100000 ; i++) {
            LongBean longBean = new LongBean();
            longBean.setaLong(i);
            longList.add(longBean);
        }
        return longList;
    }

    /**
     * 通过beanUtils实现
     */
    @Test
    void testDeepCopyMethodOne() {
        long a = 0;
        for (int i = 0 ;i < 1000 ; i++ ) {
            List<LongBean> longList = addList();
            List<LongBean> newList = new ArrayList<>();
            long start = System.currentTimeMillis();
            longList.forEach(v -> {
                LongBean longBean = new LongBean();
                BeanUtils.copyProperties(v,longBean);
                newList.add(longBean);
            });
            long end = System.currentTimeMillis();
            a += (end - start);
        }
        System.out.println(a);
    }

    /**
     * 原本是想用addAll来实现的，但是IDEA给我推荐通过构造器实现
     */
    @Test
    void testDeepCopyMethodTwo() {
        long a = 0;
        for (int i = 0 ;i < 1000 ; i++ ) {
            List<LongBean> longList = addList();
            List<LongBean> newList = new ArrayList<>();
            long start = System.currentTimeMillis();
            newList.addAll(longList);
            long end = System.currentTimeMillis();
            a += (end - start);
        }
        System.out.println(a);
    }

    /**
     * 网传的深拷贝的实现方法
     */
    @Test
    void testDeepCopyMethodThree() {
        long a = 0;
        for (int i = 0 ;i < 1000 ; i++ ) {
            List<LongBean> longList = addList();
            List<LongBean> newList = new ArrayList<>();
            long start = System.currentTimeMillis();
            try {
                ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOut);
                out.writeObject(longList);
                ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
                ObjectInputStream in = new ObjectInputStream(byteIn);
                newList = (List<LongBean>) in.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            a += (end - start);
        }
        System.out.println(a);
    }



}
