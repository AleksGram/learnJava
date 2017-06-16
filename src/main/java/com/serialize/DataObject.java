package com.serialize;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class DataObject extends NonSerializable implements Serializable {


    private int number = 5;

    private String name = "Alex";

    private transient String[] definitions;
    CustomeObject csObj = new CustomeObject();

    //for getting field from nonSerializable parent class
// you should create next two methods
    private void writeObject(ObjectOutputStream out) throws IOException {


        out.defaultWriteObject();  //should call always
        out.writeObject(getMyData());

    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();  //should call always
        setMyData((String) in.readObject());


    }

}
