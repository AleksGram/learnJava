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

    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (root != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, adding aborted");

            }

        }
        return false;
    }

    public boolean remove(ListItem item) {
        return false;
    }

    public void traverse(ListItem root) {

    }
}
