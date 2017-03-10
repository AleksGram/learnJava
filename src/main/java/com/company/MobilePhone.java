package com.company;

/**
 * Created by Грам on 07.02.2017.
 */
public class MobilePhone extends Contacts {


    Contacts contact = new Contacts();
    int choise = 0;
    boolean quite = false;
    public void contactMenu() {
        System.out.println(" Contact book ");
        while (!quite) {
            printInstructions();
            choise = scan.nextInt();
            scan.nextLine();
            if(!(choise>1&&choise<=5)){
                System.out.println("plese make your choise: ");
            }
            switch (choise) {
                case 1:
                    contact.printContacts();
                    break;
                case 2:
                    contact.addContact();
                    break;
                case 3:
                    contact.updateContact();
                    break;
                case 4:
                    contact.removeContact();
                    break;
                case 5:
                    System.out.println("Exit from menu");
                    quite = true;
                    break;

            }


        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 1 - To print the list of the contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update contact.");
        System.out.println("\t 4 - To remove contact.");
        System.out.println("\t 5 - To quit the application.");
    }
}
