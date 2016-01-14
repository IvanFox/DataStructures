package dataStructures.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ivan on 24/09/15.
 * Implementation of a List using generic type of a class
 */
public class MyList<T> implements Iterable<T> {

    private T items[];
    private int count;
    final int INITIAL_SIZE = 5;

    public MyList() {
        items = (T[]) new Object[INITIAL_SIZE];
        count = 0;
    }

    public int getSize() {
        return count;
    }

    private boolean checkRange(int index) {
        return index <= count && index >= 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public T set(int index, T el) {
        if (checkRange(index)) {
            T temp = items[index];
            items[index] = el;
            return temp;
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }

    public T get(int index) {
        if (checkRange(index) && !isEmpty()) {
            return items[index];
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }

    public void add(int index, T el) {
        if (isFull()) increaseSize();

        if (checkRange(index)) {
            for (int i = count; i > index; i--) {
                items[i] = items[i - 1];
            }

            items[index] = el;
            count++;
        }
    }

    // add new element to the end
    public void add(T el) {
        if (isFull())
            increaseSize();
        items[count++] = el;
    }

    public T remove(int index) {
        if (checkRange(index) && !isEmpty()) {
            T temp = items[index];
            if (count - 1 != index) {
                for (int i = index; i < count - 1; i++) {
                    items[i] = items[i + 1];
                }
            }
            count--;
            return temp;
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }


    public int indexOf(T el) {
        int sentinel = 0;
        while (sentinel != count && items[sentinel] != el) {
            sentinel++;
        }
        if (sentinel == count) {
            return -1;
        }
        return sentinel;
    }

    public void increaseSize() {
        T temp[] = items;
        items = (T[]) new Object[temp.length * 2];

        System.arraycopy(temp, 0, items, 0, count);

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }


    private class ListIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return MyList.this.getSize() > index;
        }

        @Override
        public T next() {
            if (hasNext())
                return MyList.this.items[index++];
            else
                throw new NoSuchElementException("No element found");
        }
    }
}
