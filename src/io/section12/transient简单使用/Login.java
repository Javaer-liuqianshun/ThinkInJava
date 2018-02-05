package io.section12.transient简单使用;

import java.io.*;
import java.util.Date;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书578案例
 *
 * 输出:
 *  login a = login info:
 *  username: liuqs
 *  date: Mon Feb 05 09:20:53 CST 2018
 *  password: 12345
 *  反序列化:
 *  login a =login info:
 *  username: liuqs
 *  date: Mon Feb 05 09:20:53 CST 2018
 *  password: null
 * 可以看出被transient关键字修饰的成员变量不会被序列化
 *
 * @ Date: Created in 2018-02-05
 * @ Modified:
 **/
public class Login implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "login info: \n username: " + username +
                "\n date: " + date + "\n password: " + password;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Login a = new Login("liuqs", "12345");
        System.out.println("login a = " + a);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\transient简单使用\\login.txt"));
        out.writeObject(a);
        out.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\idea Projects\\04\\thinkinjava_practice\\src\\io\\section12\\transient简单使用\\login.txt"));
        System.out.println("反序列化:");
        a = (Login) in.readObject();
        System.out.println("login a =" + a);
    }
}

