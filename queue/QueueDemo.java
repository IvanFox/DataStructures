package DataStructures.queue;

/**
 * Created by IvanLis on 17/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();


        queue.enqueue(new Link(45));
        queue.enqueue(new Link(43));
        queue.enqueue(new Link(15));
        queue.enqueue(new Link(13));
        queue.enqueue(new Link(12));
        queue.enqueue(new Link(11));
        queue.enqueue(new Link(10));
        queue.display();
        System.out.println("-------------------------------\n");

        System.out.println(queue.dequeue().getEl().toString());
        System.out.println(queue.dequeue().getEl().toString());
        System.out.println(queue.dequeue().getEl().toString());
        System.out.println(queue.dequeue().getEl().toString());
        System.out.println(queue.dequeue().getEl().toString());
        System.out.println("Links left:\n");
        queue.display();
        System.out.println(queue.isEmpty());
    }

}
