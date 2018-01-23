package concurrency.section5.wait_and_notifyall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书704案例
 *
 * 调用wait()时,线程被挂起,而锁被释放
 * notifyAll()唤醒对wait()调用中被挂机的任务
 *
 *
 * 流程:
 *      先执行抛光任务,进入后等待打蜡,该线程被挂起,锁被释放,
 *      然后会执行打蜡任务,执行完打蜡后唤醒之前被挂起的线程并等待抛光,该线程被挂起,锁被释放
 *      之前抛光任务呗唤醒,进入抛光.
 *
 *
 *
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Car {
    /**
     * 打蜡标识, false未打蜡,true已打蜡
     */
    private boolean waxOn = false;

    /**
     * 给汽车打蜡
     */
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    /**
     * 给汽车抛光
     */
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    /**
     * 等待打蜡
     */
    public synchronized void waitForWaxing() throws InterruptedException {
        while (waxOn == false) wait();
    }

    /**
     * 等待抛光
     */
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn == true) wait();
    }

    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
    }
}
