package collection.section9.重写equlas和hashcode;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书490案例
 *
 * 思考:
 *  为什么java编程要求重写equals()一定要重写hashcode()
 *  原因: 因为如果创建一个对象,只重写了equals,如果放入Map或者Set集合中,会调用对象默认父类Object的hashcode(),
 *      那么Map或者Set集合中的键即使对象内容都一致,但是由于对象地址不一样,生成的hashcode()会不一样.
 *      hashcode()一样后会调用equals()
 *
 *      如: String s1 = new String("123")
 *          String s2 = new String("123")
 *          Map  map = new HashMap();
 *          map.put(s1,"...")
 *          map.put(s2,"...")
 *          如果不重写hashcode,那么s1,s2调用Object的hashcode()方法,hashcode不一样,所以保存两个k-v对象
 *          如果重写hashcode(return "123");返回的值都为"123"
 *          hashcode()相等会调用equals()去比较两个对象值是否相等,如果相等,
 *          那么只会保存一个k-v对象
 *
 *
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class SpringDetecor {
    public static <T extends Groundhog2> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> hog = type.getConstructor(int.class);
        Map<Groundhog2, Prediction> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(hog.newInstance(i),new Prediction());
        }
        System.out.println("map = " + map);
        Groundhog2 gh = hog.newInstance(3);
        System.out.println("Looking up prediction for " + gh);
        if (map.containsKey(gh))
            System.out.println(map.get(gh));
        else
            System.out.println("Key not found: " + gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog2.class);
    }
}
