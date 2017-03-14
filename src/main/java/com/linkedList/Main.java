package com.linkedList;

import java.util.Comparator;

/**
 * Created by Грам on 07.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList list =new LinkedList();
      //  list.size();
        list.add(23);
        list.add(34);
        list.size();
        list.add(45);
        list.add(5);
        list.add(45);
        list.printList();
       // list.get(9);
        System.out.println("========================");
        list.size();
        list.delete(4);
        list.size();
        list.printList();


new Comparator() {
    public int compare(Object o1, Object o2) {
        return 0;
    }

};
    }
}
