package io.section12.序列化的控制;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-02-04
 * @ Modified:
 **/
public class Blip1 implements Externalizable{
    public Blip1(){
        System.out.println("Blip1 constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal ");
    }
}
