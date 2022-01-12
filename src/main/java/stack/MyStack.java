package stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author ivan
 * @version 1.0
 * @since 27/09/15.
 * <p>
 * labs
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
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>();
    }

    public class StackIterator<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return !MyStack.this.isEmpty();
        }

        @Override
        public T next() {
            if (hasNext())
                return (T) MyStack.this.pop();
            else
                throw new NoSuchElementException("No element found");
        }
    }
}
