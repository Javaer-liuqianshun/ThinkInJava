package concurrency.section3.不正确的访问资源;

/**
 * @ Author: liuqianshun
 * @ Description:
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

}
