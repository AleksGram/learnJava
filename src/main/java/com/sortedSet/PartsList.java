package com.sortedSet;



import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class PartsList {
    private final Map<String, AutoPart> list;

    public PartsList() {
        this.list=new LinkedHashMap<>();
    }

    public int addParts(AutoPart part){
        if(part!=null){
            AutoPart inStock=list.getOrDefault(part.getName(), part);
            if(inStock!=part){
                part.adjustQuantity(inStock.getQuantityPart());
            }
            list.put(part.getName(), part);
            return part.getQuantityPart();
        }
        return 0;
    }

    public int sellPart(String part, int quantity){
        AutoPart inStock=list.getOrDefault(part,null);
            if ((inStock != null)) {
                if ((inStock.getQuantityPart() >= quantity) && (quantity > 0)) {
                    inStock.adjustQuantity(-quantity);
                    return quantity;
                }
            }
            return 0;
        }

    public AutoPart get(String key){
        return list.get(key);
    }
    public Map<String, AutoPart> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s="\nPart List\n";
        double totalCost=0.0;
        for(Map.Entry<String, AutoPart> part:list.entrySet()){
            AutoPart autoPart=part.getValue();
            double partValue=autoPart.getPrise()*autoPart.getQuantityPart();

            s=s+autoPart+". There are "+autoPart.getQuantityPart()+" in stock. Value of parts: ";
            s=s+String.format("%.2f",partValue)+"\n";
            totalCost += partValue;
        }
        return s+" Total stock value "+ totalCost;
    }
}









