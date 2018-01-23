package concurrency.section2.定义有返回值的任务.demo2;

import java.util.concurrent.Callable;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-16
 * @ Modified:
 **/
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
