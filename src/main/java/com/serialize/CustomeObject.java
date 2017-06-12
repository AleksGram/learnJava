package com.serialize;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
@XmlType(name ="customeObj")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomeObject implements Externalizable  {
    //Externalizible - all information about your classes is not written
    //executed only your write read methods
    public transient boolean hasCar = false;

    public boolean getHasCar() {
        return hasCar;
    }



    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
       out.writeBoolean(getHasCar());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
       setHasCar(in.readBoolean());

    }
}