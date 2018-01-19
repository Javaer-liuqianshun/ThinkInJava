package concurrency.demo_21_2_14;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * Thread.UncaughtExceptionHandler.uncaughtException()会在线程因未捕获的异常而临近死亡时候被调用
 *
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class ExceptionThread2MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("捕获异常为: " + e);
    }
}
