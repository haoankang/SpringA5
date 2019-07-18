package ank.hao.javassist;

import javassist.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavassistDemo {

    public static void main(String[] args) {
        try {
            makeNewClass();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static Class<?> makeNewClass() throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //获取ClassPool
        ClassPool pool = ClassPool.getDefault();
        //创建Student类
        CtClass ctClass = pool.makeClass("ank.hao.javassist.domain.Student");
        //创建Student类成员变量name
        CtField name = new CtField(pool.get("java.lang.String"),"name",ctClass);
        //设置name为私有
        name.setModifiers(Modifier.PRIVATE);
        //将name写入class
        ctClass.addField(name, CtField.Initializer.constant(""));
        //增加set方法，名字是setName
        ctClass.addMethod(CtNewMethod.setter("setName", name));
        //增加get方法，名字是getName
        ctClass.addMethod(CtNewMethod.getter("getName", name));
        //添加无参构造体
        CtConstructor cons = new CtConstructor(new CtClass[]{}, ctClass);
        cons.setBody("{name=\"ank.hao\";}");
        ctClass.addConstructor(cons);
        //添加有参构造体
        cons = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, ctClass);
        cons.setBody("{$0.name=$1;}");
        ctClass.addConstructor(cons);

        //反射调用新创建的类
        Class<?> aClass = ctClass.toClass();
        Object student = aClass.newInstance();
        Method getter = null;
        getter = student.getClass().getMethod("getName");
        System.out.println(getter.invoke(student));

        System.out.println("----------------------------");
        //调用setName
        Method setter = null;
        setter = student.getClass().getMethod("setName",java.lang.String.class);
        setter.invoke(student,"just test");

        System.out.println(getter.invoke(student));
        return null;
    }
}
