package dataStructures.trees.binary.heap;

import java.util.Iterator;

/**
 * @author IvanLis
 * @version 1.0
 * @since 28/01/2016.
 * <p>
 * labs
 */
public interface Heap<T> {

    boolean isEmpty();

    int size();

    void insert(T element);

    T remove();

    T peek();

    Iterator<T> iterator();

}
