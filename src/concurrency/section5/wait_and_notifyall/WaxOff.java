package concurrency.section5.wait_and_notifyall;

import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("抛光!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Wax Off ---->  退出");
        }
        System.out.println("抛光结束");
    }
}
