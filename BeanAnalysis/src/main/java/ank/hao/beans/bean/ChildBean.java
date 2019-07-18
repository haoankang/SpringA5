package ank.hao.beans.bean;

public class ChildBean extends ParentBean {

    public ChildBean(){
        System.out.println("child init..");
    }

    @Override
    void doo() {
        System.out.println("child doo..");
    }
}
