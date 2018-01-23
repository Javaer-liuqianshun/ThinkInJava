package concurrency.section3.临界区;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-20
 * @ Modified:
 **/

/**
 *
 * 输出: pmp1: Pair: x=15, y=15 checkCount = 174
 *       pmp2: Pair: x=15, y=15 checkCount = 31357484
 *
 *     pmp2的checkCount > pmp1的checkCount说明pmp2的检查次数多余pmp1的检查次数,
 *     即:同步代码块 比 同步方法 的不加锁的时间长,所以推荐使用同步代码块(核心:同步方法synchroized关键字在this同步,
 *     同步代码块synchroized(this)也是在this同步,而AtomicInteger也是在this同步,同时只有一个任务进入该对象,
 *     所以checkout时间长的说明pc2的任务进入PairManager2对象时间长
 *     )
 *
 *
 *
 */
public class Main {
    static void test(PairManager pm1, PairManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();

        PairManipulator pmp2 = new PairManipulator(pm2),
                pmp1 = new PairManipulator(pm1);

        PairCheck pc2 = new PairCheck(pm2),
                pc1 = new PairCheck(pm1);

        exec.execute(pmp2);
        exec.execute(pmp1);
        exec.execute(pc2);
        exec.execute(pc1);

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }

        System.out.println("pmp1: " + pmp1 + "\npmp2: " + pmp2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pm1 = new PairManager1(),
                pm2 = new PairManager2();
        test(pm1,pm2);
    }
}
