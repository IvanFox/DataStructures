package dataStructures.linked_list;

/**
 * Created by IvanLis on 13/10/15.
 */
public class LinkedListDemo {



    public static void main(String[] args) {
        LinkedList <Car> linkedList = new LinkedList<>();
        linkedList.insertNewLink(new Car("Volvo", "Diesel", 1.8));
        linkedList.insertNewLink(new Car("BMW", "Diesel", 3.0));
        linkedList.insertNewLink(new Car("Mercedes", "Diesel", 1.8));
        linkedList.insertNewLink(new Car("Opel", "Diesel", 1.8));
        linkedList.insertNewLink(new Car("Fiat", "Diesel", 1.8));

//        linkedList.display();
//
//        System.out.println("\n" + linkedList.find(new Car("Fiat", "Diesel", 1.8)));
//        System.out.println();

        System.out.println(linkedList.removeLink(new Car("Opel", "Diesel", 1.8)));
        System.out.println();
        linkedList.display();

    }
}
