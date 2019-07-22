package demo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/19 上午8:53
 * @since 1.0
 */
class myComparator implements Comparator<String>{
    @Override
    public int compare(String s1, String s2){
        return s2.compareTo(s1);
    }
}
public class HelloWorld {

    public static void main(String[] args){
        Set<String> s1 = new HashSet<String>();
        s1.add("a");
        s1.add("c");
        s1.add("b");
        System.out.println(s1);
    }
}
