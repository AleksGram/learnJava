package com.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by agra on 6/9/2017.
 */
public class DataObject extends NonSerializable implements Serializable {
    public int number = 5;
    public String name = "Alex";
    public transient String[] definitions;
    CustomeObject csObj = new CustomeObject();

//for getting field from nonSerializable parent class
// you should create next two methods
    private void writeObject(ObjectOutputStream out)throws IOException{
        out.defaultWriteObject();
        out.writeObject(getMyData());

    }


    private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        setMyData((String)in.readObject());


    }

}
