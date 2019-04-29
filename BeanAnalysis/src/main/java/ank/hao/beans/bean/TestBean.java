package ank.hao.beans.bean;

public class TestBean {

    TestBean(){
        System.out.println("TestBean init..");
    }

    void say(){
        System.out.println("TestBean say..");
    }

    static void init(){
        System.out.println("TestBean init..");
    }
}
