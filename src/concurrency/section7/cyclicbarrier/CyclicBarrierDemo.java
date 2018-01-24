package concurrency.section7.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * CyclicBarrier对象可以实现一组线程等待至某个状态后再全部同时执行
 *
 * 结果:
 *        线程Thread-3正在写入数据...
 *        线程Thread-2正在写入数据...
 *        线程Thread-1写入数据完成.
 *        线程Thread-2写入数据完成.
 *        线程Thread-3写入数据完成.
 *        线程Thread-0写入数据完成.
 *        所有线程写入完毕,继续处理其他任务...
 *        所有线程写入完毕,继续处理其他任务...
 *        所有线程写入完毕,继续处理其他任务...
 *        所有线程写入完毕,继续处理其他任务...
 * 说明:每个线程写入完成后,等待其他线程写入完成,当4个线程(一组线程)都写入完成后,所有线程继续后续操作.
 *
 *
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class CyclicBarrierDemo {
    /* 指定一组线程大小为4 */
    private static final int N = 4;

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4);
        for (int i = 0; i < N; i++) {
            new Write(cb).start();
        }
    }

    static class Write extends Thread{
        private CyclicBarrier cb;
        public Write(CyclicBarrier cb){
            this.cb = cb;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
                Thread.sleep(5000);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完成.");
                cb.await();
                System.out.println("所有线程写入完毕,继续处理其他任务...");
            }catch (InterruptedException e){

            } catch (BrokenBarrierException e) {

            }
        }
    }
}

