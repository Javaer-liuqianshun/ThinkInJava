package concurrency.section2.executor的使用;

import concurrency.section2.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书656案例
 *
 * CachedThreadPool()为每个任务都创建一个线程
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0;i<5;i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
