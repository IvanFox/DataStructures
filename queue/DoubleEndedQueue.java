package dataStructures.queue;

/**
 * @author IvanLis
 * @version 1.0
 * @since 21/12/2015.
 * <p>
 * labs
 */
public class DoubleEndedQueue {

    private int size;
    private int tail;
    private int head;
    private int arr[];

    public DoubleEndedQueue(int size) {
        this.tail = 0;
        this.head = 0;
        this.size = size;
        this.arr = new int[size];
    }

    public boolean isEmpty() {
        return tail == head;
    }

    public boolean isFull() {
        return (head + tail) % size == 1;
    }

    private static int unsignValue(int num) {
        return num < 0 ? num * -1 : num;
    }

    public void pushFront(int num) {
        if (((head - 1 + size) % size) != tail) {
            head = (head - 1 + size) % size;
            arr[head] = num;
        }
        else {
            arr = increaseSize();
            pushFront(num);
        }

    }

    public void pushBack(int num) {
        if ((tail+1) % size == head) {
            arr = increaseSize();
            pushBack(num);
        }
        else {
            arr[tail] = num;
            tail = ++tail % size;
        }
    }

    public int popFront() {
        if (!isEmpty()) {
            int returnValue = arr[head];
            head = ++head % size;
            return returnValue;
        }
        return -1;
    }

    public int popBack() {
        if (!isEmpty()) {
            return arr[--tail];
        }
        return -1;
    }


    private int[] increaseSize() {
        size *= 2;
        int newArr[] = new int[size];
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

    public static void main(String[] args) {
        DoubleEndedQueue dec = new DoubleEndedQueue(5);
        dec.pushBack(1);
        dec.pushBack(2);
        dec.pushBack(3);
        System.out.println(dec.popFront());
        System.out.println(dec.popFront());
        System.out.println(dec.popFront());
        dec.pushBack(4);
        dec.pushFront(5);
        dec.pushFront(6);
        dec.pushFront(7);
        dec.pushFront(8);
//        System.out.println(dec.popBack());
//        dec.printElements();
//        System.out.println(dec.popFront());
//        System.out.println(dec.popFront());
//        System.out.println(dec.popFront());
//        System.out.println(dec.popFront());
//        System.out.println(dec.popFront());
//        System.out.println(dec.popFront());



    }
}
