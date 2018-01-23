package concurrency.section3.临界区;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/
public class PairManager1 extends PairManager {
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
