package concurrency.section2.定义有返回值的任务.demo1;

/**
 * @ Author: liuqianshun
 * @ Description:Callable创建线程
 *
 *
 * Callable接口和Runnable接口的区别: 实现Callable的方式创建线程能返回一个值
 *
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThreadByCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "aaaa";
            }
        });
        for (int i = 0;i<5;i++){
            // FutureTask也是继承Runnable的
            Thread thread = new Thread(ft);
            thread.start();
            // 通过FutureTask的get方法获取返回值
            String result = ft.get();
            System.out.println(thread.getName());
            System.out.println(result);
        }

    }
}
