package ank.hao.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;

public class MyConfig {

    @Bean
    public FactoryBean<String> aaa(){
        return new MyFactoryBean();
    }
}
