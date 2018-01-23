package concurrency.section2.捕获异常.demo2;

/**
 * @ Author: liuqianshun
 * @ Description: 定义任务
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
