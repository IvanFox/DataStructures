package dataStructures.circular_queue;

/**
 * Created by IvanLis on 21/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class CircularQ_Demo {

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(new Link(45));
        queue.enqueue(new Link(44));
        queue.enqueue(new Link(43));
        queue.enqueue(new Link(42));
        queue.enqueue(new Link(41));
        queue.display();
        System.out.println("-------------------------------");
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("Deque: -> " + queue.dequeue());
        System.out.println("-------------------------------");
        queue.display();
    }
}
