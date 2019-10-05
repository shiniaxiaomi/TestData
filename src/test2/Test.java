package test2;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Test {

    public static void main(String[] args) {

//        ArrayQueue queue=new ArrayQueue(100);

        Queue queue=new ArrayBlockingQueue(100);
        for(int i=0;i<90;i++){
            queue.add(i);
        }

        Provider provider = new Provider(queue);
        Provider provider1 = new Provider(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(provider).start();
        new Thread(provider1).start();
        new Thread(consumer).start();

    }
}
