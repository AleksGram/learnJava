package com.serialize;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * Created by agra on 6/9/2017.
 */
public class Operations {
   static final  String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        System.out.println(PACKAGE);

        DataObject obj = new DataObject();
        obj.setMyData("Gramatik Aleksandr");
        obj.csObj.setHasCar(true);
        File file = new File("store.bin");
        File fileX = new File("my.xml");

        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);
        so.writeObject(obj);
        so.flush();
        so.close();



        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        DataObject objNew = (DataObject)si.readObject();
        si.close();
        System.out.println(objNew.myData);
        System.out.println(objNew.csObj.getHasCar());

        JAXBContext jc=
                JAXBContext.newInstance(PACKAGE);
        Marshaller m = jc.createMarshaller();
        Unmarshaller um = jc.createUnmarshaller();


        m.marshal("dataObj",fileX);
        DataObject objX = (DataObject) um.unmarshal(fileX);
    }
}
