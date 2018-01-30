package collection.section9.简单散列Map;

import java.util.Map;

/**
 * @ Author: liuqianshun
 * @ Description:
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }
}
