package myqueue;

import java.util.ArrayDeque;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class MyArrayDeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(4);
        deque.add(1);
        deque.add(8);

        while(!deque.isEmpty()){
            System.out.print(deque.poll()+" ");
        }
    }
}
