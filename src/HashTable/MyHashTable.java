package HashTable;

import java.util.TreeMap;


public class MyHashTable {

    private TreeMap<String, Integer>[] hashtable;//保存每一个hash函数计算出来后的数据
    private int M;
    private int size;

    public MyHashTable(int M) {
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];//创建一个数组大小为M的哈希数组
        for (int i=0; i<M; i++) {
            hashtable[i] = new TreeMap<>();
        }
    }
    //默认创建一个数组为97的hashTable
    public MyHashTable() {
        this(97);
    }
    //哈希函数,计算散列值
    public int hash(String key) {
        return (key.hashCode() & 0x7ffffff) % M;
    }
    //获取大小
    public int getSize() {
        return size;
    }
    //添加键值对
    public void add(String key, Integer value) {
        TreeMap<String, Integer> map = hashtable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;
        }
    }
    //删除key
    public Integer remove(String key) {
        TreeMap<String, Integer> map = hashtable[hash(key)];
        Integer ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
        }
        return ret;
    }
    //修改key对应的值
    public void set(String key, Integer value) {
        TreeMap<String, Integer> map = hashtable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key+"doesn't exist!");
        }
        map.put(key, value);
    }
    //查询是否包含key
    public boolean contains(String key) {
        return hashtable[hash(key)].containsKey(key);
    }
    //获取key对应的值
    public Integer get(String key) {
        return hashtable[hash(key)].get(key);
    }
    //测试
    public static void main(String[] args) {
        MyHashTable myHashTable = new MyHashTable();

        //添加键值对
        myHashTable.add("like",10);
        myHashTable.add("you",20);
        //获取值
        Integer like = myHashTable.get("like");
        System.out.println(like);
        //获取大小
        int size = myHashTable.getSize();
        System.out.println(size);
        //是否包含key
        boolean contains = myHashTable.contains("you");
        System.out.println(contains);
    }

}
