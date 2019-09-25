package Queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Administrator on 2019/9/25.
 */
public class JDKQueueDemo {

    public static void main(String[] args) {
        //双端队列
        ArrayDeque<Object> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast(1);
        arrayDeque.addLast(2);
        arrayDeque.addLast(3);
        arrayDeque.add(4);//add默认加载尾部
        Object poll1 = arrayDeque.poll();//poll默认弹出头部
        System.out.println(poll1);
        Object last = arrayDeque.getLast();
        System.out.println(last);
        Object first = arrayDeque.getFirst();
        System.out.println(first);


        //优先队列
        // 定义比较的规则(按照降序, 即最大堆)
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);//创建优先队列
        priorityQueue.add(1);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(3);

        while (!priorityQueue.isEmpty()) {
            Object poll = priorityQueue.poll();
            System.out.println(poll);
        }
    }


}
