package ank.hao.spring_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Demo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ank.hao.spring_aop");
        //((AnnotationConfigApplicationContext) applicationContext).refresh();
        Tenant tenant = applicationContext.getBean(Tenant.class);
        tenant.rent("sdkjg");
    }
}
