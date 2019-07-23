package ank.hao.beans;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<String> {
    @Override
    public String getObject() {
        return new String("kaka");
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }
}
