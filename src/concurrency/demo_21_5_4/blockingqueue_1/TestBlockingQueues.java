package concurrency.demo_21_5_4.blockingqueue_1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书p714案例
 *
 * BlockingQueue及其子类都是线程安全的
 *
 *
 * @ Date: Created in 2018-01-22
 * @ Modified:
 **/
public class TestBlockingQueues {
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String message) {
        System.out.println(message);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();
        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getkey("Press 'Enter' (" + msg + ")");
        t.interrupt();
        System.out.println("Finished" + msg + "test");
    }

    public static void main(String[] args) {
        // 没有限制大小
        test("LinkedBlockingQueue",new LinkedBlockingDeque<LiftOff>());
        // 固定大小
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        // 大小为1
        test("SynchronousQueue",new SynchronousQueue<>());
    }
}
