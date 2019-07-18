package ank.hao.beans.bean;

public class StaticInstantiateBean {

    public StaticInstantiateBean(){
        System.out.println("static init..");
    }

    public static TestBean createInstance(){
        return new TestBean("aa");
    }

    public TestBean createInstance2(){
        return new TestBean("bb");
    }
}
