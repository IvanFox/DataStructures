package dataStructures.queue;

/**
 * @author IvanLis
 * @version 1.0
 * @since 21/12/2015.
 * <p>
 * labs
 */
public class DoubleEndedQueue<T> {

    private int size = 15; // default size
    private int tail;
    private int head;
    private T arr[];


    public DoubleEndedQueue(int size) {
        this.tail = 0;
        this.head = 0;
        this.size = size;
        this.arr = (T[]) new Object[size];
    }

    public DoubleEndedQueue() {
    }

    public boolean isEmpty() {
        return tail == head;
    }


    public void pushFront(T num) {
        if (((head - 1 + size) % size) != tail) {
            head = (head - 1 + size) % size;
            arr[head] = num;
        } else {
            arr = increaseSize();
            pushFront(num);
        }

    }

    public void pushBack(T num) {
        if ((tail + 1) % size == head) {
            arr = increaseSize();
            pushBack(num);
        } else {
            arr[tail] = num;
            tail = ++tail % size;
        }
    }

    public T popFront() {
        if (!isEmpty()) {
            T returnValue = arr[head];
            head = ++head % size;
            return returnValue;
        }
        return null;
    }

    public T popBack() {
        if (!isEmpty()) {
            tail = (--tail + size) % size;
            return arr[tail];
        }
        return null;
    }


    private T[] increaseSize() {
        size *= 2;
        T newArr[] = (T[]) new Object[size];
        int index = 0;
        while (head != tail) {
            newArr[index] = arr[head];
            head = (head + 1 + size) % size;
            index++;
        }
        head = 0;
        tail = index;
        return newArr;
    }
}
