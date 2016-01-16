package dataStructures.list;

import java.util.*;

/**
 * @author IvanLis
 * @version 1.0
 * @since 12/01/2016.
 * <p>
 * labs
 */
// ArrayList implementation
public class ListImpl<T> implements List<T> {
    private int DEFAULT_SIZE = 10;
    private int index = 0;
    int size = 0;
    T items[];

    public ListImpl(int size) {
        this.items = (T[]) new Object[size];
    }

    public ListImpl() {
        items = (T[]) new Object[DEFAULT_SIZE];
    }

    private boolean outOfTheRange(int index) {
        if ((index > this.size) && (index < 0)) throw new IndexOutOfBoundsException();
        else return false;
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
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > size - 1 ||  toIndex < size) {
            throw new IndexOutOfBoundsException();
        }

        List<T> list = new ListImpl<>();
        for (int i = fromIndex; i < toIndex; i++) {
            list.add(this.items[i]);
        }
        return list;

    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
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
                if (i != size - 1)
                    System.arraycopy(items, i + 1, items, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!contains(item))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        c.forEach(this::remove);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(this::remove);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        this.stream().filter(item -> !c.contains(item)).forEach(this::remove);
        return true;
    }

    @Override
    public void clear() {
        items = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
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
        if (!outOfTheRange(index)) {
            if (size == items.length) increaseSize();
            if (index != size)
                System.arraycopy(this.items, index, this.items, index + 1, this.size - index);
            items[index] = element;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (!outOfTheRange(index)) {
            T element = this.items[index];
            if (index != size - 1)
                System.arraycopy(items, index + 1, items, index, size - index - 1);
            size--;
            return element;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(this.items[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(this.items[i]))
                pos = i;
        }
        return pos;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new MyListIterator(index);
    }


    // implementing listIterator

    private class MyListIterator implements ListIterator<T> {

        private int index;

        public MyListIterator() {
            this(0);
        }

        public MyListIterator(final int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return ListImpl.this.size() > index;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return ListImpl.this.items[index++];
        }

        @Override
        public void add(final T element) {
            ListImpl.this.add(index, element);
        }

        @Override
        public void set(final T element) {
            if (index - 1 == -1) throw new IllegalStateException();
            ListImpl.this.set(index - 1, element);
        }

        @Override
        public int previousIndex() {
            if (index == 0) return -1;
            return index - 1;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public boolean hasPrevious() {
            if (index > 0) return true;
            return false;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            index--;
            return ListImpl.this.items[index];
        }

        @Override
        public void remove() {
            if (index - 1 == -1)
                throw new IllegalStateException();
            ListImpl.this.remove(--index);
        }

    }
}
