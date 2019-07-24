package demo;

import java.lang.annotation.*;
import java.util.Arrays;

//注解测试一
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

//注解测试二
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue{
    int value() default 0;
    String name() default "";
}

@IntegerValue(value = 20, name = "jack")
public class annotationDemo {
    public static void main(String[] args) {

        /*A instanceA = new B();
        System.out.println("已使用的@Inherited注解:"+ Arrays.toString(instanceA.getClass().getAnnotations()));
        C instanceC = new D();
        System.out.println("没有使用的@Inherited注解:"+Arrays.toString(instanceC.getClass().getAnnotations()));*/

        boolean hasAnnotation = annotationDemo.class.isAnnotationPresent(IntegerValue.class);
        if ( hasAnnotation ) {
            IntegerValue testAnnotation = annotationDemo.class.getAnnotation(IntegerValue.class);
            System.out.println("value:"+testAnnotation.value());
            System.out.println("name:"+testAnnotation.name());
        }
    }

}
