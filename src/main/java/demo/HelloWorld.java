package demo;

import java.io.ByteArrayInputStream;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/19 上午8:53
 * @since 1.0
 */
public class HelloWorld {

    public static void main(String[] args){
        String str = "aaa,bbb";
        String[] buffer = str.split(",");
        System.out.println(buffer.length);


    }
}
