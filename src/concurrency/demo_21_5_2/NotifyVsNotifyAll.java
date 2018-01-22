package concurrency.demo_21_5_2;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书707案例
 *
 * 说明 notify()只能唤醒一个被挂起等待的线程,而notifyAll()可以唤醒所有被挂起等待的线程
 *      并且notifyAll()也只能唤醒和被挂起线程 锁 一致的线程
 *
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod){
                    System.out.print("\nnotify() ");
                    Task.blocker.prod();
                    prod = false;
                }else{
                    System.out.print("\nnotifyAll() ");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\ntimer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Task2.blocker.prodAll()");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("Shutting down");
        exec.shutdownNow();
    }
}
