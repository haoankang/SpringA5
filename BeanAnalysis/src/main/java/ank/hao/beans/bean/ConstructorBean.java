package ank.hao.beans.bean;

public class ConstructorBean {

    public ConstructorBean(){
        System.out.println("init.. void");
    }

    public ConstructorBean(String msg){
        System.out.println("init.. "+msg);
    }
}
