package concurrency.section7.cyclicbarrier.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description: 模拟赛马
 *
 * 书724案例
 *
 *  在HorseRace会先执行for()循环创建nHorses个线程,
 *  每个线程执行完Horse中的任务时都调用CyclicBarrier.await()挂起,
 *  当这些线程都执行完后,会随机一个线程执行new CyclicBarrier()中的new Runnable(),
 *  当new Runnable()后没有到达线程结束条件,这些线程又会执行Horse中的任务(如此循环),直到退出
 *
 * @ Date: Created in 2018-01-24
 * @ Modified:
 **/
public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<>();
    ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(int nHorses, final int pause) {
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < FINISH_LINE; i++) {
                    s.append("=");
                }
                System.out.println(s.toString());
                for (Horse horse : horses) {
                    System.out.println(horse.tracks());
                }
                for (Horse horse : horses) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won!");
                        exec.shutdownNow();
                        return;
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(pause);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        for (int i = 0; i < nHorses; i++) {
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 20;
        new HorseRace(nHorses, pause);
    }
}
