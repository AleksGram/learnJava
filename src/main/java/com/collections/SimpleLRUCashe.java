package com.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by agra on 4/21/2017.
 */
public class SimpleLRUCashe <K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public SimpleLRUCashe (int capacity){
        super (capacity+1, 1.1f, true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size()>capacity;
    }
}
