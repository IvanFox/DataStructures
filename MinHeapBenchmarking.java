package dataStructures;

import dataStructures.trees.binary.heap.MinHeap;
import org.openjdk.jmh.annotations.Benchmark;

import java.util.Random;

/**
 * @author IvanLis
 * @version 1.0
 * @since 05/02/2016.
 * <p>
 * labs
 */
public class MinHeapBenchmarking {

    public MinHeap<Integer> initMinHeap(){
        final int SIZE = 10_000;
        MinHeap<Integer> minHeap = new MinHeap<>();
        Random rnd = new Random();
        rnd.setSeed(1);
        for (int i = 0; i < SIZE; i++) {
            minHeap.insert(rnd.nextInt());
        }
        return minHeap;
    }

    @Benchmark
    public void testInsertElementsIntoMinHeap(){
        MinHeap<Integer> minHeap = initMinHeap();
    }

    @Benchmark
    public void testDeleteElementsFromMinHeap(){
        MinHeap<Integer> minHeap = initMinHeap();

        while(!minHeap.isEmpty()) {
            minHeap.remove();
        }


    }
}





