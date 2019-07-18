package ank.hao.beans;

import ank.hao.beans.bean.InterfaceBean;
import ank.hao.beans.bean.ParentBean;
import ank.hao.beans.bean.TestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.EncodedResource;

import java.net.MalformedURLException;
import java.util.concurrent.ThreadLocalRandom;

public class Demo1 {


    public static void main(String[] args) throws MalformedURLException {
//        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
//        Resource resource = new ClassPathResource("spring.xml");
//        //Resource resource = new UrlResource("https://github.com/haoankang/SpringA5/blob/master/BeanAnalysis/src/main/resources/spring.xml");
//        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
//        xmlBeanDefinitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_XSD);
//
//        xmlBeanDefinitionReader.loadBeanDefinitions(resource);
//        //xmlBeanDefinitionReader.loadBeanDefinitions(resource);
//        TestBean testBean = beanFactory.getBean(TestBean.class);
//        beanFactory.getBean("testBean2");
//        beanFactory.getBean("testBean", TestBean.class);
//
//        System.out.println("====================");
//        //beanFactory.getBean(TestBean.class);
//        System.out.println(ThreadLocalRandom.current().nextInt(10));
//
//        //beanFactory.getBean(ParentBean.class);
//        beanFactory.getBean(InterfaceBean.class).coo();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext.getBean(TestBean.class);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }

}
