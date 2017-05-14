package com.sortedSet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Basket {
    private final String name;
    private final Map<AutoPart, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list =new HashMap<>();
    }

    public int addToBasket(AutoPart part, int quantity){
        if((part!=null)&& (quantity>0)){
            int inBasket=list.getOrDefault(part, 0);
            list.put(part, inBasket+quantity);
            return inBasket;
            }
        return 0;
        }

        public Map<AutoPart, Integer> items(){
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
        return s + "Total cost " + totalCost;
    }

    }

