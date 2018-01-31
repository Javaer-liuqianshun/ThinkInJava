package concurrency.section9.比较各类互斥技术;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class BaseLine extends Accumulator {

    /** 构造代码块,每次调用构造方法时,优于构造方法执行 */ {
        id = "BaseLine";
    }

    @Override
    public void accumulate() {
        value += preLoaded[index++];
        if (index >= SIZE) index = 0;
    }

    @Override
    public long read() {
        return value;
    }
}
