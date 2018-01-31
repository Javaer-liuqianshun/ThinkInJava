package collection.section9.简单散列Map;

import java.util.*;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书493案例
 *
 * 通过计算键的hashcode值,然后hashcode%某个值,把该键划分到数组中的某个链表list里面,
 * 查找时,因为键一样,所以直接定位到某个链表list中.
 *
 * 这就是散列查找速度快的原因
 *
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class SimpleHashMap<K, V> extends AbstractMap<K, V> {

    private static final int SIZE = 997;
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) {
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) {
                continue;
            }
            for (MapEntry<K,V> mpair:bucket){
                set.add(mpair);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.put("bj","bj");
        m.put("sc","cd");
        m.put("cq","cq");
        m.put("gd","gz");
        System.out.println(m);
        System.out.println(m.get("sc"));
        System.out.println(m.entrySet());
    }
}
