package concurrency.section7.delayqueue.demo2;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书726案例
 *
 * 结果:
 *      11 的延时时间: 128
 *      7 的延时时间: 200
 *      5 的延时时间: 429
 *      18 的延时时间: 520
 *      1 的延时时间: 555
 *      4 的延时时间: 961
 *      16 的延时时间: 998
 *      9 的延时时间: 1207
 *      2 的延时时间: 1693
 *      14 的延时时间: 1809
 *      3 的延时时间: 1861
 *      15 的延时时间: 2278
 *      10 的延时时间: 3288
 *      12 的延时时间: 3551
 *      0 的延时时间: 4258
 *      19 的延时时间: 4258
 *      8 的延时时间: 4522
 *      13 的延时时间: 4589
 *      17 的延时时间: 4861
 *      6 的延时时间: 4868
 *      EndSentinel Calling showdownNow()
 *      DelayTaskConsumer任务结束
 *  说明 delayQueue 具有延时执行任务的功能,并会先取延时最小的任务
 *
 *
 *
 *
 * @ Date: Created in 2018-01-26
 * @ Modified:
 **/
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayTask> q) {
        this.q = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("DelayTaskConsumer任务结束");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayTask(rand.nextInt(5000)));
        }
        queue.put(new DelayTask.EndSentinel(5000,exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
