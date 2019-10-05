package myqueue;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class MyPrioriteQueue {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {


        PriorityQueue<Integer> queue = new PriorityQueue<>((v1,v2)->{
            return v2-v1;
        });


        queue.add(4);
        queue.add(1);
        queue.add(8);

        while (!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }


    }
}
