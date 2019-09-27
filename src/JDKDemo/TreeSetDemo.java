package JDKDemo;

import java.util.TreeMap;

/**
 * Created by Administrator on 2019/9/27.
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        //本质上使用了红黑树的排序二叉树的数据结构
        TreeMap<String,String> treeMap = new TreeMap();
        treeMap.put("1","111111");
        treeMap.put("3","333333");
        treeMap.put("2","222222");

        String s = treeMap.firstKey();
        System.out.println(treeMap.get(s));

        String s1 = treeMap.lastKey();
        System.out.println(treeMap.get(s1));

    }

}
