package concurrency.demo_21_5_4.blockingqueue_1;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-12
 * @ Modified:
 **/
public class LiftOff implements Runnable{
    private int countDown = 10;
    private static int taskCount = 0;
    private final int targetInstance = taskCount ++;

    public LiftOff(){

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status(){
        return "#"+targetInstance +"("+ (countDown>0?countDown:"liftoff")+"),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            status();
            Thread.yield();
        }
    }

}
