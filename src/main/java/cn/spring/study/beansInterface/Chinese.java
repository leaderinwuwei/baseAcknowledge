package cn.spring.study.beansinterface;

/**
 * @author Administrator
 */
public class Chinese implements Person {
    private Axe axe;
    public void setAxe(Axe axe){
        this.axe = axe;
    }

    @Override
    public void useAxe() {
        System.out.println(axe.chop());
    }

}
