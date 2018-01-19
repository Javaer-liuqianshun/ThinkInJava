package concurrency.demo_21_3_1;

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
 *
 *
 * @ Date: Created in 2018-01-17
 * @ Modified:
 **/
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;// 危险代码
        ++currentEvenValue;
        ++currentEvenValue;
        // 线程调度 ---- 使获取7倍数的方法快速失败
        Thread.yield();
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
