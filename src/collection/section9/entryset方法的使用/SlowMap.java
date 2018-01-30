package collection.section9.entryset方法的使用;

import java.util.*;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书490案例
 *
 * Map.Entry<K,V>是Map类中的一个接口,用来封装Map集合中的一组键值对对象
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public V put(K key,V value){
        V oldValue = get(key);
        if (!keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    public V get(Object key){
        if (!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        }
        return set;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        m.put("bj","bj");
        m.put("sc","cd");
        m.put("cq","cq");
        m.put("gd","gz");
        System.out.println(m);
        System.out.println(m.get("sc"));
        System.out.println(m.entrySet());
    }
}
