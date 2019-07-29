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
     * 这个场景非常经，大家要熟悉这个应用：生产者--消费者
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
             *        Thread2 代表生产力，它的生产力是每100毫秒生成10个数据（随机数字）
             *        ps：这里整个productPool和blockingQueue（上面33行的那个），不能代表生产力和消费力，是代表了缓冲能力
             *
             *   问题2 哪个线程代表了消费能力，他的消费能力是多少
             *        Thread1 代表了消费能力，它的消费能力是每100毫秒处理一个数据
             *
             *   问题3 为什么运行10多秒后，会抛出异常 java.util.concurrent.RejectedExecutionException
             *        因为线程池的队列满了（workQueue=50）&&已达到设置的最大线程数 (maximumPoolSize=20,这个20是包含corePoolSize的),
             *        说明已达缓冲上限，理论上workQueue或者maximumPoolSize设置的足够大，是可以无限缓冲的，但是实际情况是不可能的，大家可以百度下内存溢出（OOM）。
             *
             *   问题4 在问题3的基础上，去解释，整个线程池的几个参数作用，以及他的核心流程
             *         步骤1.corePoolSize  线程池的核心线程数，当任务开始时候，在线程数小于等于此值的时候，会一直创建线程
             *         步骤2.workQueue   在线程达到了corePoolSize之后，会往缓冲队列里面放，这是要注意一个地方：队列的大小
             *              2.1 首先内存是有上限的，常规虚拟机就几个G，一个空线程，大概是一两M，因此这个上限，设置个几百就很大了
             *              2.2 队列分为有界队列和无界队列  （LinkedBlockingQueue 可有界可无界）
             *                  2.2.1 有界 ArrayBlockingQueue   还有SynchronousQueue为特殊有界队列，队列大小为1，既最多存储一个任务
             *                  2.2.2 无界 ConcurrentLinkedQueue PriorityBlockingQueue DelayedQueue
             *                  相关文章： https://blog.csdn.net/u012240455/article/details/81844007
             *              为什么要提有界无界队列呢？这涉及到一个线上常遇见的问题，就是内存溢出（OOM），当使用有界队列并且忘了设置队列大小，
             *              使用了默认值或者选择了无界队列，那么很有可能会造成大量堆积任务，导致资源耗尽，根本走不到步骤3。
             *         步骤3：当workQueue达到上限之后，会开始直接创建线程，直到线程达到maximumPoolSize，此时会执行拒绝策略。
             *         keepAliveTime 线程空闲存活时间， TimeUnit 空闲存活时间单位  理论上这两是完整参与所有步骤，当线程空闲达到指定时，既按照此参数销毁线程
             *
             *   问题5 当在开发中，遇到了这种问题（把他假设成一个线上问题，那么你应该去如何优化他，如何做抉择）
             *        快速分辨问题出本质，把问题划分为两个方向：
             *        一、代码已经优化程度非常高，瞬间流量爆发导致的
             *           解决方案：1.最简单有效的方案，加机器，加内存，过后，回收机器
             *                    2.开启限流，既把问题中的put修改为offer（只是个类比，实际方案会更复杂），抛弃部分流量，保证机器存活，能提供服务
             *        二、公司发展，业务量上来了，以前量小扛得住，现在流量大了扛不住
             *           解决方案：1.还是加机器，但是不是无限制的加机器，还是要做优化的
             *                    2.本质是提高Thread1的能力，既消费处理能力，使他的处理能力不是100毫秒，尽量去优化
             *                    2.2 优化的方案大致分为几种：
             *                        2.2.1 上redis等缓存中间件，使其更快获取关键数据
             *                        2.2.2 上MQ，kafka等外部队列，增加缓冲能力
             *                        2.2.3 优化SQL，增加数据库查询能力
             *                        2.2.4 项目解耦，把一个接口拆分成多个小接口
             *                        2.2.5 优化具体代码，这个比较冗长，不累赘
             *
             *   问题6 阐述下Queue 中put和offer 的区别？put代表了什么业务意义，offer代表了什么业务意义，既什么情况下用put，什么情况下用offer？
             *         在机器自由充足，队列长度够长的情况下，用put，会导致抛出异常，抛出异常不是什么坏事，可以快速觉察出问题。
             *         资源紧张，队列很小时候，用offer，意味着稳定限流
             *
             *   问题7 为什么选择了LinkedBlockingQueue？其他队列不行吗？
             *        可能我问题描述的有点歧义，我一开始想问33行的那个LinkedBlockingQueue，但是好多同学都是回答ThreadPoolExecutor中的那个workQueue，
             *        但是无所谓，主要是想让同学了解队列相关的知识点，阻塞队列，性能方面。
             *         ArrayBlockingQueue 性能上是优于LinkedBlockingQueue
             *         关于具体选择哪个？由于阻塞队列都是线程安全的，所以，其他的任意阻塞队列，都是可以的。
             *         相关文章 https://www.jianshu.com/p/4028efdbfc35
             *         拓展知识点：（92行提到的是什么东西？）
             *         本文章讨论到的都是内部队列，但是有一种中间件，叫外部队列，相关文章。
             *         https://www.jianshu.com/p/b36dc684864f
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
