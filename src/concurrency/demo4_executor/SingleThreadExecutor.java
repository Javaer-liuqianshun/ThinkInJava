package concurrency.demo4_executor;

import concurrency.demo1_runnable.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/

/**
 * 向SingleThreadExecutor提交了多个任务的话,这些任务会排队,
 * 每个任务都会在下一个任务开始之前运行结束,所有的任务都将使用相同的线程
 *
 *
 *
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
