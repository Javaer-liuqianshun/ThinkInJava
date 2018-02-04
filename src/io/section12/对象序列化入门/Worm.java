package io.section12.对象序列化入门;

import java.io.*;
import java.util.Random;

/**
 * @ Author: liuqianshun
 * @ Description:
 * <p>
 * 书573案例
 * @ Date: Created in 2018-02-04
 * @ Modified:
 **/
public class Worm implements Serializable{
    private Random rand = new Random(47);
    private Data[] d = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };
    private Worm next;
    private char c;

    public Worm(int i, char x) {
        System.out.println("Worm construtor: " + i);
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }

    public Worm() {
        System.out.println("Default construtor");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(":");
        result.append(c);
        result.append("(");
        for (Data data : d) {
            result.append(data);
        }
        result.append(")");
        if (next != null) {
            result.append(next);
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm(6,'a');
        System.out.println("worm = " + worm);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\对象序列化入门\\out.txt"));
        out.writeObject("Worm storage\n");
        out.writeObject(worm);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\对象序列化入门\\out.txt"));
        String s  = (String) in.readObject();
        Worm w = (Worm) in.readObject();
        System.out.println(s + "worm = " + w);


        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        out2.writeObject("Worm storage\n");
        out2.writeObject(w);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        Worm w2 = (Worm) in2.readObject();
        System.out.println(s + "worm2 = " + w2);


    }
}
