package concurrency.section7.countdownlatch.demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书723案例
 *
 * CountDownLatch使用:
 *      CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。
 *      比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class CountDownLatchDemo {
    private static final int SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0;i<SIZE;i++){
            exec.execute(new TaskPortion(latch));
        }
        exec.execute(new WaitingTask(latch));
        TimeUnit.SECONDS.sleep(5);
        System.out.println("所有任务执行完了!");
        exec.shutdown();
    }
}
