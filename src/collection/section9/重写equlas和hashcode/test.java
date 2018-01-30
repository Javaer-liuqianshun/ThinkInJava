package collection.section9.重写equlas和hashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 验证SpringDetecor中的结论
 *
 * 控制台打印:
 *      {123=...}
 *   说明验证成功!
 *
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class test {
    public static void main(String[] args) {
        String s1 = new String("123");
        String s2 = new String("123");
        Map map = new HashMap();
        map.put(s1, "...");
        map.put(s2, "...");
        System.out.println(map);
    }
}
