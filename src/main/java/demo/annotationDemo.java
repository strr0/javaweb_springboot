package demo;

import java.lang.annotation.*;
import java.util.Arrays;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface annotationA{}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface annotationB{}

@annotationA
class A{}
class B extends A{}
@annotationB
class C{}
class D extends C{}

public class annotationDemo {

    public static void main(String[] args) {
        A instanceA = new B();
        System.out.println("已使用的@Inherited注解:"+ Arrays.toString(instanceA.getClass().getAnnotations()));
        C instanceC = new D();
        System.out.println("没有使用的@Inherited注解:"+Arrays.toString(instanceC.getClass().getAnnotations()));
    }




}
