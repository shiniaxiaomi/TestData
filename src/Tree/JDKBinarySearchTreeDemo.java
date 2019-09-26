package Tree;

import java.util.TreeSet;

/**
 * Created by Yingjie.Lu on 2019/9/26.
 */
public class JDKBinarySearchTreeDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();//其实是一个最大最小堆
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        Integer pollFirst = treeSet.pollFirst();
        System.out.println(pollFirst);
        Integer pollLast = treeSet.pollLast();
        System.out.println(pollLast);
    }
}
