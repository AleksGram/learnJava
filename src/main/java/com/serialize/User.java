package com.serialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.security.AccessController;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class User {
    String name;
    int age;

    @XmlAttribute
    int userID;

    public User() {}

    public User(String name, int userID) {
        this.name = name;
        this.userID=userID;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name : "+this.name+" is already "+this.age+" years old"+
                "\n"+this.name+"s ID => "+this.userID ;
    }
}
