package dataStructures.list;

/**
 * @author IvanLis
 * @version 1.0
 * @since 14/01/2016.
 * <p>
 * labs
 */
public class Demo {

    public static void main(String[] args) {

        ListImpl<Double> list = new ListImpl<>();

        for (int i = 0; i < 10; i++) {
            list.add((Math.random() * 100));
        }

        list.add(10.0);
        list.add(11, 11.0);
        list.remove(10.0);
        System.out.println(list.size());
        list.remove(10);
        list.forEach(System.out::println);

        System.out.println("\n\n\n");
        list.subList(3,5).forEach(System.out::println);
    }
}
