package set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class MyHashSet {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(32);
        set.add(4);
        set.add(64);
        set.add(5);
        set.add(1);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
