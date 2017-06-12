package com.serialize;

import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
// .NONE - save only elements marked by annotation
// .FIELD - all non static and non-transient fields
// .PROPERTY - all getter-setter pairs and fields marked by annotation
// .PUBLIC - all public getter-setter pairs and fields and marked by annotation

@XmlType(name = "dataObj")
public class DataObject extends NonSerializable implements Serializable {
    @XmlElement
    private int number = 5;
    @XmlElement
    private String name = "Alex";

    private transient String[] definitions;
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
