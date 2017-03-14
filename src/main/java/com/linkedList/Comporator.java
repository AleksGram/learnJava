package com.linkedList;

/**
 * Created by agra on 3/14/2017.
 */
public class Comporator {
    public int compare(int a, int b){
        if (a>b) {
            return 1;
        } else if (a == b){
            return 0;
        } else {
            return -1;
        }
    }
}
