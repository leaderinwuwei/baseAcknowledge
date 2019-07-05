package cn.spring.study.ditest;

/**
 * 2 * @Author: WF
 * 3 * @Date: 2019/6/28/028 14:59
 * 4
 */
public class Leaderinwuwei {
    private Eat eat;

    public Leaderinwuwei(Eat eat) {
        this.eat = eat;
    }

    public void dosomeThing() {
        eat.eatSomeThing();
    }
}
