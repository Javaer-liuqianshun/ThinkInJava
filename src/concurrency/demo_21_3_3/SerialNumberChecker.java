package concurrency.demo_21_3_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author: liuqianshun
 * @ Description:序列数检查器
 *
 * 书683案例
 *
 * 思考:
 *      产生序列数的SerialNumberGenerator.nextSerialNumber()方法,每次都是产生一个序列数,
 *      并且CicularSet的add()方法被synchronized关键字修饰,每次只让一个线程添加元素,为什么序列数会重复?
 *
 *      原因:
 *          在SerialNumberGenerator中的 ++serialNumber不是原子操作,使用volatile并不能保证它具有原子性
 *          比如:线程A从主内存中读取serialNumber.虽然volatile具有可见性,但是因为未修改值,所有不会去修改主内存中的值,
 *              线程B从主内存中读取还是原来的序列数,最后两个线程产生的序列数是一样的,
 *      解决办法:
 *          SerialNumberGenerator.nextSerialNumber()使用synchronized关键字修饰
 *
 *
 *
 * @ Date: Created in 2018-01-19
 * @ Modified:
 **/
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet circularSet = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();


    static class SerialChecker implements  Runnable{
        @Override
        public void run() {
            while (true){
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (circularSet.contains(serial)){
                    System.out.println("序列数重复了: " + serial);
                    System.exit(0);
                }
                circularSet.add(serial);
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<SIZE;i++){
            exec.execute(new SerialChecker());
        }
        exec.shutdown();
    }
}
