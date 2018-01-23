package concurrency.section2.捕获异常.demo2;

import java.util.concurrent.ThreadFactory;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 定制 由Executors创建线程的属性
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ExceptionThread2HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this.getClass().getName() + " 准备创建新线程");
        Thread t = new Thread(r);
        System.out.println("新线程已创建: " + t);
        t.setUncaughtExceptionHandler(new ExceptionThread2MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}
