package dataStructures.list;

import java.util.*;

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
        if ((index > this.size) && (index < 0)) throw new IndexOutOfBoundsException();
        else return false;
    }

    private void deleteFirstElement() {
        first = first.next;
        first.prev = null;
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
        outOfTheRange(index);

        int currPos = 0;
        Item<T> current = first;
        while(currPos != index){
            current = current.getNext();
            currPos++;
        }
        return current;

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
        // BEGIN (write your solution here)

        // END
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        // BEGIN (write your solution here)

        // END
        return null;
    }

    @Override
    public boolean add(final T t) {
        if (first == null) {
            first = new Item<>(t, null, null);
        } else {
            Item<T> current = first;
            Item<T> prev = current;
            while (current.getNext() != null) {
                current = current.getNext();
                prev = current;
            }
            last = new Item<>(t, prev, null);
            current.next = last;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(final Object o) {
        if (first == null) {
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
        for (final T item : c) {
            add(item);
        }
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
            currItem.getPrev().next = currItem.next;
            if (currItem.getNext() != null)
                currItem.getNext().prev = currItem.getPrev();
            else
                last = currItem.getPrev();
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

        int currPos = 0;
        Item<T> currItem = first;

        while (currPos != start) {
            currItem = currItem.getNext();
            currPos++;
        }


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
        // BEGIN (write your solution here)

        // END
        return 0;
    }

    @Override
    public void add(final int index, final T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(final int index, final T element) {
        // BEGIN (write your solution here)

        // END
        return null;
    }

    @Override
    public T get(final int index) {
        outOfTheRange(index);
        int currPos = 0;
        Item<T> currItem = first;
        while (currPos != index) {
            currItem = currItem.getNext();
            currPos++;
        }
        return currItem.getElement();
    }


    private class ElementsIterator implements ListIterator<T> {

        private Item<T> current = first;

        private Item<T> last;


        int currPos = 0;

        public ElementsIterator() {
            this(0);
        }

        public ElementsIterator(final int index) {
            outOfTheRange(index);
            current = first;
            while (currPos != index) {
                current = current.getNext();
                currPos++;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                if (current.getNext() == null) {
                    T elem = current.element;
                    current = null;
                    return elem;
                }
                current = current.getNext();
                currPos++;
                return current.prev.element;
            } else
                throw new NoSuchElementException();
        }

        @Override
        public void add(final T element) {

            LinkedList.this.add(element);
        }

        @Override
        public void set(final T element) {
            if (current.prev == null) {
                throw new IllegalStateException();
            }
            current.prev.element = element;
        }

        @Override
        public int previousIndex() {
            if (current.prev == null)
                return -1;
            return currPos--;
        }

        @Override
        public int nextIndex() {
            return currPos;
        }

        @Override
        public boolean hasPrevious() {
            if (current.prev != null)
                return true;
            return false;
        }

        @Override
        public T previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            currPos--;
            current = current.getPrev();
            return current.element;
        }

        @Override
        public void remove() {
            if (current.prev == null)
                throw new IllegalStateException();
            if (current.prev == first)
                LinkedList.this.deleteFirstElement();
            else
                LinkedList.this.deleteElement(current);

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
