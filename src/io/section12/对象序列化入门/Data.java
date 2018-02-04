package io.section12.对象序列化入门;

import java.io.Serializable;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-02-04
 * @ Modified:
 **/
public class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
