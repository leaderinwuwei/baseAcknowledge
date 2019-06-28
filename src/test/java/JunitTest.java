import cn.spring.study.DITest.Eat;
import cn.spring.study.DITest.EatMeat;
import cn.spring.study.DITest.Leaderinwuwei;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/6/28/028 15:10
 * 4 * 单元测试
 */
public class JunitTest {
    @Test
    public void eatTest() {
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
}
