package com.sortedSet;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;


public class Basket {
    private final String name;
    private final Map<AutoPart, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(AutoPart part, int quantity) {
        if ((part != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(part, 0);
            list.put(part, inBasket + quantity);
            part.reaerveParts((inBasket + quantity));
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(AutoPart part, int quantity) {
        if ((part != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(part, 0);
            int newQuantity = inBasket + quantity;
            if (newQuantity > 0) {
                list.put(part, newQuantity);
                return newQuantity;
            } else if (newQuantity == 0) {
                list.remove(part);
                return quantity;
            }
        }
        System.out.println("No such quantity in basket");
        return 0;
    }

    public void cleanBasket(){
        this.list.clear();
    }

    public Map<AutoPart, Integer> items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " parts\n";
        double totalCost = 0.0;
        for (Map.Entry<AutoPart, Integer> part : list.entrySet()) {
            s = s + part.getKey() + ". " + part.getValue() + " purchased\n";
            totalCost += part.getKey().getPrise() * part.getValue();
        }
        return s + "Total cost " + String.format("%.2f", totalCost);
    }

}

