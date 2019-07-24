package demo;

class myThread extends Thread{
    myThread(String name){
        this.setName(name);
    }
    @Override
    public void run(){
        System.out.println("ThreadName: " + Thread.currentThread().getName());
    }
}

public class multiThreadingDemo {
    public static void main(String[] args){
        myThread mth1 = new myThread("thread-A");
        myThread mth2 = new myThread("thread-B");
        myThread mth3 = new myThread("thread-C");
        myThread mth4 = new myThread("thread-D");
        myThread mth5 = new myThread("thread-E");
        mth1.start();
        mth2.start();
        mth3.start();
        mth4.start();
        mth5.start();
    }
}
