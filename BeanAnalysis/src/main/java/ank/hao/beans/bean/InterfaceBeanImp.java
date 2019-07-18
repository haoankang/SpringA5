package ank.hao.beans.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class InterfaceBeanImp implements InterfaceBean {

    @Autowired
    public InterfaceBeanImp(){
        System.out.println("interfaceBeanImpl init..");
    }
}
