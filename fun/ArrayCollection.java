package dataStructures.fun;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author IvanLis
 * @version 1.0
 * @since 10/01/2016.
 * <p>
 * labs
 */
public class ArrayCollection<T> implements Collection<T> {
    private T[] items = (T[]) new Object[1];

    private int size = 0;

    public ArrayCollection(T[] items) {
        this.items = items;
    }

    public ArrayCollection() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] newItems = (T[]) new Object[this.size];
        System.arraycopy(this.items, 0, newItems, 0, this.size);
        return newItems;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size())
            return (T1[])Arrays.copyOf(items, size(), a.getClass());

        System.arraycopy(items, 0, a, 0, size());
        if (a.length > size()) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        if (items.length == size) {
            final T[] oldItems = items;
            items = (T[]) new Object[this.size * 2];
            System.arraycopy(oldItems, 0, items, 0, oldItems.length);
        }
        items[size++] = t;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                if (i != this.size - 1)
                    System.arraycopy(items, i + 1, items, i, this.size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        c.forEach(this::remove);
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        this.stream().filter(item -> !c.contains(item)).forEach(this::remove);
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }

    public class ArrayIterator implements Iterator<T> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return ArrayCollection.this.size() > index;
        }

        @Override
        public T next() {
            return ArrayCollection.this.items[index++];
        }
    }
}