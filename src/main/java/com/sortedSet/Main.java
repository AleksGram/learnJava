package com.sortedSet;

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

        temp = new AutoPart("Roots", 220, 1);
        partsList.addParts(temp);

        temp = new AutoPart("Air Filter", 11.2, 10);
        partsList.addParts(temp);

        System.out.println(partsList);

        for(String s: partsList.items().keySet()) {
            System.out.println(s);
        }
    }
}
