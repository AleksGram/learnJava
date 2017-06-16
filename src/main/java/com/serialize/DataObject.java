package com.serialize;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

<<<<<<< HEAD


>>>>>>> 06f7ed47ce22a9f3d6951ed9fb4f9149cf7b7c51
public class DataObject extends NonSerializable implements Serializable {


    private int number = 5;

    private String name = "Alex";

    private transient   String[] definitions;
    CustomeObject csObj = new CustomeObject();

//for getting field from nonSerializable parent class
// you should create next two methods
    private void writeObject(ObjectOutputStream out)throws IOException{
<<<<<<< HEAD

=======
        out.defaultWriteObject();  //should call always
        out.writeObject(getMyData());
>>>>>>> 06f7ed47ce22a9f3d6951ed9fb4f9149cf7b7c51

    }


    private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException{
<<<<<<< HEAD

=======
        in.defaultReadObject();  //should call always
       setMyData((String)in.readObject());
>>>>>>> 06f7ed47ce22a9f3d6951ed9fb4f9149cf7b7c51


    }

}
