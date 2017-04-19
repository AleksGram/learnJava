package com.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by agra on 4/19/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map =new LinkedHashMap<>(5,1,true);
        map.put(5,"a");
        map.put(4,"b");
        map.put(3,"a");
        map.put(2,"d");
        map.put(1,"e");
        map.get(3);
        map.get(5);
        map.get(1);
        System.out.println(map);
    }
}
