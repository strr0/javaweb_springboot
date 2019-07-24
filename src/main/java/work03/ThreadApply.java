package work03;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/23 上午10:40
 * @since 1.0
 */
public class ThreadApply {


    /**
     * 线程的常用场景demo2  为ThreadApply的升级版
     * 大家想想，这么做的目的是什么
     * 这个场景非常经典，大家要熟悉这个应用
     *
     */

    public BlockingQueue<String> blockingQueue =new LinkedBlockingQueue<String>(500);




    @Test
    public void ThreadTest1(){

        Thread t1 = new Thread (new Thread1("Thread1"));
        t1.start();


        Thread2 t2 = new Thread2("Thread3");
        t2.start();

        //暂停很长时间，模拟程序在运行
        try {
            while (true){
                Thread.sleep(1000);
            }
        }catch (Exception e){
            System.out.println(e);
        }


    }




    /**
     * 内部类  线程的实现方式1  实现Runnable 接口
     * 消费队列数据
     * 把这个想象成往服务端或者写数据库
     */
    class Thread1 implements Runnable {
        private String name;

        public Thread1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true){
                try {
                    String str = blockingQueue.poll(5, TimeUnit.MILLISECONDS);
                    if (str != null) {
                        //System.out.println("Name: " + Thread.currentThread().getName());
                        doSomeThink(str);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    /**
     * 内部类  线程的实现方式2  继承Thread类
     * 往队列里面放数据
     * 把这个想象成单个用户上传东西，或者发送离线消息
     */
    class Thread2 extends Thread{
        private String name;

        private  Random random=new Random();

        public Thread2(String name) {
            this.name=name;
        }
        @Override
        public void run() {
            while (true){
                try {
                    //注意这个put 和offer 的区别，核心要素
                    blockingQueue.offer(random.nextInt(100)+"");
                    //System.out.println("Name: " + Thread.currentThread().getName());
                    Thread.sleep(100);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    private void doSomeThink(String str){
        System.out.println(str);
    }






}
