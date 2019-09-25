package Stack;

import java.util.Stack;

/**
 * Created by Administrator on 2019/9/25.
 */
public class JDKStackDemo {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack);

        while(!stack.empty()){
            System.out.println(stack.pop());
        }

        Object peek = stack.peek();//只获取但不删除最顶端的元素
    }


}
