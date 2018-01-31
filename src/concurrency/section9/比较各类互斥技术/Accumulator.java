package concurrency.section9.比较各类互斥技术;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public abstract class Accumulator {
    public static long cycles = 50000L;
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected static final int SIZE = 100000;
    protected static int[] preLoaded = new int[SIZE];

    static {
        Random rand = new Random(47);
        for (int i = 0; i < SIZE; i++) {
            preLoaded[i] = rand.nextInt();
        }
    }

    public abstract void accumulate();

    public abstract long read();


    private class Modifier implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
            }
            try {
                barrier.wait();
            } catch (Exception e) {

            }
        }
    }

    private class Reader implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                value = read();
            }
            try {
                barrier.wait();
            } catch (Exception e) {

            }
        }
    }

    public void timeTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }
        try {
            barrier.wait();
        } catch (Exception e) {

        }
        duration = System.nanoTime() - start;
        System.out.println(id + ":" + duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println(acc1.id + "/" + acc2.id + "---->" + df.format((double) acc1.duration / (double) acc2.duration));
    }

}
