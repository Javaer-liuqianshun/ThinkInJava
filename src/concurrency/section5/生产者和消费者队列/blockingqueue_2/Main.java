package concurrency.section5.生产者和消费者队列.blockingqueue_2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue dryQueue = new ToastQueue(),
                buttererQueue = new ToastQueue(),
                finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, buttererQueue));
        exec.execute(new Jammer(buttererQueue, finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
