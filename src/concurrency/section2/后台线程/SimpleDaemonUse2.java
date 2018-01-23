package concurrency.section2.后台线程;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/

import java.util.concurrent.ThreadFactory;

/**
 * 使用ThreadFactory定制由Executor创建线程的属性
 *
 *
 *
 *
 */
public class SimpleDaemonUse2 implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
