package collection.section9.覆盖hashcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书497案例
 *
 * hashCode()覆盖基本指导:
 * 1.给int变量result赋予某个非零常量
 * 2.为对象内每个有意义的域f计算出一个int散列码
 * 3.合并计算得到的散列码 result = 37*result + c
 * 4.返回result
 * 5.检查hashCode()最后生成的结果,确保相同的对象有相同的散列码
 *
 * @ Date: Created in 2018-01-31
 * @ Modified:
 **/
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        created.add(s);
        for (String s2 : created) {
            if (s2.equals(s)) {
                id++;
            }
        }
    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof CountedString && s.equals(((CountedString) o).s) && id == ((CountedString) o).id;
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString csString : cs) {
            System.out.println("Looking up:" + csString);
            System.out.println(map.get(csString));
        }
    }
}
