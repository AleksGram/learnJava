package com.sortedSet;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;


public class PartsList {
    private final Map<String, AutoPart> list;

    public PartsList() {
        this.list = new LinkedHashMap<>();
    }


    public int addParts(AutoPart part) {
        if (part != null) {
            AutoPart inStock = list.getOrDefault(part.getName(), part);
            if (inStock != part) {
                part.adjustQuantity(inStock.getAvaliablePartQuantity());
            }
            list.put(part.getName(), part);
            return part.getAvaliablePartQuantity();
        }
        return 0;
    }

    public int sellPart(String part, int quantity) {

        AutoPart inStock =list.get(part);
        if((inStock!=null)&&(quantity<0)){
            return inStock.finalisePart(quantity);
        }
        return 0;

      /*  AutoPart inStock = list.getOrDefault(part, null);
        if ((inStock != null)) {
            if ((inStock.getAvaliablePartQuantity() >= quantity) && (quantity > 0)) {
                inStock.adjustQuantity(-quantity);
                inStock.reaerveParts(-quantity);
                return quantity;
            }
        }
        return 0;*/
    }

    public int reservePart(String part, int quantity) {
        AutoPart inStock = list.get(part);
        if (inStock != null && quantity > 0) {
            return inStock.reaerveParts(quantity);
        }
        return 0;
    }

    public int unreservePart(String part, int quantity){
        AutoPart inStock = list.get(part);
        if (inStock != null && quantity > 0) {
            return inStock.unReservePart(quantity);
        }
        return 0;
    }

    public AutoPart get(String key) {
        return list.get(key);
    }

    public Map<String, AutoPart> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nPart List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, AutoPart> part : list.entrySet()) {
            AutoPart autoPart = part.getValue();
            double partValue = autoPart.getPrise() * autoPart.getAvaliablePartQuantity();

            s = s + autoPart + ". There are " + autoPart.getAvaliablePartQuantity() + " in stock. Value of parts: ";
            s = s + String.format("%.2f", partValue) + "."+"\n";
            totalCost += partValue;
        }
        return s + " Total stock value " + totalCost;
    }
}









