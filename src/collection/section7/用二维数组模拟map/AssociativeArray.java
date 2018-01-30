package collection.section7.用二维数组模拟map;

/**
 * @ Author: liuqianshun
 * @ Description:
 *
 * 书483案例
 *
 * @ Date: Created in 2018-01-30
 * @ Modified:
 **/
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0]);
            result.append(":");
            result.append(pairs[i][0]);
            if (i < index - 1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        AssociativeArray<String, String> map = new AssociativeArray<>(6);
        map.put("sky","blue");
        map.put("grass","green");
        map.put("ocean","dancing");
        map.put("tree","tall");
        map.put("earth","brown");
        map.put("sun","warm");

        try {
            map.put("extra","object");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("数据越界");
        }

        System.out.println(map);
        System.out.println(map.get("sky"));
    }

}
