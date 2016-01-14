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

        ListImpl<Integer> list = new ListImpl<>();

        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random() * 100));
        }

        list.forEach(System.out::println);
    }
}
