package HashTable;

import java.util.Hashtable;

/**
 * Created by Yingjie.Lu on 2019/9/27.
 */
public class JDKHashTableDemo {
    public static void main(String[] args) {
        //和HashMap一样,他是线程安全的,而HashMap不是
        //他们内部都是用链表来解决hash冲突
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        hashtable.put("you",10);
        Integer you = hashtable.get("you");
        System.out.println(you);
        int size = hashtable.size();
        System.out.println(size);
    }
}
