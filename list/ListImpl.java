package dataStructures.list;

import java.util.*;

/**
 * @author IvanLis
 * @version 1.0
 * @since 12/01/2016.
 * <p>
 * labs
 */
public class ListImpl<T> implements List<T> {
    int DEFAULT_SIZE = 10;
    int size = 0;
    T items[];

    public ListImpl(int size) {
        this.items = (T[]) new Object[size];
    }

    public ListImpl() {
        items = (T[]) new Object[DEFAULT_SIZE];
    }

    private boolean outOfTheRange(int index) {
        if ((index < this.size) && (index > 0)) return true;
        else throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(final Object o) {
        for (T el : this) {
            if (el.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(this.items).iterator();
    }

    @Override
    public Object[] toArray() {
        T copy[] = (T[]) new Object[size];
        System.arraycopy(items, 0, copy, 0, this.size);
        return copy;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size())
            return (T1[]) Arrays.copyOf(this.items, this.size, a.getClass());
        System.arraycopy(items, 0, a, 0, size());
        if (a.length > size()) {
            a[size] = null;
        }
        return a;
    }

    private void increaseSize() {
        T[] copy = (T[]) new Object[(items.length * 3) / 2];
        System.arraycopy(items, 0, copy, 0, items.length);
        items = copy;
    }

    @Override
    public boolean add(final T t) {
        if (size == items.length)
            increaseSize();
        items[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(items[i])) {
                if (i != size - 1) System.arraycopy(items, i + 1, items, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        items = (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public T get(int index) {
        if (outOfTheRange(index)) throw new ArrayIndexOutOfBoundsException();
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        T temp = items[index];
        items[index] = element;
        return temp;
    }

    @Override
    public void add(final int index, final T element) {
        if (size == items.length) increaseSize();

        for (int i = this.size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = element;
        size++;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
