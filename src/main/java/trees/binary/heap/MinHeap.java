package trees.binary.heap;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author IvanLis
 * @version 1.0
 * @since 27/01/2016.
 * <p>
 * labs
 */
public class MinHeap<T extends Comparable> implements  Heap<T>, Iterable<T> {

    T items[];
    int size = 0;

    final int ROOT = 1;
    final int INITIAL_SIZE;


    public MinHeap() {
        this.INITIAL_SIZE = 10;
        items = (T[]) new Comparable[INITIAL_SIZE];

    }

    public MinHeap(int initialSize) {
        this.INITIAL_SIZE = initialSize;
        items = (T[]) new Comparable[INITIAL_SIZE];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    private boolean isFull() {
        return this.size == items.length-1;
    }

    private void increaseSize() {
        T copy[] = (T[]) new Comparable[items.length * 3 / 2];
        System.arraycopy(items, 0, copy, 0, items.length);
        items = copy;
    }

    public void insert(T element) {
        if (isFull()) {
            increaseSize();
        }
        items[++size] = element;
        upHeap(size);
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        T element = items[ROOT];
        items[ROOT] = items[size--];
        downHeap(ROOT);
        return element;

    }

    private void downHeap(int currentPos) {
        while (currentPos <= size / 2) {
            int i = currentPos * 2;
            if (i < this.size && items[i].compareTo(items[i + 1]) > 0) {
                ++i;
            }

            if (items[currentPos].compareTo(items[i]) > 0) {
                swap(currentPos, i);
            }
            currentPos = i;
        }
    }

    private void upHeap(int currentPos) {
        while (currentPos > 1) {
            int parent = currentPos / 2;
            if (items[currentPos].compareTo(items[parent]) < 1) {
                swap(currentPos, parent);
                currentPos = parent;
            } else
                break;
        }
    }


    private void swap(int pos, int pos2) {
        T temp = items[pos];
        items[pos] = items[pos2];
        items[pos2] = temp;
    }

    public T peek() {
        return items[ROOT];
    }

    @Override
    public Iterator<T> iterator() {
        return new MinHeapIterator();
    }


    private class MinHeapIterator implements Iterator<T> {


        @Override
        public boolean hasNext() {
            return !isEmpty();
        }

        @Override
        public T next() {
            return MinHeap.this.remove();
        }
    }
}
