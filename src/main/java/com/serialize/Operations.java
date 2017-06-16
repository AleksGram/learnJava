package com.serialize;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;


public class Operations {
    static final String PACKAGE = DataObject.class.getPackage().getName();

    public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {
        System.out.println(PACKAGE);

        DataObject obj = new DataObject();
        obj.setMyData("Gramatik Aleksandr");
        obj.csObj.setHasCar(true);
        File file = new File(".\\src\\main\\java\\com\\serialize\\store.bin");


        FileOutputStream fo = new FileOutputStream(file);
        ObjectOutputStream so = new ObjectOutputStream(fo);
        so.writeObject(obj);
        so.flush();
        so.close();


        FileInputStream fi = new FileInputStream(file);
        ObjectInputStream si = new ObjectInputStream(fi);
        DataObject objNew = (DataObject) si.readObject();
        si.close();
        System.out.println(objNew.myData);
        System.out.println(objNew.csObj.getHasCar());

<<<<<<< HEAD

       // Create JSON



        DataObject dataObject = new DataObject();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataObject);

        System.out.println(json);


        DataObject fromJson = gson.fromJson(json,DataObject.class);
        System.out.println(fromJson);

=======

        try {
            User myUser = new User("Mike", 11025);
            File xmlFile = new File(".\\src\\main\\java\\com\\serialize\\my.xml");
            myUser.setAge(25);
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxMarsaller = jaxbContext.createMarshaller();

            jaxMarsaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxMarsaller.marshal(myUser, xmlFile);
            jaxMarsaller.marshal(myUser, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
>>>>>>> 06f7ed47ce22a9f3d6951ed9fb4f9149cf7b7c51
    }
}
