package demo;

class People<N, S, A>{
    private N name;
    private S sex;
    private A age;
    public People(){}
    public People(N name, S sex, A age){
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public void setName(N name) {
        this.name = name;
    }
    public N getName() {
        return name;
    }
    public void setSex(S sex) {
        this.sex = sex;
    }
    public S getSex() {
        return sex;
    }
    public void setAge(A age) {
        this.age = age;
    }
    public A getAge() {
        return age;
    }
}

public class genericityDemo {
    public static void main(String[] args) {
        //printData("hello world!");
        //System.out.println(maxData(new String[] {"hello", "world", "!"}));
        People people = new People("Jack", "male", 30);
        printData(people.getName());
        printData(people.getSex());
        printData(people.getAge());
    }

    //输出数据
    static <T> void printData(T data){
        System.out.println(data);
    }
    //返回数组中的最大项
    static <R extends Comparable<R>> R maxData(R[] nums){
        R max = nums[0];
        for(R num : nums){
            if(num.compareTo(max) > 0)
                max = num;
        }
        return max;
    }
}
