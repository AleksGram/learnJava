package com.serialize;


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
        File file = new File("store.bin");


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


        try {
            User myUser = new User("Mike");
            File xmlFile = new File("my.xml");
            myUser.setAge(25);
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller jaxMarsaller = jaxbContext.createMarshaller();

            jaxMarsaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxMarsaller.marshal(myUser, xmlFile);
            jaxMarsaller.marshal(myUser, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
