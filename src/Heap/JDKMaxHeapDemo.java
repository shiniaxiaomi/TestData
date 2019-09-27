package Heap;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2019/9/26.
 */
public class JDKMaxHeapDemo {
    //JDK提供的最小堆(可自行提供Comparator接口),其名称叫做优先队列
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(5);
        heap.add(7);
        heap.add(2);
        heap.add(9);
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
