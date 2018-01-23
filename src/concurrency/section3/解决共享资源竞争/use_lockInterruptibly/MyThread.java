package concurrency.section3.解决共享资源竞争.use_lockInterruptibly;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-18
 * @ Modified:
 **/
public class MyThread extends Thread {
    private Test test = null;

    public MyThread(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"被中断");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Test test = new Test();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        /**
         *
         * 当通过lockInterruptibly()方法获取某个锁时，如果不能获取到，只有进行等待的情况下，是可以响应中断的。
         *
         * 用synchronized修饰的话，当一个线程处于等待某个锁的状态，是无法被中断的，只有一直等待下去。
         *
         */
        thread2.interrupt();
    }
}
