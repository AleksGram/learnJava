package com.sortedSet;

import java.util.Map;

/**
 * Created by Грам on 14.05.2017.
 */
public class Main {
    private static PartsList partsList = new PartsList();

    public static void main(String[] args) {
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

        Basket myBasket =new Basket("My basket");


         sell(myBasket,"Roots", 1);
       sell(myBasket,"Roots", 1);
        sell(myBasket,"Valve", 23);
        sell(myBasket,"Turbo", 4);
        sell(myBasket,"Turbo", 1);
        sell(myBasket,"Pistone", 10);
        sell(myBasket,"Air Filter", 10);
        sell(myBasket,"Verto", 5);


        System.out.println(myBasket);

        System.out.println(partsList);

  // Invoke UnsupportedOperation Exception

       /*  temp=new AutoPart("Turbo",23);
        partsList.items().put(temp.getName(),temp);
        System.out.println(partsList);*/

// Outputing names of the parts

        /*   for (String s : partsList.items().keySet()) {
            System.out.println(s);
        }*/
    }


    public static int sell(Basket basket, String autoPart, int quantity) {
        AutoPart part = partsList.get(autoPart);
        if (part == null) {
            System.out.println("The " + autoPart + " is absent in stock");
            return 0;
        }
        if (partsList.reservePart(autoPart, quantity) > 0) {
            return basket.addToBasket(part,quantity);

        }
        System.out.println("No more "+autoPart+ " in stock");
        return 0;

    }

    public static int removePart(Basket basket, String autoPart, int quantity) {
        AutoPart part = partsList.get(autoPart);
        if (part == null) {
            System.out.println("The " + autoPart + " is absent in stock");
            return 0;
        }
        if (basket.removeFromBasket(part, quantity) == quantity) {
            return partsList.unreservePart(autoPart,quantity);
        }
        return 0;

    }

    public static void checkOut(Basket basket){
        for(Map.Entry<AutoPart,Integer> item: basket.items().entrySet()){
            partsList.sellPart(item.getKey().getName(),item.getValue());
        }
        basket.cleanBasket();
    }
}