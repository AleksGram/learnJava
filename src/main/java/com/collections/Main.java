package com.collections;

import java.util.*;

/**
 * Created by agra on 4/19/2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>(5, 1, true);
        map.put(5, "a");
        map.put(4, "b");
        map.put(3, "a");
        map.put(2, "d");
        map.put(1, "e");
        map.get(3);
        map.get(5);
        map.get(1);
        System.out.println(map);
        SimpleLRUCashe<Integer, String> newMap = new SimpleLRUCashe<>(2);
        // we set the size of the cash = 2,
        // so when you'll add the 3-rd element, the element wich used more less will be deleted
        newMap.put(1, "a");
        newMap.put(2, "b");
        newMap.put(3, "c");
        newMap.get(2);
        newMap.put(9, "k");
        System.out.println(newMap);

        //weak reference

       /* Map<Object, String> weakMmap = new WeakHashMap<Object, String>();
        Object data = new Object(); // some object
        weakMmap.put(data, "information");

        data = null;   //make available for garbage collection
        System.gc();

        for (int i = 1; i < 10000; i++) {
            if (map.isEmpty()) {
                System.out.println(i + " Empty");
                break;
            }else{
                System.out.println(i + " not empty");
            }



        }*/

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        while(!q.isEmpty()){
            System.out.print( q.poll());
        }

        Queue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer e1, Integer e2) {
            if(e2%2==0){
                return 1;
            }else{
                if(e1%2==0){
                    return -1;
                }
                return 0;
            }


            }
        });
        pQ.add(5);
        pQ.add(2);
        pQ.add(1);
        pQ.add(4);
        pQ.add(3);
        System.out.println();
        while(!pQ.isEmpty()){
            System.out.print( pQ.poll());
        }

    }
}
