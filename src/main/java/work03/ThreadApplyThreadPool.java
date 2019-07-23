package work03;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 这是一个类说明
 *
 * @author 冯东宝 (dongbao.feng@ucarinc.com)
 * @date 2019/7/23 上午10:40
 * @since 1.0
 */
public class ThreadApplyThreadPool {


    /**
     * 线程的常用场景demo1
     * 大家想想，这么做的目的是什么
     * 这个场景非常经典，大家要熟悉这个应用
     *
     *
     */


    /**
     * 思考下，为什么是这个队列，别的队列可以不可以？依据是什么？
     */
    public BlockingQueue<String> blockingQueue =new LinkedBlockingQueue<String>(500);

    /**
     * 要非常熟悉这几个参数的作用，以及他们的发生顺序
     */
    private final ThreadPoolExecutor  productPool =  new ThreadPoolExecutor(
            5,
            20,
            60L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(50));



    @Test
    public void ThreadTest1(){

        //生产和消费，谁先开始，无关紧要
        Thread consume = new Thread (new Thread1("Thread1"));
        consume.start();



        try {
            /**  模拟多个用户一直访问,2019年07月23日的作业
             *   问题1 运行该方法后，去理解哪个线程代表生产能力，他的生产能力是多少
             *   问题2 哪个线程代表了消费能力，他的消费能力是多少
             *   问题3 为什么运行10多秒后，会抛出异常 java.util.concurrent.RejectedExecutionException
             *   问题4 在问题3的基础上，去解释，整个线程池的几个参数作用，以及他的核心流程
             *   问题5 当在开发中，遇到了这种问题（把他假设成一个线上问题，那么你应该去如何优化他，如何做抉择）
             *   问题6 阐述下Queue 中put和offer 的区别？put代表了什么业务意义，offer代表了什么业务意义，既什么情况下用put，什么情况下用offer？
             *   问题7 为什么选择了LinkedBlockingQueue？其他队列不行吗？
             *
             */


            while (true){
                productPool.execute(new Thread2("Thread3"));
                Thread.sleep(100);
            }
        }catch (Exception e){
            System.out.println(e);
        }



    }




    /**
     * 内部类  线程的实现方式1  实现Runnable 接口
     * 消费队列数据
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
     * 一个线程产生100条数据
     */
    class Thread2 extends Thread{
        private String name;

        private  Random random=new Random();

        public Thread2(String name) {
            this.name=name;
        }
        @Override
        public void run() {
            try {
                for(int i=0;i<10;i++){
                    //注意这个put 和offer 的区别，核心要素
                  blockingQueue.put(random.nextInt(10)+"");

                }
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }

    private void doSomeThink(String str){
        try {
            System.out.println(str);
            //模拟写入数据库或者上传服务器，需要100毫秒，代表了服务器处理的能力
            Thread.sleep(100);
        }catch (Exception e){
            System.out.println(e);
        }

    }






}
