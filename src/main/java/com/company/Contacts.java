package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Грам on 06.02.2017.
 */
public class Contacts   {
    public static Scanner scan = new Scanner(System.in);
    ArrayList<String> contacts = new ArrayList<String>();

    protected String addContact() {
        System.out.println("Type new contact: ");
        String newContact = scan.nextLine();
        boolean nameExist = true;
        while (nameExist) {
            if (contacts.contains(newContact)) {
                System.out.println("You already have such contact, please change the name:");
                newContact = scan.nextLine();
            } else {
                nameExist = false;
                contacts.add(newContact);
            }
        }
        return newContact;
    }

    public void printContacts() {
        System.out.println("You have " + (contacts.size()) + " contacts:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + " " + contacts.get(i));
        }
    }

    public void removeContact() {
        System.out.println("whom you want to remove? ");
        String removeContact = scan.nextLine();
        if (!contacts.contains(removeContact)) {
            System.out.println("You haven't such contact ");
        }else{
            System.out.println("You'd removed: "+ removeContact);
            contacts.remove(removeContact);

            }

        }

        public int findContactIndex(String searchContact){
        return contacts.indexOf(searchContact);
           }

           public void updateContact(){
            int contactIndex;
               System.out.println("what of the contact  modify: ");
               String modifiedContact=scan.nextLine();
               contactIndex=findContactIndex(modifiedContact);
               if (contactIndex>=0){
               System.out.println("How modify ? ");
               String newContact=scan.nextLine();
                   contacts.set(contactIndex, newContact);
               }
               System.out.println("Can't find this contact2" );

           }

    }


