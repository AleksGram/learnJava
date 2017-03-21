package com.useInterface;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
Car honda = new Car("Prelude",220, 200);
        System.out.println(honda.toString());
        savedObject(honda);

        honda.setHorsPower(250);
        System.out.println(honda);
        honda.setColor("white");
        savedObject(honda);
       // loadObject(honda);
        System.out.println(honda);

        IStorage yamaha = new Bike("Yr-Z", 120, 200);
        System.out.println("Max speed= "+((Bike) yamaha).getMaxSpeed());
        savedObject(yamaha);
        System.out.println(yamaha);


    }

    public static ArrayList<String> readValues(){
        ArrayList<String>values=new ArrayList<String>();

        Scanner scanner=new Scanner(System.in);
        boolean quite=false;
        int index=0;
        System.out.println("Choise\n+" +
                "1 to enter a string\n+" +
                "0 to quit");
        while (!quite){
            System.out.println("Choise the option: ");
            int choise = scanner.nextInt();
            scanner.nextLine();
            switch (choise){
                case 0:
                    quite=true;
                    break;
                case 1:
                    System.out.println("Enter a string" );
                    String stringInput = scanner.nextLine();
                    values.add(index,stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void savedObject(IStorage objectForSaving){
        for (int i=0;i<objectForSaving.store().size();i++){
            System.out.println("Saving... "+objectForSaving.store().get(i)+" to storage");
        }
    }

    public static void loadObject(IStorage objectForLoading){
        ArrayList<String> values = readValues();
        objectForLoading.read(values);
    }
}
