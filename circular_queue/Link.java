package DataStructures.circular_queue;

/**
 * Created by IvanLis on 21/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Link <T> {

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



