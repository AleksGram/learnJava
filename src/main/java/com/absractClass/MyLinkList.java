package com.absractClass;

/**
 * Created by agra on 3/28/2017.
 */
public class MyLinkList implements NodeList {

    private ListItem root = null;

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
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, adding aborted");
                return false;
            }

        }
        return false;
    }

    public boolean remove(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem=this.root;
        while (currentItem!=null){
            int comparison=currentItem.compareTo(item);
            if(comparison==0){
                if(currentItem==this.root){
                    this.root=currentItem.next();
                }else{
                    currentItem.previous().setNext(currentItem.next());
                }
            }
        }

    }

    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {

            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }

        }
    }
}