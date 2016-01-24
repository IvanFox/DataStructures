package dataStructures.map;

/**
 * @author IvanLis
 * @version 1.0
 * @since 23/01/2016.
 * <p>
 * labs
 */
import java.util.*;
import java.util.stream.Collectors;

public class ArrayBasedMap<K, V> implements Map<K, V> {

    private List<Pair> values = new ArrayList<>();

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public boolean isEmpty() {
       return values.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Pair pair : this.values) {
            if (pair.getKey().equals(key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for(Pair pair : this.values) {
            if (pair.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Pair pair : this.values) {
            if (pair.getKey().equals(key)){
                return pair.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        for (Pair pair : this.values) {
            if (pair.getKey().equals(key)) {
                V oldVal = pair.value;
                pair.value = value;
                return oldVal;
            }
        }
        values.add(new Pair(key, value));
        return null;
    }

    @Override
    public V remove(Object key) {
        for (Pair pair : this.values) {
            if (pair.getKey().equals(key)) {
                V oldVal = pair.getValue();
                values.remove(pair);
                return oldVal;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : (Set<Map.Entry<K, V>>)(Set)m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public void clear() {
        values = new ArrayList<>();
    }

    @Override
    public Set<K> keySet() {
        final Set<K> keys = new HashSet<K>();
        for (Pair p : values) keys.add(p.getKey());
        return keys;
    }

    @Override
    public Collection<V> values() {
        return this.values.stream().map(Pair::getValue).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return (Set<Entry<K, V>>)(Set)new HashSet<>(values);
    }

    private class Pair implements Map.Entry<K, V> {

        private final K key;

        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            final V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            Map.Entry<K, V> pair = (Map.Entry<K, V>) o;


            if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) return false;
            return !(value != null ? !value.equals(pair.getValue()) : pair.getValue() != null);

        }

        @Override
        public int hashCode() {
            return (key   == null ? 0 :   key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }
    }
}
