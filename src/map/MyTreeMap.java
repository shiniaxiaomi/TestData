package map;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class MyTreeMap {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("1","1");
        map.put("8","8");
        map.put("2","2");
        map.put("5","5");
        map.put("3","3");

        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
    }
}
