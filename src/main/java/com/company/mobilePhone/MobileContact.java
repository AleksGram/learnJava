package com.company.mobilePhone;

import java.util.ArrayList;

/**
 * Created by Грам on 08.02.2017.
 */
public class MobileContact {
    private ArrayList<Contact> myContact;

    public MobileContact() {
        this.myContact = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Can't add, you already have" + " " + contact.getName() + " contact ");
            return false;
        }
        myContact.add(contact);
        return true;
    }

    private int findContact(Contact contact) {
        return this.myContact.indexOf(contact);
    }

    private int findContact(String name) {
        for (int i = 0; i < this.myContact.size(); i++) {
            Contact contact = this.myContact.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        if (findContact(oldContact) >= 0) {
            this.myContact.set(findContact(oldContact), newContact);
            System.out.println(oldContact.getName() + " " + oldContact.getPhoneNumber() + " was replaced " +
                    "\twith " + newContact.getName() + " " + newContact.getPhoneNumber());
            return true;
        }
        System.out.println("Can't find this contact ");
        return false;
    }

    public void removeContact(String contactName) {
        int indexOfcontact=findContact(contactName);
        if (indexOfcontact >= 0) {
            this.myContact.remove(indexOfcontact);
            System.out.println(contactName + " was removed ");
        }else
        System.out.println("Can't found this contact");

    }

    public boolean queryContact(String oldcontactName, String newContactName) {

        int indexOfContact = findContact(oldcontactName);
        if (indexOfContact >= 0) {

            Contact newContact = Contact.createContact(newContactName, myContact.get(indexOfContact).getPhoneNumber());
            myContact.set(indexOfContact, newContact);
            return true;
        }

        System.out.println("Can't find contact");

        return false;

    }

    public void printContacts() {
        for (int i = 0; i < myContact.size(); i++) {
            System.out.println((i + 1) + " " + myContact.get(i).getName() + " " + myContact.get(i).getPhoneNumber());
        }
    }

}
