package demo;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface IntegerValue{
    int value() default 0;
    String name() default "";
}

public class annotationDemo {
    @IntegerValue(value = 20, name = "张三")
    public String name;
    public int value;

    public static void main(String[] args) {
        annotationDemo a = new annotationDemo();
        int num = a.value;
        System.out.println("num = " + num);
        System.out.println();
    }
    @Test public void test(){
        Assert.assertEquals(value, 20);
    }
}
