package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student{
    private String name;
    private String sex;
    private int age;
    public Student(){}
    public Student(String name, String sex, int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

public class reflectDemo {
    public static void main(String[] args){
        Class student = Student.class;
        Constructor[] constructors = student.getDeclaredConstructors();
        for(int i = 0; i < constructors.length; i++){
            Constructor con = constructors[i];
            System.out.println("构造方法" + i);
            System.out.println("参数类型: ");
            Class[] para = con.getParameterTypes();
            for(int j = 0; j < para.length; j++){
                System.out.println(para[j]);
            }
            System.out.println();
        }
        Method[] methods = student.getDeclaredMethods();
        for(int i = 0; i < methods.length; i++){
            Method met = methods[i];
            System.out.println("方法名: " + met.getName());
            System.out.println("返回类型: " + met.getReturnType());
            System.out.println("参数类型: ");
            Class[] type = met.getParameterTypes();
            for(int j = 0; j < type.length; j++){
                System.out.println(type[j]);
            }
            System.out.println();
        }
        Field[] fields = student.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            System.out.println("成员名: " + fields[i].getName());
            System.out.println("成员类型: " + fields[i].getType());
            System.out.println();
        }
    }
}