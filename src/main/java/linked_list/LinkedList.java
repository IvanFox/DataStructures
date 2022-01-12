package linked_list;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author IvanLis
 * @version 1.0
 * @since 18/01/2016.
 * <p>
 * labs
 */

public class LinkedList<T> implements List<T> {

    private Item<T> first = null;
    private Item<T> last = null;

    private int size;


    private boolean outOfTheRange(int index) {
        if ((index > this.size) || (index < 0) || isEmpty()) throw new IndexOutOfBoundsException();
        else return false;
    }

    private void deleteFirstElement() {
        if (size() == 1) {
            clear();
        } else {
            first = first.next;
            first.prev = null;
        }
        size--;

    }

    private T deleteElement(Item<T> item) {
        item.prev.next = item.getNext();
        // if current is not last one
        if (item.getNext() != null)
            item.getNext().prev = item.getPrev();
        else
            last = item.getPrev();
        size--;
        return item.element;
    }

    private Item<T> getItemByIndex(final int index) {
        if (index < this.size / 2) {
            return getItemByIndexFromStart(index);
        } else return getItemByIndexFromEnd(index);
    }

    private Item<T> getItemByIndexFromStart(final int index) {
        int currPos = 0;
        Item<T> current = first;
        while (currPos != index) {
            current = current.getNext();
            currPos++;
        }
        return current;
    }

    private Item<T> getItemByIndexFromEnd(final int index) {
        int currPos = this.size - 1;
        Item<T> current = last;

        while (currPos != index) {
            current = current.getPrev();
            currPos--;
        }
        return current;
    }

    private void removeItemFromMiddleEnd(Item<T> item) {
        item.getPrev().next = item.next;
        if (item.getNext() != null)
            item.getNext().prev = item.getPrev();
        else
            last = item.getPrev();
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public boolean contains(final Object o) {
        return this.stream().anyMatch(element -> element.equals(o));
    }

    @Override
    public Iterator<T> iterator() {
        return new ElementsIterator();
    }

    @Override
    public Object[] toArray() {
        final T[] newM = (T[]) new Object[this.size()];
        int i = 0;
        for (T element : this)
            newM[i++] = element;
        return newM;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size)
            a = (T1[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        int i = 0;

        Object[] result = a;
        for (Item<T> e = first; e != null; e = e.next)
            result[i++] = e.element;
        if (a.length > size)
            a[size] = null;

        return a;
    }

    @Override
    public boolean add(final T t) {
        if (first == null) {
            first = new Item<>(t, null, null);
            last = first;
        } else {
            Item<T> prev = last;
            last = new Item<>(t, prev, null);
            prev.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        if (isEmpty()) {
            return false;
        }
        // if first element
        if (first.getElement().equals(o)) {
            deleteFirstElement();
            return true;
        }

        Item<T> current = first.getNext();
        while (current != null) {
            if (current.element.equals(o)) {
                deleteElement(current);
                return true;
            }
            current = current.getNext();
        }
        return false;

    }

    @Override
    public boolean containsAll(final Collection<?> c) {
        for (final Object item : c) {
            if (!this.contains(item)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        addAll(c.stream().collect(Collectors.toList()));
        return true;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        for (final Object item : c) {
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        for (final Object item : this) {
            if (!c.contains(item)) this.remove(item);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }


    @Override
    public T remove(final int index) {
        outOfTheRange(index);

        Item<T> currItem = getItemByIndex(index);
        if (currItem == first) {
            deleteFirstElement();
            return currItem.element;
        } else {
            removeItemFromMiddleEnd(currItem);
        }
        size--;
        return currItem.element;
    }

    @Override
    public List<T> subList(final int start, final int end) {
        if (start > end) {
            throw new IllegalArgumentException();
        }
        outOfTheRange(start);
        outOfTheRange(end);

        List<T> subList = new LinkedList<>();
        int currPos = start;
        Item<T> currItem = getItemByIndex(start);

        while (currPos != end) {
            subList.add(currItem.element);
            currItem = currItem.getNext();
            currPos++;
        }
        return subList;
    }

    @Override
    public ListIterator listIterator() {
        return new ElementsIterator(0);
    }

    @Override
    public ListIterator listIterator(final int index) {
        return new ElementsIterator(index);
    }

    @Override
    public int lastIndexOf(final Object target) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(final Object target) {
        Item<T> current = first;
        int currPos = 0;
        while (current.getNext() != null) {
            if (current.equals(target)) {
                return currPos;
            }
            currPos++;
        }
        return -1;
    }

    @Override
    public void add(final int index, final T element) {
        outOfTheRange(index);
        if (index == this.size) { // if adding to the end of collection
            add(element);
        } else {
            Item<T> item = getItemByIndex(index);
            if (item == first) { // if index is pointing to first element
                first.prev = new Item<>(element, null, first);
                first = first.prev;
            } else {
                Item<T> prev = item.getPrev();
                item.prev = new Item<>(element, item, prev);
                prev.next = item.prev;
            }
            size++;
        }
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        Item<T> item = getItemByIndex(index);
        T oldValue = item.element;
        item.element = element;
        return oldValue;
    }

    @Override
    public T get(final int index) {
        outOfTheRange(index);
        Item<T> currItem = getItemByIndex(index);
        return currItem.getElement();
    }


    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current;

        private Item<T> last;


        int currPos;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            if (index != 0) {
                current = getItemByIndex(index);
                currPos = index;
            } else {
                current = first;
                currPos = 0;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                currPos++;
                last = current;
                // if no elements left
                if (current.getNext() == null) {
                    current = null;
                    return last.element;
                }
                current = current.getNext();
                return last.element;
            } else
                throw new NoSuchElementException();
        }

        @Override
        public void add(final T element) {
            LinkedList.this.add(element);
        }

        @Override
        public void set(final T element) {
            if (last == null) {
                throw new IllegalStateException();
            }
            last.element = element;
        }

        @Override
        public int previousIndex() {
            if (last == null)
                return -1;
            return currPos - 1;
        }

        @Override
        public int nextIndex() {
            return currPos;
        }

        @Override
        public boolean hasPrevious() {
            if (last != null)
                return true;
            return false;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            currPos--;
            current = last;
            return current.element;
        }

        @Override
        public void remove() {
            if (last == null)
                throw new IllegalStateException();
            currPos--;
            if (last == first)
                LinkedList.this.deleteFirstElement();
            else
                LinkedList.this.deleteElement(last);
            last = null;
        }

    }

    private static class Item<T> {

        private T element;

        private Item<T> next;

        private Item<T> prev;

        public Item(final T element, final Item<T> prev, final Item<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public T getElement() {
            return element;
        }

        public Item<T> getNext() {
            return next;
        }

        public Item<T> getPrev() {
            return prev;
        }

    }

}
