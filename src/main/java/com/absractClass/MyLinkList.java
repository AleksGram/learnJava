package com.absractClass;

/**
 * Created by agra on 3/28/2017.
 */
public class MyLinkList implements NodeList {

    private ListItem root =null;

    public MyLinkList(ListItem root) {
        this.root = root;
    }

    public ListItem getRoot() {
        return this.root;
    }

    public boolean addItem(ListItem item) {
        return false;
    }

    public boolean remove(ListItem item) {
        return false;
    }

    public void traverse(ListItem root) {

    }
}
