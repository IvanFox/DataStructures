package dataStructures.queue;

/**
 * Created by IvanLis on 17/10/15.
 * Student No: c00185055
 * All rights reserved
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();


        queue.enqueue(45);
        queue.enqueue(43);
        queue.enqueue(15);
        queue.enqueue(3);
        queue.enqueue(12);
        queue.enqueue(11);
        queue.enqueue(10);
        queue.display();
        System.out.println("-------------------------------\n");

//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
        System.out.println("Links left:\n");
        queue.display();
        System.out.println(queue.isEmpty());
    }

}
