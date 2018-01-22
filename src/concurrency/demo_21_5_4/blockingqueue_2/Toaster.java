package concurrency.demo_21_5_4.blockingqueue_2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description: 制作吐司
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Toaster implements Runnable{

    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
                // Make Toast
                Toast toast = new Toast(count++);
                toastQueue.put(toast);
            }
        }catch (InterruptedException e){
            System.out.println("Toaster Interrupted!");
        }
        System.out.println("Toaster off");
    }
}
