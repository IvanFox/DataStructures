package DataStructures.queue;

/**
 * Created by IvanLis on 17/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Queue {

    private Link head;
    private Link tail;

    public Queue(Link el) {
        head = el;
        tail = el;

    }

    public Queue() {
        head = null;
        tail = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(Link link){
        if (!isEmpty()){
            tail.setNext(link);
            tail = link;
            tail.setNext(null);
        }
        else{
            head = link;
            tail = link;
        }
    }

    public Link dequeue(){
        if (!isEmpty()){
            Link temp = head;
            head = head.getNext();
            return temp;
        }
        System.out.println("Empty queue!!!");
        return null;
    }


    public void display() {
        Link theLink = head;

        while (theLink != null) {
            System.out.println(theLink.getEl().toString());
            theLink = theLink.getNext();
        }
    }
}
