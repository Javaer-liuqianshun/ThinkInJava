package concurrency.section7.delayqueue.demo1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 当把一个对象put进入DelayQueue会自动调用对象的compareTo()方法,然后按延时时间进行排序
 *
 * 当调用take()方法时,会取出队列中延时最小的对象
 *
 * @ Date: Created in 2018-01-25
 * @ Modified:
 **/
public class Exam {
    // 考试开始时间
    public static long EXAM_START = System.currentTimeMillis();
    // 考试时间120秒(为了方便模拟)
    public static long EXAM_DEADLINE = EXAM_START + 120*1000L;
    // 最早交卷时间30秒
    public static long EXAM_MIN_TIME = EXAM_START + 30*1000L;

    // 考场总人数
    private static final int EXAMINEE_NUM = 20;

    private DelayQueue<Examinee> examinees = new DelayQueue<>();
    private Map<Integer, Examinee> map = new ConcurrentHashMap<>(EXAMINEE_NUM*3/2);
    private int submitCount;


    public Exam(){
        for(int i=1; i<=EXAMINEE_NUM; i++){
            Examinee e = new Examinee(i);
            examinees.put(e);
            map.put(i, e);
        }
    }

    public void examining() throws InterruptedException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = new Date(EXAM_START);
        Date end = new Date(EXAM_DEADLINE);
        System.out.println("====> 考试开始 ["+format.format(start)+"] ...");

        // 25 分钟以后
        TimeUnit.SECONDS.sleep(25);

        while(System.currentTimeMillis() <= EXAM_DEADLINE ){
            someoneSubmit();
            TimeUnit.SECONDS.sleep(2);
            System.out.println("--------------- time past 2 seconds -------");

            List<Examinee> submitted = new LinkedList<>();
            examinees.drainTo(submitted);
            for(Examinee e: submitted){
                System.out.println(e);
            }

            submitCount += submitted.size();
            if(submitCount >= EXAMINEE_NUM){
                break;
            }
        }

        System.out.println("====> 考试结束 ["+format.format(end)+"] ...");
    }

    void someoneSubmit(){
        int num = new Random().nextInt(EXAMINEE_NUM)+1;
        map.get(num).submit();
    }

    public static void main(String[] args){
        try {
            new Exam().examining();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
