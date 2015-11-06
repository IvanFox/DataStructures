package DataStructures.circuit_linked_list_array;

/**
 * Created by IvanLis on 22/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class Queue {
    private int head, tail;
    private Link[] array;



    public Queue() {
        array = new Link[10];
        head = 0;
        tail = 0;
    }

    public boolean isEmpty(){
        return head == 0;
    }
}
