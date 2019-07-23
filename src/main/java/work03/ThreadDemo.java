package work03;

import org.junit.Test;


/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/23 上午10:40
 * @since 1.0
 */
public class ThreadDemo {


    /**
     * 线程的常用场景，核心理念？
     * 1.异步操作，解耦，不影响主线程的整体进程，可以快速返回结果。
     * 2.提高资源的利用率（cpu和内存），在资源充足、场景合理的前提下，开启多线程操作，可达到更快速的处理。
     * 3.后台定时任务，不同任务间各自启动线程处理
     *
     *
     *
     */


    /**
     * demo1 常规使用方式  实现Runnable 接口
     */
    @Test
    public void ThreadTest1(){
        Thread t1 = new Thread (new Thread1("Thread1"));
        Thread t2 = new Thread (new Thread1("Thread2"));
        Thread t3 = new Thread (new Thread1("Thread3"));

        t1.start();
        t2.start();



        t3.start();

        try {
            //暂停的是当前线程,既ThreadTest1  ，也就是说，不是暂停 t1 t2 t3
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        }catch (Exception e){

        }


    }



    /**
     * demo1 常规使用方式  实现Runnable 接口
     */
    @Test
    public void ThreadTest2(){
        Thread2 t1 = new Thread2("Thread1");
        Thread2 t2 = new Thread2("Thread2");
        Thread2 t3 = new Thread2("Thread3");
        t1.start();
        t2.start();
        t3.start();


    }



    /**
     * 内部类  线程的实现方式1  实现Runnable 接口
     */
    class Thread1 implements Runnable {
        private String name;

        public Thread1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + " : " + i);
            }
        }
    }

    /**
     * 内部类  线程的实现方式2  继承Thread类
     */
    class Thread2 extends Thread{
        private String name;

        public Thread2(String name) {
            this.name=name;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : " + i);
            }

        }
    }



}
