package ank.hao.beans.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class AutowireBean {

    @Autowired
    public AutowireBean(){
        System.out.println("AutowireBean init..");
    }
}
