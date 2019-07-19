package ank.hao.context;

import ank.hao.beans.MyBeanFactoryPostProcessor;
import ank.hao.beans.MyBeanPostProcessor;
import ank.hao.beans.MyFactoryBean;
import ank.hao.beans.bean.SingletonBean;
import ank.hao.beans.bean.TestBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.context.ApplicationContext;

public class Demo2 {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnkApplicationContext("spring.xml");
        //applicationContext.getBean(TestBean.class);
//        applicationContext.getBean("testBean3");
//        applicationContext.getBean("testBean");
//
//        applicationContext.getBean(ConstructorBean.class);

        //((AnkApplicationContext) applicationContext).addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());

        TestBean testBean = applicationContext.getBean("testBean4", TestBean.class);
        testBean.say();
//        TestBean testBean1 = applicationContext.getBean("testBean5", TestBean.class);
//        testBean1.say();

//        applicationContext.getBean(DIABean.class);


        applicationContext.getBean(SingletonBean.class).say();

        System.out.println("===============");
        Object sss = applicationContext.getBean("&aaa");

        BeanWrapper beanWrapper = new BeanWrapperImpl();

        ((AnkApplicationContext) applicationContext).registerShutdownHook();
    }
}
