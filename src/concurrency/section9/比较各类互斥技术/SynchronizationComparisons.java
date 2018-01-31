package concurrency.section9.比较各类互斥技术;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synch = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();

    static void test() {
        System.out.println("=================================");
        System.out.println("Cycles: " + Accumulator.cycles);
        baseLine.timeTest();
        synch.timeTest();
        lock.timeTest();
        atomic.timeTest();
        Accumulator.report(synch,baseLine);
        Accumulator.report(lock,baseLine);
        Accumulator.report(atomic,baseLine);
        Accumulator.report(synch,lock);
        Accumulator.report(synch,atomic);
        Accumulator.report(lock,atomic);
    }

    public static void main(String[] args) {
        int iterations= 5;
        System.out.println("Warmup");
        baseLine.timeTest();
        for (int i=0;i<iterations;i++){
            test();
            Accumulator.cycles *= 2;
        }
        Accumulator.exec.shutdownNow();
    }
}
