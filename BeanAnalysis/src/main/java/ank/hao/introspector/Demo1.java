package ank.hao.introspector;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

//内省访问JavaBean的两种方法
public class Demo1 {

    public static void main(String[] args) throws Exception {
        demo1();
        System.out.println("----------------------");
        //demo2();
        demo3();
    }

    //1. 通过PropertyDescriptor来操作Bean对象
    public static void demo1() throws Exception{
        Person person = new Person();
        String propertyName = "uuid";
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(propertyName, Person.class);
        Method readMethod = propertyDescriptor.getReadMethod();

        System.out.println("read uuid:"+readMethod.invoke(person, null));
        propertyDescriptor.getWriteMethod().invoke(person, "4130253332");
        System.out.println("read uuid:"+readMethod.invoke(person, null));
    }

    //2. 通过Introspector类获取Bean对象的BeanInfo,再通过BeanInfo来获取属性的描述器（PropertyDescriptor)
    public static void demo2() throws Exception{
        Person person = new Person("kaka", "41302499823", 22, true);
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
        for(PropertyDescriptor propertyDescriptor:beanInfo.getPropertyDescriptors()){
            System.out.println(propertyDescriptor.getReadMethod().invoke(person, null));
        }
        System.out.println("=========================");

        for(MethodDescriptor methodDescriptor:beanInfo.getMethodDescriptors()){
            String methodName = methodDescriptor.getMethod().getName();
            System.out.println(methodName);
            if(methodName.equals("test"))
                System.out.println(methodDescriptor.getMethod().invoke(person,null));
        }
    }

    //通过一些工具类来访问
    public static void demo3() throws Exception{
        //Person person = new Person("kaka", "41302499823", 22, true);
        BeanUtils.findDeclaredMethod(Person.class, "test", null).invoke(new Person());
    }
}

class Person{
    private String name;
    private String uuid;
    private Integer age;
    private boolean isMan;

    public Person() {
    }

    public Person(String name, String uuid, Integer age, boolean isMan) {
        this.name = name;
        this.uuid = uuid;
        this.age = age;
        this.isMan = isMan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void test(){
        System.out.println("test method");
    }
}
