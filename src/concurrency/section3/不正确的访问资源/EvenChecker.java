package concurrency.section3.不正确的访问资源;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书674案例
 *
 * 此案例说明: 一个任务可能在另一个任务执行第一个对currentEventValue的递增操作后,没有执行剩下的递增操作,调用next(),
 *              那么获得的value就不是 7 的倍数了,这就是并发编程面临的最大问题 ----->资源共享
 *
 *
 * 并发编程需要解决: 多个任务访问相同的资源,至少在关键阶段不能出现这种情况
 *
 *
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        this.generator = g;
        this.id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int value = generator.next();
            if (value % 7 != 0) {
                System.out.println(value + " 不是7的倍数,关闭7的倍数产生!");
                generator.cancel();
            }
        }
    }

    /**
     * 测试各种类型的IntGenerator
     *
     * @param generator
     * @param ident
     */
    public static void test(IntGenerator generator, int ident) {
        ExecutorService exec = null;
        for (int i = 0; i < ident; i++) {
            exec = Executors.newCachedThreadPool();
            exec.execute(new EvenChecker(generator, i));
        }
        exec.shutdown();
    }

    /**
     * 指定ident
     *
     * @param generator
     */
    public static void test(IntGenerator generator) {
        test(generator, 100);
    }


    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
