package concurrency.demo_21_3_3;

/**
 * @ Author: liuqianshun
 * @ Description: 序列数生成器
 * @ Date: Created in 2018-01-19
 * @ Modified:
 **/
public class SerialNumberGenerator {
    private static /*volatile*/ int serialNumber = 0;
    /*
    public static  int nextSerialNumber(){
        return ++serialNumber;
    }
    */
    public static synchronized int nextSerialNumber(){
        return ++serialNumber;
    }
}
