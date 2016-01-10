package dataStructures.stack;

import java.util.Iterator;

/**
 * Created by ivan on 27/09/15.
 */
public class MyStack<T> implements Iterable<T> {
    T[] items;
    int top;
    final int INITIAL_SIZE = 10;


    public MyStack() {
        items = (T[]) new Object[INITIAL_SIZE];
        top = 0;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public int getSize() {
        return top;
    }

    public void push(T el) {
        increaseSize();
        items[top++] = el;
    }

    public T pop() {
        if (!isEmpty())
            return items[--top];
        return null;
    }

    public void increaseSize() {
        if (top > items.length / 2) {
            T temp[] = items;
            items = (T[]) new Object[temp.length * 2];

            int i = 0;
            while (temp[i] != null) {
                items[i] = temp[i];
                i++;
            }
            temp = null;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>(items, this);
    }

    public static class StackIterator<T> implements Iterator<T> {
        private int index = 0;
        private final T[] items;
        private final MyStack stack;

        public StackIterator(T[] items, MyStack stack) {
            this.items = items;
            this.stack = stack;
        }

        @Override
        public boolean hasNext() {
            return stack.getSize() > index;
        }

        @Override
        public T next() {
            return items[index++];
        }
    }
}
