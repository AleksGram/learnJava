package com.sortedSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Грам on 14.05.2017.
 */
public class Main {
    private static PartsList partsList = new PartsList();

    public static void main(String[] args) throws IOException {
        AutoPart temp = new AutoPart("Wheel", 100, 4);
        partsList.addParts(temp);

        temp = new AutoPart("Pistone", 48.5, 16);
        partsList.addParts(temp);

        temp = new AutoPart("Valve", 12.1, 32);
        partsList.addParts(temp);

        temp = new AutoPart("Brake Disk", 125.5, 8);
        partsList.addParts(temp);

        temp = new AutoPart("Turbo", 150, 1);
        partsList.addParts(temp);
        temp = new AutoPart("Turbo", 150, 3);
        partsList.addParts(temp);

        temp = new AutoPart("Roots", 220, 1);
        partsList.addParts(temp);

        temp = new AutoPart("Air Filter", 11.2, 10);
        partsList.addParts(temp);

        AutoPart engine = new AutoPart("Engine", 500);
        partsList.addParts(engine);

        Basket myBasket = new Basket("My basket");
        String homePath="D:\\учеба\\My project\\learnJava\\src\\main\\java\\com\\sortedSet\\part.txt";
        String workPath="C:\\Users\\agra\\IdeaProjects\\learnJava\\src\\main\\java\\com\\sortedSet\\basket.txt";

        try (FileWriter locFile = new FileWriter(workPath);
        FileWriter baskFile =new FileWriter(workPath)) {
            locFile.write(partsList.toString());
            baskFile.write(myBasket.toString()+"" +"\n");
        }



        FileWriter locFile = null;
        try {
            locFile = new FileWriter("D:\\учеба\\My project\\learnJava\\src\\main\\java\\com\\sortedSet\\part.txt");
            locFile.write(partsList.items().entrySet().toString() + "\n");

        } catch (IOException e) {
            System.out.println("In the cathc block");
            e.printStackTrace();
        } finally {
            System.out.println("in finally block");
            try {
                if(locFile!=null) {
                    System.out.println("closing locFile");
                    locFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        sell(myBasket, "Roots", 3);
        sell(myBasket, "Valve", 23);
        sell(myBasket, "Turbo", 4);
        sell(myBasket, "Turbo", 1);
        sell(myBasket, "Pistone", 10);
        sell(myBasket, "Air Filter", 10);
        sell(myBasket, "Verto", 5);

        System.out.println(myBasket);

        System.out.println(partsList);

        checkOut(myBasket);

        System.out.println(myBasket);

        // Invoke UnsupportedOperation Exception

       /*  temp=new AutoPart("Turbo",23);
        partsList.items().put(temp.getName(),temp);
        System.out.println(partsList);*/

// Outputing names of the parts

        /*   for (String s : partsList.items().keySet()) {
            System.out.println(s);
        }*/
        try(Scanner scanner = new Scanner(new BufferedReader(new FileReader(workPath)))){
            scanner.useDelimiter(":");
            while (scanner.hasNext()){
                String name = scanner.next();
               scanner.skip(scanner.delimiter());
               String name2 = scanner.nextLine();

                System.out.println(name+": "+"=> "+name2);
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }




    public static int sell(Basket basket, String autoPart, int quantity) {
        AutoPart part = partsList.get(autoPart);
        if (part == null) {
            System.out.println("The " + autoPart + " is absent in stock");
            return 0;
        }
        if (partsList.reservePart(autoPart, quantity) > 0) {
            return basket.addToBasket(part, quantity);

        }
        System.out.println("No such quantity " + autoPart + " in stock");
        return 0;

    }

    public static int removePart(Basket basket, String autoPart, int quantity) {
        AutoPart part = partsList.get(autoPart);
        if (part == null) {
            System.out.println("The " + autoPart + " is absent in stock");
            return 0;
        }
        if (basket.removeFromBasket(part, quantity) == quantity) {
            return partsList.unreservePart(autoPart, quantity);
        }
        return 0;

    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<AutoPart, Integer> item : basket.items().entrySet()) {
            partsList.sellPart(item.getKey().getName(), item.getValue());
        }
        basket.cleanBasket();
    }


}
