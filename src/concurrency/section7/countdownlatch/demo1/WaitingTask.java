package concurrency.section7.countdownlatch.demo1;

import java.util.concurrent.CountDownLatch;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class WaitingTask implements Runnable {

    private CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 该任务被挂起,需要CountDownLatch中指定的任务数量被执行完才被唤醒
            latch.await();
            System.out.println("countDownLatch中的任务已经被执行完了,WaitingTask任务被唤醒");
        }catch (InterruptedException e) {
        }
    }
}
