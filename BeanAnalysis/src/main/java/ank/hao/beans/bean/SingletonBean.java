package ank.hao.beans.bean;

public abstract class SingletonBean {

    public void say(){

        createPrototypeBean().ddd();
    }

//    public void setPrototypeBean(PrototypeBean prototypeBean){
//        this.prototypeBean = prototypeBean;
//    }

    public abstract PrototypeBean createPrototypeBean();
}
