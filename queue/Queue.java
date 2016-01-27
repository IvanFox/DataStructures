package dataStructures.queue;

/**
 * Created by IvanLis on 17/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Queue <T> {

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

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(T element) {
        Link<T> link = new Link<>(element);
        if (!isEmpty()) {
            tail.setNext(link);
            tail = link;
            tail.setNext(null);
        } else {
            head = link;
            tail = link;
        }
    }

    public Link dequeue() {
        if (!isEmpty()) {
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

    private class Link <T> {

        private T el;

        private Link next;

        public Link(T el) {
            this.el = el;
            next = null;
        }

        public T getEl() {
            return el;
        }

        public void setEl(T el) {
            this.el = el;
        }


        public void setNext(Link next) {
            this.next = next;
        }

        public Link getNext() {
            return next;
        }
    }

}
