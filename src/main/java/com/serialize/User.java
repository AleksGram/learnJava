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

    public User() {}

    public User(String name) {
        this.name = name;

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
