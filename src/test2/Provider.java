package test2;

import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Yingjie.Lu on 2019/10/5.
 */
public class Provider implements Runnable {


    public int i=0;

    public Queue queue;

    public Provider(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true){
            if(queue.size()>99){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                queue.add(i);
                System.out.println("生产:"+queue.size());
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }




    }
}
