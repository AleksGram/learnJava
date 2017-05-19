package com.sortedSet;

/**
 * Created by Грам on 13.05.2017.
 */
public class AutoPart implements Comparable<AutoPart> {
    //check git repository
     private final String name;
    private double prise;
    private int quantityPart;
    private int reserveParts;

    public AutoPart(String name, double prise) {
        this.name = name;
        this.prise = prise;
        this.quantityPart =0;
        this.reserveParts=0;
    }

    public AutoPart(String name, double prise, int quantityPart) {
        this.name = name;
        this.prise = prise;
        this.quantityPart =quantityPart;
    }

    public String getName() {
        return name;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getQuantityPart() {
        return quantityPart;
    }

    public int getReserveParts() {
        return reserveParts;
    }

    public void adjustQuantity(int quantity) {
        int newQuantity=this.quantityPart + quantity;
        if(newQuantity>=0){
            this.quantityPart=newQuantity;
        }
    }

    public void adjustReaerveParts(int quantity) {
        int newReserve=this.reserveParts + quantity;
        if(newReserve>=0&&newReserve<=this.getQuantityPart()){
            this.reserveParts=newReserve;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this){
            return true;
        }
        if((obj==null)||(obj.getClass()!=this.getClass())){
            return false;
        }
        String objName = ((AutoPart)obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(AutoPart o) {
        System.out.println("Comparing.....");
        if(this==o){
            return 0;
        }
        if(o!=null){
            return this.name.compareTo(o.getName());
        }
        throw new  NullPointerException();

    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+31;
    }

    @Override
    public String toString() {
        return this.name +" price: "+this.prise;
    }
}
