package linkedList;

/**
 * Created by Грам on 07.03.2017.
 */

 public class LinkedList {
  private Node head;
  private Node tail;

     public LinkedList(){}
     int size=0;

    public void add(Integer data){
      Node element = new Node();
       element.setData(data);
        if(tail==null){
            head=element;
            tail=element;
           size+=1;
           element.setIndex(size-1);
        }else{
            tail.setNext(element);
            element.setPrivious(tail);
            tail=element;
            size+=1;
            element.setIndex(size-1);
        }
    }

    public Integer get(int index) {
       // System.out.println("Find me " + index + " element");

        if(head.getIndex()!=index&&tail.getIndex()!=index){
            Node findElement=head;
            while(findElement.getNext()!=null){
                if(findElement.getIndex()==index){
                   // System.out.println("your element is "+findElement.getData());
                    return findElement.getData();
                }
                findElement=findElement.getNext();
            }
        }else if(head.getIndex()==index){
          //  System.out.println("your element is "+head.getData());
            return head.getData();
        }else if (tail.getIndex()==index){
           // System.out.println("your element is "+tail.getData());
            return tail.getData();
        }
        //System.out.println("element is not exist");
        return null;

    }



    public boolean delete(int index) {
        Node findElement = head;
        while (findElement.getNext() != null) {
            if (findElement.getIndex() == index) {
                if (findElement == head) {
                    head = findElement.getNext();
                }

                else if (findElement.getNext().getData() != null) {
                   findElement.getPrivious().setNext(findElement.getNext());
                   findElement.getNext().setPrivious(findElement.getPrivious());
                  }
                size-=1;
                return true;
            }
            findElement = findElement.getNext();
        } if(findElement==tail&&findElement.getIndex()==index){
            tail=findElement.getPrivious();
            tail.setNext(null);
            size-=1;
        }
        return false;
    }


   public void printList(){
       Node print = head;
       while (print!=null){
           System.out.println(print.getData()+" ");
           print=print.getNext();
       }
   }

    private void indexUp(){
        size+=1;

    }

}
