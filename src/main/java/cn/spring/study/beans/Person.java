package cn.spring.study.beans;

public class Person {
    private Axe axe;
    public void setAxe(Axe axe){
        this.axe = axe;
    }
    public void useAxe(){
        System.out.println(axe.chop());
    }
}
