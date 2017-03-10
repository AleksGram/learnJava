package com.company;

import com.company.mobilePhone.Contact;
import com.company.mobilePhone.MobileContact;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MobileContact mobile = new MobileContact();

    public static void main(String[] args) {

             /* MyArray arr = new MyArray();
        int[] arrBeforeSort = arr.getArray(4);
        arr.showArray(arrBeforeSort);
        int[]arrAfterSort=arr.descendingSortArray(arrBeforeSort);
        arr.showArray(arrAfterSort);*/


      /*  ArrayList<String>list=new ArrayList<String>();
        for(int i =0; i<5; i++) {
            contact.addContact();
        }
              contact.printContacts();
        contact.renameContact();
        contact.printContacts();
*/
     /*   MobilePhone phone = new MobilePhone();
       phone.contactMenu();*/

        boolean quit = false;
        phoneMenu();
        while (!quit) {

            int action = scan.nextInt();
            scan.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Menu's closed ");
                    quit = true;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    renameContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    phoneMenu();
                    break;

            }
        }
    }

    private static void addContact() {
        System.out.println("Type a name of the new contact ");
        String newContactName = scan.nextLine();
        System.out.println("Type the number of the new contact");
        int newContactNumber = scan.nextInt();
        scan.nextLine();
        Contact newContact = Contact.createContact(newContactName, newContactNumber);
        if (mobile.addNewContact(newContact)) {
            System.out.println(newContact.getName() + " " + newContact.getPhoneNumber() + " was added ");
        }
    }

    private static void renameContact() {
        System.out.println("Enter the contact which  you have to update:");
        String oldName = scan.nextLine();
        System.out.println("Enter the new name");
        String newName = scan.nextLine();
        if (mobile.queryContact(oldName, newName) == true) {
            System.out.println("You'd updated " + oldName + " to " + newName);
        }
    }

    private static void removeContact() {
        System.out.println("Which contact do you want to remove?");
        String removeName=scan.nextLine();
        mobile.removeContact(removeName);
    }


    private static void printContacts() {
        System.out.println("Your contacts: ");
        mobile.printContacts();
    }

    private static void phoneMenu() {
        System.out.println("Phone menu");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to rename an existing contact\n" +
                "4  - to remove an existing contact\n"+
                "5  - to show the menu option\n");
        System.out.println("Choose your action: ");
    }


}


