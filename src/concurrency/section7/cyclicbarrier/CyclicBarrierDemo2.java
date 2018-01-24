package concurrency.section7.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * new CyclicBarrier(int parties,Runnable barrierAction)
 * parties:指让parties个线程在进行下一个步骤之前等待
 * barrierAction:当这些线程都达到下一个步骤之前会执行的内容,会从parties个线程中选择一个线程去执行Runnable.
 *
 *  结果:
 *       线程Thread-0正在写入数据...
 *       线程Thread-3正在写入数据...
 *       线程Thread-1正在写入数据...
 *       线程Thread-2正在写入数据...
 *       线程Thread-3写入数据完毕，等待其他线程写入完毕
 *       线程Thread-2写入数据完毕，等待其他线程写入完毕
 *       线程Thread-0写入数据完毕，等待其他线程写入完毕
 *       线程Thread-1写入数据完毕，等待其他线程写入完毕
 *       当前线程Thread-1
 *       所有线程写入完毕，继续处理其他任务...
 *       所有线程写入完毕，继续处理其他任务...
 *       所有线程写入完毕，继续处理其他任务...
 *       所有线程写入完毕，继续处理其他任务...
 * @ Date: Created in 2018-01-23
 * @ Modified:
 **/
public class CyclicBarrierDemo2 {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier  = new CyclicBarrier(N,new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程"+Thread.currentThread().getName());
            }
        });

        for(int i=0;i<N;i++)
            new Writer(barrier).start();
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
