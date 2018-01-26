package concurrency.section7.delayqueue.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-26
 * @ Modified:
 **/
public class DelayTask implements Delayed {
    private static int counter = 0;
    private final int id = counter++;
    // 延时时间
    private final long delayTime;
    // 结束时间
    private final long endTime;

    private static List<DelayTask> queue = new ArrayList<>();

    public DelayTask(long delayTime) {
        this.delayTime = delayTime;
        /**
         * 例如:
         * TimeUtil.SECONDS.covert(1L,TimeUnit.MINUTES)意思是将1分钟转换成秒
         */
        endTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS);
        queue.add(this);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(endTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayTask that = (DelayTask) o;
        if (endTime < that.endTime) return -1;
        if (endTime > that.endTime) return 1;
        return 0;
    }

    public void run() {
        System.out.println(this + "");
    }

    public String toString() {
        return id + " 的延时时间: " + delayTime;
    }

    /**
     * 用于关闭所有任务
     */
    public static class EndSentinel extends DelayTask {
        ExecutorService exec;

        EndSentinel(long delay, ExecutorService exec) {
            super(delay);
            this.exec = exec;
        }

        public void run() {
            System.out.println("EndSentinel Calling showdownNow()");
            exec.shutdownNow();
        }
    }

}
