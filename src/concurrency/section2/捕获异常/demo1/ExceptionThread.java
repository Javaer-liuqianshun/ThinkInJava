package concurrency.section2.捕获异常.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description: 线程抛出异常(run方法发生异常)
 *
 * 书672案例
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        /**
         * 控制台打印错误信息
         * Exception in thread "pool-1-thread-1" java.lang.RuntimeException
         *      at com.liuqs.chapter21_concurrency.ExceptionThread.run(ExceptionThread.java:18)
         *      at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
         *      at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
         *      at java.lang.Thread.run(Thread.java:748)
         */
        /*
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
        exec.shutdown();
        */

        /**
         * 使用try_catch捕获异常
         *
         * 控制台打印出错误信息,说明不能捕获从线程中抛出的异常
         *
         * Exception in thread "pool-1-thread-1" java.lang.RuntimeException
         *      at com.liuqs.chapter21_concurrency.ExceptionThread.run(ExceptionThread.java:19)
         *      at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
         *      at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
         *      at java.lang.Thread.run(Thread.java:748)
         *
         */
        ExecutorService exec = null;
        try {
            exec= Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (RuntimeException e){
            System.out.println("Exception has been handled!");
        }finally {
            exec.shutdown();
        }
    }
}
