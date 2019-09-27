package JDKDemo;

import java.util.Stack;

/**
 * Created by Administrator on 2019/9/27.
 */
public class StackDemo {



    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<10;i++){
            stack.push(i);//入栈
        }

        while(!stack.empty()){
            Integer pop = stack.pop();//出栈
            System.out.println(pop);
        }

    }
}
