package ank.hao.beans.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleBean implements InitializingBean, DisposableBean {

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct do..");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet do..");
    }

    public void custom_init(){
        System.out.println("custom init..");
    }

    @PreDestroy
    public void preDestory(){
        System.out.println("preDestory..");
    }

    @Override
    public void destroy() {
        System.out.println("destory..");
    }

    public void custom_destory(){
        System.out.println("custom destory..");
    }

}
