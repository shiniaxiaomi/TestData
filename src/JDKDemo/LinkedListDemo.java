package JDKDemo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/27.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        //本质实现是链表,增删快,查询慢
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<10;i++){
            list.add(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(list.get(i));//index从0开始
        }
    }
}
