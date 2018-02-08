package enums.验证values的存在;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书594案例
 *
 * 用反射机制 验证values()方法在创建的Explore类是存在的
 *
 * 打印结果:
 * -----Analyzing class enums.验证values的存在.Explore
 * Interfaces:
 * Base: class java.lang.Enum
 * Methods:
 * [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, values, wait]
 * -----Analyzing class java.lang.Enum
 * Interfaces:
 * java.lang.Comparable<E>
 * interface java.io.Serializable
 * Base: class java.lang.Object
 * Methods:
 * [compareTo, equals, getClass, getDeclaringClass, hashCode, name, notify, notifyAll, ordinal, toString, valueOf, wait]
 * Explore.containsAll(Enum)? true
 * Explore.remove(Enum):[values]
 * 可以看出Explore类中多了一个values()方法,values是由编译器添加的static方法
 * @ Date: Created in 2018-02-08
 * @ Modified:
 **/
public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("-----Analyzing " + enumClass);
        System.out.println("Interfaces: ");
        for (Type type : enumClass.getGenericInterfaces()) {
            System.out.println(type);
        }
        System.out.println("Base: " + enumClass.getSuperclass());
        System.out.println("Methods: ");
        TreeSet<String> methods = new TreeSet<>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.print("Explore.removeAll(Enum):");
        exploreMethods.removeAll(enumMethods);
        System.out.println(exploreMethods);
    }
}
