package dataStructures.set;

/**
 * @author IvanLis
 * @version 1.0
 * @since 24/01/2016.
 * <p>
 * labs
 */
import java.util.*;

public class HashSet<T> implements Set<T> {

    private static final Boolean EXIST = true;

    private final Map<T, Boolean> elements = new HashMap<>();

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.elements.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
        return elements.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        T[] array = (T[])new Object[this.size()];
        int i = 0;
        for (T item : this.elements.keySet()){
            array[i] = item;
        }
        return array;

    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.elements.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        this.elements.put(t, EXIST);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.elements.remove(o)){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object item : c) {
            if (!this.elements.containsKey(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T item : c) {
            this.elements.put(item, EXIST);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        c.forEach(this.elements::remove);
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        this.stream().filter(item -> !c.contains(item)).forEach(this::remove);
        return true;
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

}
