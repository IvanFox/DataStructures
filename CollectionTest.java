package dataStructures;

import dataStructures.linked_list.LinkedList;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.List;

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
        final List<Integer> intList = new LinkedList<>();

        for (int i = 0; ++i < SIZE; )
            intList.add(i);
    }

    @Benchmark
    public void testRemoveFromEndMethod() {
        final int SIZE = 10_000;

        final List<Integer> integerList = new LinkedList<>();
        for (int i = 0; ++i < SIZE; ) {
            integerList.add(i);
        }

    }

    @Benchmark
    public void testRemoveFromStartMethod() {
        final int SIZE = 10_000;

        LinkedList<Integer> arrCollection = new LinkedList<>();
        for (int i = 0; i < SIZE; i++) {
            arrCollection.add(i);
        }
        for (int i = 0; i < SIZE; i++) {
            arrCollection.remove(i);
        }

    }
}
