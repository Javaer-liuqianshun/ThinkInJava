package concurrency.section7.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class TaskPortion implements Runnable {

    private Random rand = new Random(47);
    // 创建CountDownLatch对象
    private CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            doWork();
            // 等待任务减1
            latch.countDown();
        }catch (InterruptedException e){

        }
    }

    private void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "工作完毕");
    }
}
