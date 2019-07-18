package ank.hao.beans.bean;

public abstract class ParentBean {
    public ParentBean(){
        System.out.println("ParentBean has init..");
    }

    abstract void doo();
}
