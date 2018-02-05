package enums.向enum中添加新方法;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书592案例
 *
 *
 * @ Date: Created in 2018-02-05
 * @ Modified:
 **/
public enum OzWitch {
    WEST("我是西"),
    NORTH("我是北"),
    EAST("我是东"),
    SOUTH("我是南"),;

    private String description;

    /**
     * 只能在enum内部创建enum实例.
     * 一旦enum的定义结束,编译器就不允许我们再使用构造器来创建任何实例
     */
    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * 覆盖toString()方法
     */
    public String toString() {
        String id = this.name();
        return id.charAt(0) + id.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        for (OzWitch o : OzWitch.values()) {
            System.out.println(o + ":" + o.getDescription());
        }
    }
}
