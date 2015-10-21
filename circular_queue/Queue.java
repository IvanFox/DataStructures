package DataStructures.circular_queue;

/**
 * Created by IvanLis on 21/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Queue {

    private Link head;
    private Link tail;

    public Queue() {
        head = null;
        tail = null;
    }

    public Queue(Link link) {
        addFirstLink(link);
    }

    public void addFirstLink(Link link) {
        head = link;
        tail = link;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(Link link) {
        if (!isEmpty()) {
            tail.setNext(link);
            tail = link;
            tail.setNext(head);
        }
        else {
            addFirstLink(link);
        }
    }

    public Link dequeue() {
        if (!isEmpty()) {
            Link temp = head;
            head = temp.getNext();
            tail.setNext(head);
            return temp;
        }
        return null;
    }


    public void display() {
        Link current = head;

        do {
            System.out.println(current.getEl().toString());
            current = current.getNext();
        } while(current != head);

    }
}
