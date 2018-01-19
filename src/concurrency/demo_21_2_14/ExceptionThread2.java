package concurrency.demo_21_2_14;

/**
 * @ Author: liuqianshun
 * @ Description: 使用ThreadFactory定制异常属性 由Executor创建线程的属性
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ExceptionThread2 implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by" + t);
        System.out.println("eh: " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
