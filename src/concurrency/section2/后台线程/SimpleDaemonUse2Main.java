package concurrency.section2.后台线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class SimpleDaemonUse2Main implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("sleep() interrupted!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new SimpleDaemonUse2());
        for (int i = 0;i<5;i++){
            exec.execute(new SimpleDaemonUse2Main());
        }
        exec.shutdown();
        Thread.sleep(250);
        System.out.println("所有后台线程结束");
    }
}
