package dataStructures.circuit_linked_list;

/**
 * Created by IvanLis on 21/10/15.
 * Student No: c00185055
 * All rights reserved
 */

public class CircuitListDemo {

    public static void main(String[] args) {
        CircuitLinkedList<Integer> circuitLinkedList = new CircuitLinkedList<>();

        circuitLinkedList.insertNewLink(new Link(43));
        circuitLinkedList.insertNewLink(new Link(3));
        circuitLinkedList.insertNewLink(new Link(23));
        circuitLinkedList.insertNewLink(new Link(13));
        circuitLinkedList.insertNewLink(new Link(13));
        circuitLinkedList.insertNewLink(new Link(10));
        circuitLinkedList.display();
        System.out.println("--------------------\n");
        circuitLinkedList.removeLink(10);
        circuitLinkedList.display();

    }
}
