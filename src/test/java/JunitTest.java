import cn.spring.study.autodiservice.AutoService;
import cn.spring.study.autodiservice.autodiserviceimpl.AutoServiceImpl;
import cn.spring.study.ditest.Eat;
import cn.spring.study.ditest.EatMeat;
import cn.spring.study.ditest.Leaderinwuwei;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/6/28/028 15:10
 * 4 * 单元测试
 */
class JunitTest {
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
        AutoService autoService = new AutoServiceImpl();
        autoService.print();
    }
}
