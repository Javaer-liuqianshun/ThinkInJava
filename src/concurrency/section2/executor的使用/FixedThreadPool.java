package concurrency.section2.executor的使用;

import concurrency.section2.定义任务.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书657案例
 *
 * 创建有限的线程集
 * 有了FixedThreadPool,就可以一次性预先执行高昂的线程分配,也就可以限制线程的数量
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }

}
