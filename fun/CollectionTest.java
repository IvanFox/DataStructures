package dataStructures.fun;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.Collection;

/**
 * @author IvanLis
 * @version 1.0
 * @since 10/01/2016.
 * <p>
 * labs
 */
public class CollectionTest {


    @Benchmark
    public void testArrayCollectionAddMethod() {
        final int SIZE = 10_000;
        final ArrayCollection<Integer> intList = new ArrayCollection<>();

        for (int i = 0; ++i < SIZE; )
            intList.add(i);
    }

    @Benchmark
    public void testRemoveFromEndMethod() {
        final int SIZE = 10_000;
        final Integer items[] = new Integer[SIZE];

        for (int i = 0; ++i < SIZE; ) {
            items[i] = i;
        }

        final Collection<Integer> integerList = new ArrayCollection<>(items);
        for (int i = SIZE; i >= 0; i--) {
            integerList.remove(i);
        }
    }

    @Benchmark
    public void testRemoveFromStartMethod() {
        final int SIZE = 10_000;
        final Integer[] items = new Integer[SIZE];

        for (int i = 0; i < SIZE; i++) {
            items[i] = i;
        }
        ArrayCollection<Integer> arrCollection = new ArrayCollection<>(items);
        for (int i = 0; i < SIZE; i++) {
            arrCollection.remove(i);
        }

    }
}
