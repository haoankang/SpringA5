package ank.hao.beans.bean;

public class TestBean {

    TestBean(String mmm){
        System.out.println("TestBean init.."+mmm);
    }

    public void say(){
        System.out.println("TestBean say..");
    }

    static void init(){
        System.out.println("TestBean init..");
    }

    void destory(){
        System.out.println("TestBean destory..");
    }
}
