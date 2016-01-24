package dataStructures.trees.binary.immutable;

import java.util.Random;

/**
 * @author IvanLis
 * @version 1.0
 * @since 24/01/2016.
 * <p>
 * labs
 */
public class Demo {

    public static void main(String[] args) {
        final Random random = new Random();

        INode<Integer> root = new NodeImmutable<>(250, null, null);

        for (int i = 0; i < 1000; i++) {
            root = root.add(random.nextInt()%500);
        }

        root.forEach(element -> {
            if (element % 2 == 0 && element > 0)
                System.out.println(element);
        });

        System.out.println("Size is : " + root.count());
    }
}
