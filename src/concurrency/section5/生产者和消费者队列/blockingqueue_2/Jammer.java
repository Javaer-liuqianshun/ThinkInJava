package concurrency.section5.生产者和消费者队列.blockingqueue_2;

/**
 * @ Author: liuqianshun
 * @ Description:涂果酱
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Jammer implements Runnable {
    private ToastQueue bufferedQueue, finishQueue;

    public Jammer(ToastQueue bufferedQueue, ToastQueue finishQueue) {
        this.bufferedQueue = bufferedQueue;
        this.finishQueue = finishQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = bufferedQueue.take();
                // 涂果酱
                take.jam();
                finishQueue.put(take);
            }
        } catch (InterruptedException e) {
            System.out.println("Jammer Interrupted!");
        }
        System.out.println("Jammer off");
    }
}
