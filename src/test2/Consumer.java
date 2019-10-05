package test2;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;
import java.util.Queue;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Consumer implements Runnable{

    public Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            if(!queue.isEmpty()){
                queue.poll();
                System.out.println("消费:"+queue.size());
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }



}
