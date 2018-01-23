package concurrency.section2.捕获异常.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书673案例
 *
 * 使用ThreadFactory定制 由Executors创建线程的属性,
 * 在ThreadFactory中设置线程捕获器为 Thread.UncaughtExceptionHandler
 *
 *  这么在线程执行过程中 因为异常未捕获临近死亡之前 会调用Thread.UncaughtExceptionHandler.uncaughtException()方法
 *  在uncaughtException()进行操作
 *
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ExceptionThread2Main {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new ExceptionThread2HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
        exec.shutdown();
    }
}
