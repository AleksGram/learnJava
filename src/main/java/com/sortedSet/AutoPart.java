package com.sortedSet;

/**
 * Created by Грам on 13.05.2017.
 */
public class AutoPart implements Comparable<AutoPart> {
    //check git repository
    private final String name;
    private double prise;
    private int partQuantity;
    private int partReserve;

    public AutoPart(String name, double prise) {
        this.name = name;
        this.prise = prise;
        this.partQuantity = 0;
        this.partReserve = 0;
    }

    public AutoPart(String name, double prise, int quantityPart) {
        this.name = name;
        this.prise = prise;
        this.partQuantity = quantityPart;
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

    public int getAvaliablePartQuantity() {
        return partQuantity - partReserve;
    }

    public int getPartReserve() {
        return partReserve;
    }

    public void adjustQuantity(int quantity) {
        int newQuantity = this.partQuantity + quantity;
        if (newQuantity >= 0) {
            this.partQuantity = newQuantity;
        }
    }

    public int reaerveParts(int quantity) {
        if (quantity <= this.getAvaliablePartQuantity()) {
            this.partReserve += quantity;
            return quantity;
        }
        return 0;
    }

    public int unReservePart(int quantity) {
        if (quantity <= this.partReserve) {
            this.partReserve -= quantity;
            return quantity;
        }
        System.out.println("You hadn't reserved " + quantity);
        return 0;
    }

    public int finalisePart(int quantity) {
        if (quantity <= partReserve) {
            partQuantity -= quantity;
            partReserve -= quantity;
            return quantity;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((AutoPart) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int compareTo(AutoPart o) {
        System.out.println("Comparing.....");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException();

    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public String toString() {
        return this.name + " price: " + this.prise + "  Reserved " + this.partReserve;
    }
}
