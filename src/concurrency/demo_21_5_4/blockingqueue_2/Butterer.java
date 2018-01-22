package concurrency.demo_21_5_4.blockingqueue_2;

/**
 * @ Author: liuqianshun
 * @ Description:抹黄油
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Butterer implements Runnable {
    private ToastQueue dryQueue, bufferedQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue bufferedQueue) {
        this.dryQueue = dryQueue;
        this.bufferedQueue = bufferedQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = dryQueue.take();
                // 摸黄油
                take.butter();
                bufferedQueue.put(take);
            }
        } catch (InterruptedException e) {
            System.out.println("Butterer Interrupted!");
        }
        System.out.println("Butterer off");
    }
}
