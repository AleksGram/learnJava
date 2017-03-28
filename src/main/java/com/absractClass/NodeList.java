package com.absractClass;

/**
 * Created by agra on 3/28/2017.
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean remove(ListItem item);
    void traverse(ListItem root);
}
