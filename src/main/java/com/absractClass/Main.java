package com.absractClass;

/**
 * Created by agra on 3/30/2017.
 */
public class Main {
    public static void main(String[] args) {
MyLinkList list =new MyLinkList(null);
list.traverse(list.getRoot());

        String stringDate ="Honda Toyota Mazda Porshe Mitsubishi Toyota Ford Lexus";
        String[]data =stringDate.split(" ");
        for(String s:data){
            list.addItem(new Node(s));
        }
        list.traverse(list.getRoot());
    }
}
