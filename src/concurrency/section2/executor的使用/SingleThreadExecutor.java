package concurrency.section2.executor的使用;

import concurrency.section2.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书658案例
 *
 * 向SingleThreadExecutor提交了多个任务的话,这些任务会排队,
 * 每个任务都会在下一个任务开始之前运行结束,所有的任务都将使用相同的线程
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
