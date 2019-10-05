package set;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class MyLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
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
