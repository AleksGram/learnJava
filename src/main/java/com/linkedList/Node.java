package linkedList;

/**
 * Created by Грам on 07.03.2017.
 */
 class Node {
    private Node next;
    private Integer data;
    private int index;
    private Node privious;




    public Node(){}

    public Node getPrivious() {
        return privious;
    }

    public void setPrivious(Node privious) {
        this.privious = privious;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public int getIndex(){
        return index;
    }

    public void  setIndex(int index){
        this.index=index;
    }
}
