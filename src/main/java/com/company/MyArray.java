package com.company;

import java.util.Scanner;

/**
 * Created by Грам on 30.01.2017.
 */
public class MyArray {

    public MyArray() {
    }

    public int[] getArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i <= (array.length - 1); i++) {
            System.out.println("Type " + (i + 1) + " number");
            Scanner scan = new Scanner(System.in);
            array[i] = scan.nextInt();
        }
        return array;
    }

    public void showArray(int[] array) {
        for (int i = 0; i <= (array.length - 1); i++) {
            System.out.println("The " + (i + 1) + " value is " + array[i]);
        }
        System.out.println("///////////000////////////");
    }

    public int[] ascendingSortArray(int[] array) {
        int tempVal;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1); j++) {
                if (array[i] < array[j]) {
                    tempVal = array[i];
                    array[i] = array[j];
                    array[j] = tempVal;
                }
            }
        }
        return array;
    }
    public int[] descendingSortArray(int[] array) {
        int tempVal;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1); j++) {
                if (array[j] < array[i]) {
                    tempVal = array[j];
                    array[j] = array[i];
                    array[i] = tempVal;
                }
            }
        }
        return array;

    }

}