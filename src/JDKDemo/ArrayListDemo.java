package JDKDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/9/27.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //本质实现是数组,增删慢,查询快
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<10;i++){
            list.add(i);
        }

        for(int i=0;i<10;i++){
            System.out.println(list.get(i));//index从0开始
        }
    }
}
