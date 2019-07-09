import cn.spring.study.config.AutoConfig;
import detail.AutoDITest;
import detail.Context;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextTest {
    protected void getAllInitializedBean() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AutoConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println("beanName: " + beanName);
        }
    }

    /**
     * 此方法用来在非测试类中测试Spring
     *
     * @param args
     */
    public static void main(String[] args) {
        Context context = new AutoDITest();
        context.test();
    }
}