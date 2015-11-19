package dataStructures.circuit_linked_list;

/**
 * Created by IvanLis on 21/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class CircuitLinkedList<T>{

    private Link head;

    public CircuitLinkedList(Link firstLink) {
        this.head = firstLink;
        firstLink.setNext(head);
    }

    public CircuitLinkedList() {
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertNewLink(Link link){
        if (!isEmpty()){
            Link current = head;
            while(current.getNext() != head){
                current = current.getNext();
            }
            current.setNext(link);
            link.setNext(head);
        }
        else{
            head = link;
            head.setNext(head);
        }
    }

    public Link removeFirst(){
        Link deletedLink = head;
        if(!isEmpty()){
            head = head.getNext();
        }
        else
            System.out.println("Empty link list");
        return deletedLink;
    }

    public Link removeLink(T object){
        if(!isEmpty()){
            Link previousLink;
            Link currentLink = head;

            if (head.getEl().equals(object)){
                removeFirst();
            }

            while(currentLink.getNext() != head){
                previousLink = currentLink;
                currentLink = currentLink.getNext();
                if (currentLink.getEl().equals(object)){
                    previousLink.setNext(currentLink.getNext());
                    return currentLink;

                }
            }
        }
        return null;

    }

    public void display(){
        Link theLink = head;
        System.out.println(theLink.getEl().toString());

        while(theLink.getNext() != head){
            System.out.println(theLink.getNext().getEl().toString());
            theLink = theLink.getNext();
        }
    }
}
