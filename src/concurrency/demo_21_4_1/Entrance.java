package concurrency.demo_21_4_1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书692案例
 *
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList();
    private int number = 0;
    private static volatile boolean canceled = false;
    private final int id;

    public Entrance(int id) {
        this.id = id;
        entrances.add(this);
    }

    public static void cancel() {
        canceled = true;
    }

    private synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "entrance " + id + ";" + getValue();
    }

    public static int getTotalCount(){
        return count.value();
    }

    public static int getTotalNum(){
        int num = 0;
        for(Entrance entrance :entrances){
            num += entrance.number;
        }
        return num;
    }

    @Override
    public void run() {
        while (!canceled) {
            number++;
            count.increment();
            System.out.println(this + " total: " + count.value());
        }
        System.out.println("Stopping " + this);
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        Thread.sleep(100);
        // 线程突然中断
        Entrance.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)){
            System.out.println("有些任务还没有结束!");
        }
        System.out.println("Total Count: " + getTotalCount());
        System.out.println("Total Number: " + getTotalNum());
    }
}
