package dataStructures.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by ivan on 24/09/15.
 * Implementation of a List using generic type of a class
 */
public class MyList <T> implements Iterable<T>{

    private T items[];
    private int count;
    final int INITIAL_SIZE = 5;

    public MyList(){
        items = (T[]) new Object[INITIAL_SIZE];
        count = 0;
    }

    public int getSize(){
        return count;
    }

    private boolean checkRange(int index){
        return index <= count && index >= 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    public T set(int index, T el){
        if (checkRange(index)){
            T temp = items[index];
            items[index] = el;
            return temp;
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }

    public T get(int index){
        if (checkRange(index) && !isEmpty()){
            return items[index];
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }

    public void add(int index, T el){
        increaseSize();
        if (checkRange(index)){
            for (int i = count; i > index ; i--) {
                items[i] = items[i-1];
            }

            items[index] = el;
            count++;
        }
    }

    // add new element to the end
    public void add(T el){
        increaseSize();
        if (count != items.length)
            items[count++] = el;
        else
            System.out.println("List is full");
    }

    public T remove(int index){
        if(checkRange(index) && !isEmpty()){
            T temp = items[index];
            for (int i = index; i < count; i++) {
                items[i] = items[i + 1];
            }
            count--;
            return temp;
        }
        System.out.println("index " + index + ": not exist");
        return null;
    }

    public int indexOf(T el){
        int sentinel = 0;
        while (sentinel != count && items[sentinel] != el) {
           sentinel++;
        }
        if (sentinel == count){
            return -1;
        }
        return sentinel;
    }

    public void increaseSize(){
        if(count > items.length / 2) {
            T temp[] = items;
            items = (T[]) new Object[temp.length * 2];

            int i = 0;
            while (temp[i] != null) {
                items[i] = temp[i];
                i++;
            }
        }
    }

    public void printElements(){
        for (int i = 0; i < count; i++) {
            System.out.println("[ " + items[i].toString() + " ]");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(items).iterator();
    }
}
