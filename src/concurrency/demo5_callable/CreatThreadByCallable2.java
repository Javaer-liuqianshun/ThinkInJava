package concurrency.demo5_callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class CreatThreadByCallable2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 创建Future的集合
        ArrayList<Future<String>> results = new ArrayList<>();
        // 创建10个FutureTask对象
        for (int i = 0;i<10;i++){
            Future<String> submit = exec.submit(new MyCallable());
            results.add(submit);
        }
        // 遍历future集合
        for (Future<String> future:results){
            System.out.println(future.get());
        }
        exec.shutdown();
    }
}
