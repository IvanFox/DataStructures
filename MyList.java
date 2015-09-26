/**
 * Created by ivan on 24/09/15.
 * Implementation of a List using generic type of a class
 */
public class MyList <T> {

    T items[];
    int count;

    public MyList(int size){
        items = (T[]) new Object[size];
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
        for (int i = 0; i < count; i++) {
            if (items[i] == el)
                return i;
        }
        return -1;
    }

    public void printElements(){
        for (int i = 0; i < count; i++) {
            System.out.println("[ " + items[i].toString() + " ]");
        }
    }
}
