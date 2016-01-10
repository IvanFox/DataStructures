package dataStructures.linked_list;

/**
 * @author IvanLis
 * @version 1.0
 * @since 13/10/15.
 *
 * labs
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

//        System.out.println(linkedList.removeLink(new Car("Opel", "Diesel", 1.8)));

        for (Car car : linkedList) {
            System.out.println(car);
        }

    }

}
