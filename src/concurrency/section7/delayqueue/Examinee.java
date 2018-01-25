package concurrency.section7.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-25
 * @ Modified:
 **/
public class Examinee implements Delayed{

    private int id;
    private String name;
    private long submitTime;

    public Examinee(int id) {
        this.id = id;
        this.name = "考生-" + id;
        this.submitTime = Exam.EXAM_DEADLINE;
    }

    public void submit(){
        long current = System.currentTimeMillis();
        if(current >= Exam.EXAM_MIN_TIME){
            submitTime = current;
        }else{
            long cost = TimeUnit.SECONDS.convert(current-Exam.EXAM_START,TimeUnit.MILLISECONDS);
            System.err.print("考试时间没有超过30分钟， ["+name+"] 不能交卷, 考试用时: "+cost);
        }
    }

    public int getId(){
        return id;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delayMills = submitTime - System.currentTimeMillis();
        return unit.convert(delayMills, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int)(getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    public String toString(){
        long current = System.currentTimeMillis();
        long cost = TimeUnit.SECONDS.convert(current - Exam.EXAM_START, TimeUnit.MILLISECONDS);
        return name+" 在已经提交试卷, 考试耗时： "+cost;
    }
}
